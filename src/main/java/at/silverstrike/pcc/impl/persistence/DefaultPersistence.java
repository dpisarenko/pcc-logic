/**
 * This file is part of Project Control Center (PCC).
 * 
 * PCC (Project Control Center) project is intellectual property of 
 * Dmitri Anatol'evich Pisarenko.
 * 
 * Copyright 2010, 2011 Dmitri Anatol'evich Pisarenko
 * All rights reserved
 *
 **/

package at.silverstrike.pcc.impl.persistence;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.DerbyDialect;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import at.silverstrike.pcc.api.model.Booking;
import at.silverstrike.pcc.api.model.DailyLimitResourceAllocation;
import at.silverstrike.pcc.api.model.Event;
import at.silverstrike.pcc.api.model.InvitationRequest;
import at.silverstrike.pcc.api.model.InvitationRequestStatus;
import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.model.Task;
import at.silverstrike.pcc.api.model.ProcessState;
import at.silverstrike.pcc.api.model.Resource;
import at.silverstrike.pcc.api.model.ResourceAllocation;
import at.silverstrike.pcc.api.model.UserData;
import at.silverstrike.pcc.api.model.Worker;
import at.silverstrike.pcc.api.persistence.Persistence;
import at.silverstrike.pcc.api.tj3bookingsparser.BookingTuple;
import at.silverstrike.pcc.api.tj3deadlinesparser.ProcessEndTimeTuple;

import com.google.inject.Injector;

/**
 * @author Dmitri Pisarenko
 * 
 */
public final class DefaultPersistence implements Persistence {
    private static final double DAILY_LIMIT_IN_HOURS = 8.;
    private static final int MAX_PRIORITY = 500;
    private static final int PRIORITY_INCREASE_STEP = 10;
    public static final String DB_NAME = "pcc";
    // jdbc:derby://localhost:1527/pcc;create=true

    private static final String JDBC_CONN_STRING_EXISTING_DB_TEMPLATE =
            "jdbc:derby://${host}:1527/${db}";
    private static final String JDBC_CONN_STRING_NEW_DB_TEMPLATE =
            "jdbc:derby://${host}:1527/${db};create=true";

    private static final String PROCESS_ID = "${processId}";
    private static final String USER_ID = "${userId}";
    private static final String STATE_BEING_ATTAINED = ":stateBeingAttained";
    private static final String STATE_DELETED = ":stateDeleted";
    private static final String STATE_ATTAINED = ":stateAttained";
    private static final String STATE_SCHEDULED = ":stateScheduled";
    private static final String SUB_PROCESSES_WITH_CHILDREN_HQL_TEMPLATE =
            "from "
                    + "DefaultSchedulingObject p where (p.parent.id = ${processId}) and (state <> "
                    + STATE_DELETED
                    + ") and (state <> "
                    + STATE_ATTAINED
                    + ") and (p.userData.id = ${userId}) order by priority desc";
    private static final String SUB_PROCESSES_WITH_CHILDREN_TOP_LEVEL_HQL =
            "from "
                    + "DefaultSchedulingObject p where (p.parent is null) and (state <> "
                    + STATE_DELETED
                    + ") and (state <> "
                    + STATE_ATTAINED
                    + ") and (p.userData.id = ${userId}) order by priority desc";
    private static final String UNCOMPLETED_TASKS_WITH_ESTIMATED_END_TIME_HQL =
            "from " + "DefaultTask where ((state = "
                    + STATE_SCHEDULED + ") or (state = " + STATE_BEING_ATTAINED
                    + ")) or "
                    + "(estimatedCompletionDateTime is not null))";

    private static final Logger LOGGER = LoggerFactory
            .getLogger(DefaultPersistence.class);

    private Session session;
    private SessionFactory sessionFactory;
    private Configuration config;

    public DefaultPersistence() {
    }

    /**
     * @see at.silverstrike.pcc.api.persistence.Persistence#closeSession()
     */
    @Override
    public void closeSession() {
        if (sessionFactory == null) {
            return;
        }

        final Session sess = sessionFactory.getCurrentSession();
        if (sess.getTransaction().isActive()) {
            sess.getTransaction().commit();
        }

        if (sess.isOpen()) {
            sess.close();
        }
    }

    @Override
    public Booking createBooking() {
        return new DefaultBooking();
    }

    @Override
    public Long createHumanResource(final String aAbbreviation,
            final String aFirstName, final String aMiddleName,
            final String aSurname, final double aDailyMaxWorkTimeInHours) {
        final Transaction tx = session.beginTransaction();
        Long id = null;

        try {
            final DefaultWorker worker = new DefaultWorker();

            worker.setAbbreviation(aAbbreviation);
            worker.setFirstName(aFirstName);
            worker.setMiddleName(aMiddleName);
            worker.setSurname(aSurname);
            worker.setDailyLimitInHours(aDailyMaxWorkTimeInHours);

            session.save(worker);

            tx.commit();

            id = worker.getId();

            LOGGER.debug("{}: dailyMaxWorkTimeInHours: {}", new Object[] {
                    ErrorCodes.M_013_CREATE_HUMAN_RESOURCE2,
                    aDailyMaxWorkTimeInHours });
        } catch (final Exception exception) {
            LOGGER.error(ErrorCodes.M_012_CREATE_HUMAN_RESOURCE, exception);
            tx.rollback();
        }

        return id;
    }

    @Override
    public Task createSubTask(final String aProcessName,
            final Long aParentProcessId,
            final UserData aUser) {
        final Transaction tx = session.beginTransaction();
        Task returnValue = null;

        try {
            final Task newProcess = new DefaultTask();

            newProcess.setUserData(aUser);
            newProcess.setParent(getParentTask(aParentProcessId));
            newProcess.setName(aProcessName);

            newProcess.setPriority(getNextSchedulingObjectPriority(
                    getParentTask(aParentProcessId)));

            final DailyLimitResourceAllocation alloc =
                    new DefaultDailyLimitResourceAllocation();
            final Worker worker = this.getCurrentWorker(aUser);
            alloc.setResource(worker);
            alloc.setDailyLimit(worker.getDailyLimitInHours());
            newProcess
                    .setResourceAllocations(new LinkedList<ResourceAllocation>());
            newProcess.getResourceAllocations().add(alloc);

            session.save(alloc);
            session.save(newProcess);

            tx.commit();

            returnValue = newProcess;
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }
        return returnValue;
    }

    private Task getParentTask(final Long aParentProcessId) {
        Task parentProcess = null;
        if (aParentProcessId != null) {
            parentProcess =
                    (Task) session.get(
                            DefaultTask.class, aParentProcessId);
        }
        return parentProcess;
    }

    @Override
    public Long createTask(final String aProcessName) {
        final Transaction tx = session.beginTransaction();

        final DefaultSchedulingObject task = new DefaultTask();
        task.setName(aProcessName);

        try {
            session.save(task);
            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }

        return task.getId();
    }

    @Override
    public void generateDailyPlans(final Date aNow) {
        final Transaction tx = session.beginTransaction();

        try {
            session.createQuery("delete from DefaultDailySchedule")
                    .executeUpdate();
            session.createSQLQuery(
                    "delete from APP.TBL_DAILY_TO_DO_LIST_TASKSTOCOMPLETETODAY")
                    .executeUpdate();
            session.createQuery("delete from DefaultDailyToDoList")
                    .executeUpdate();
            session.createQuery("delete from DefaultDailyPlan").executeUpdate();

            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error(ErrorCodes.M_010_GENERATE_DAILY_PLANS, exception);
            tx.rollback();
        }

    }

    @SuppressWarnings({ "rawtypes" })
    @Override
    public List<SchedulingObject> getAllNotDeletedTasks(
            final UserData aUser) {
        final List<SchedulingObject> returnValue =
                new LinkedList<SchedulingObject>();
        final Transaction tx = session.beginTransaction();

        try {
            String hql = null;
            if (aUser != null) {
                final String userId = Long.toString(aUser.getId());

                hql =
                        "from DefaultSchedulingObject where ((state <> "
                                + STATE_DELETED
                                + ") and (state <> "
                                + STATE_ATTAINED
                                + ") and (userData.id = ${userId}))".replace(
                                        USER_ID, userId);
            } else {
                hql =
                        "from DefaultSchedulingObject where ((state <> "
                                + STATE_DELETED
                                + ") and (state <> "
                                + STATE_ATTAINED
                                + "))";
            }

            LOGGER.debug("getAllNotDeletedTasks: hql: {}", hql);

            final Query query =
                    session.createQuery(hql);

            query.setParameter(STATE_DELETED.substring(1), ProcessState.DELETED);
            query.setParameter(STATE_ATTAINED.substring(1),
                    ProcessState.ATTAINED);

            final List result = query.list();

            LOGGER.debug("getAllNotDeletedTasks: result.size: {}",
                    result.size());

            for (final Object record : result) {
                if (record instanceof DefaultTask) {
                    LOGGER.debug(
                            "getAllNotDeletedTasks: Task: {}, state: {}",
                            new Object[] { record,
                                    ((DefaultTask) record).getState() });
                    returnValue.add((DefaultSchedulingObject) record);
                }
            }
            tx.commit();

        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }

        return returnValue;
    }

    @SuppressWarnings({ "rawtypes" })
    @Override
    public List<SchedulingObject>
            getChildTasks(final SchedulingObject aParent) {
        final List<SchedulingObject> returnValue =
                new LinkedList<SchedulingObject>();
        final Transaction tx = session.beginTransaction();

        try {
            Query query = null;
            if (aParent != null) {
                query =
                        session.createQuery("from DefaultTask p "
                                + "where (p.parent != null) and "
                                + "(p.parent.id = :parentId) and (state <> "
                                + STATE_DELETED + ") and (state <> "
                                + STATE_ATTAINED + ")");
                query.setParameter("parentId", aParent.getId());
            } else {
                query =
                        session.createQuery("from DefaultTask p "
                                + "where (p.parent is null) and (state <> "
                                + STATE_DELETED + ") and (state <> "
                                + STATE_ATTAINED + ")");
            }

            query.setParameter(STATE_DELETED.substring(1), ProcessState.DELETED);
            query.setParameter(STATE_ATTAINED.substring(1),
                    ProcessState.ATTAINED);

            final List result = query.list();

            for (final Object record : result) {
                if (record instanceof Task) {
                    returnValue.add((Task) record);
                }
            }
            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }

        return returnValue;
    }

    @Override
    public List<SchedulingObject> getChildTasks(final Long aProcessId) {
        final Transaction tx = session.beginTransaction();
        try {
            SchedulingObject process = null;
            if (aProcessId != null) {
                process =
                        (SchedulingObject) session.get(
                                DefaultTask.class, aProcessId);
            }

            tx.commit();
            return this.getChildTasks(process);

        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
            return new LinkedList<SchedulingObject>();
        }
    }

    /**
     * @see at.silverstrike.pcc.api.persistence.Persistence#getSession()
     */
    private Session getSession() {
        if (sessionFactory == null) {
            return null;
        }

        final Session currentSession = sessionFactory.openSession();
        return currentSession;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SchedulingObject> getSubProcessesWithChildren(
            final Long aProcessId, final UserData aUser) {
        List<SchedulingObject> processes = null;

        try {
            final String hql;
            final String userId = Long.toString(aUser.getId());

            LOGGER.debug("getSubProcessesWithChildren, aUser: {}", userId);

            if (aProcessId != null) {
                hql =
                        SUB_PROCESSES_WITH_CHILDREN_HQL_TEMPLATE.replace(
                                PROCESS_ID, aProcessId.toString()).replace(
                                USER_ID, userId);
            } else {
                hql = SUB_PROCESSES_WITH_CHILDREN_TOP_LEVEL_HQL.replace(
                        USER_ID, userId);
            }

            final Query query = session.createQuery(hql);

            query.setParameter(STATE_DELETED.substring(1), ProcessState.DELETED);
            query.setParameter(STATE_ATTAINED.substring(1),
                    ProcessState.ATTAINED);

            processes = (List<SchedulingObject>) query.list();

            if ((aProcessId == null)
                    && ((processes == null) || (processes.size() < 1))) {
                return getAllNotDeletedTasks(aUser);
            }
        } catch (final Exception exception) {
            LOGGER.error("", exception);
        }
        return processes;
    }

    @Override
    public Task getTask(final Object aProcessid) {
        if (aProcessid == null) {
            return null;
        } else {
            return (Task) session.get(DefaultTask.class,
                    (Serializable) aProcessid);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Task> getUncompletedTasksWithEstimatedEndTime() {
        List<Task> processes = new LinkedList<Task>();

        try {
            final Query query =
                    session.createQuery(UNCOMPLETED_TASKS_WITH_ESTIMATED_END_TIME_HQL);

            query.setParameter(STATE_BEING_ATTAINED.substring(1),
                    ProcessState.IS_BEING_ATTAINED);
            query.setParameter(STATE_SCHEDULED.substring(1),
                    ProcessState.SCHEDULED);

            processes = (List<Task>) query.list();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
        }
        return processes;
    }

    @Override
    public void
            handoffProcess(final Long aProcessId, final Long aWorkerId) {
        if (aProcessId == null) {
            LOGGER.error("processId is null");
            return;
        }

        if (aWorkerId == null) {
            LOGGER.error("workerId is null");
            return;
        }

        final Transaction tx = session.beginTransaction();
        try {
            final Task process =
                    (Task) session.load(DefaultTask.class,
                            aProcessId);
            final Worker resource =
                    (Worker) session.load(DefaultWorker.class, aWorkerId);
            final ResourceAllocation allocation =
                    new DefaultResourceAllocation();
            allocation.setResource(resource);

            if (allocation.getId() == null) {
                session.save(allocation);
            } else {
                session.update(allocation);
            }

            if (process.getResourceAllocations() != null) {
                process.getResourceAllocations().clear();
            } else {
                process.setResourceAllocations(new LinkedList<ResourceAllocation>());
            }

            process.getResourceAllocations().add(allocation);

            if (process.getId() == null) {
                session.save(process);
            } else {
                session.update(process);
            }

            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }
    }

    /**
     * @see at.silverstrike.pcc.api.persistence.Persistence#openSession()
     */
    @Override
    public void openSession(final String aHost, final String aUser,
            final String aPassword, final String aDatabase) {
        LOGGER.debug(ErrorCodes.M_001_OPEN_SESSION);
        try {
            tryToOpenSession(getConnectionStringExistingDb(aHost, aDatabase));
            LOGGER.debug(ErrorCodes.M_002_OPEN_SESSION);
        } catch (final RuntimeException exception) {
            LOGGER.debug(ErrorCodes.M_003_OPEN_SESSION, exception);
            tryToCreateDb(exception, aHost, aDatabase);
        } catch (final Throwable exception) {
            LOGGER.debug(ErrorCodes.M_004_OPEN_SESSION, exception);
            tryToCreateDb(exception, aHost, aDatabase);
        }
    }

    private String getConnectionStringExistingDb(final String aHost,
            final String aDb) {
        final String[] searchList = new String[] { "${host}", "${db}" };
        final String[] replacementList = new String[] { aHost, aDb };
        return StringUtils.replaceEach(JDBC_CONN_STRING_EXISTING_DB_TEMPLATE,
                searchList, replacementList);
    }

    private String
            getConnectionStringNewDb(final String aHost, final String aDb) {
        final String[] searchList = new String[] { "${host}", "${db}" };
        final String[] replacementList = new String[] { aHost, aDb };
        return StringUtils.replaceEach(JDBC_CONN_STRING_NEW_DB_TEMPLATE,
                searchList, replacementList);
    }

    @Override
    public void setInjector(final Injector aInjector) {
    }

    @Override
    public void updateBookings(final List<BookingTuple> aBookingTuples,
            final UserData aUserData) {
        final Transaction tx = session.beginTransaction();
        try {
            session.createQuery("delete from DefaultBooking").executeUpdate();

            for (final BookingTuple tuple : aBookingTuples) {
                final Booking booking = tuple.getBooking();

                LOGGER.debug("booking ID: {}", tuple.getBooking().getId());

                final Task process =
                        (Task) session.load(
                                DefaultTask.class,
                                tuple.getProcessId());
                final Resource resource =
                        (Resource) session.load(DefaultResource.class,
                                tuple.getResourceId());

                booking.setProcess(process);
                booking.setResource(resource);
                booking.setUserData(aUserData);

                if (tuple.getBooking().getId() == null) {
                    session.save(booking);
                } else {
                    session.update(booking);
                }

            }
            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }
    }

    @Override
    public void updateTask(final Task aProcess) {
        final Transaction tx = session.beginTransaction();

        try {
            session.update(aProcess);
            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }
    }

    @Override
    public void updateTaskEndTimes(
            final List<ProcessEndTimeTuple> aEndTimeTuples) {
        LOGGER.debug("updateTaskEndTimes, 1");

        final Transaction tx = session.beginTransaction();

        LOGGER.debug("updateTaskEndTimes, 2");

        try {
            for (final ProcessEndTimeTuple tuple : aEndTimeTuples) {
                LOGGER.debug("tuple.getProcessId(): {}", tuple.getProcessId());

                final Task process =
                        (Task) session.load(
                                DefaultTask.class,
                                tuple.getProcessId());

                LOGGER.debug("process ID: {}, process: {}",
                        tuple.getProcessId(), process);

                process.setEstimatedCompletionDateTime(tuple.getEndDateTime());

                session.update(process);
            }

            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }
    }

    private void tryToCreateDb(final Throwable aException, final String aHost,
            final String aDatabase) {
        LOGGER.error("tryToCreateDb, 1, ", aException);

        try {
            LOGGER.error("tryToCreateDb, 2");
            tryToOpenSession(getConnectionStringNewDb(aHost, aDatabase));
            LOGGER.error("tryToCreateDb, 3");
        } catch (final Throwable exception2) {
            LOGGER.error("tryToCreateDb, 4", exception2);
        }
    }

    private void tryToOpenSession(final String aConnectionString)
            throws Throwable {
        LOGGER.debug("tryToOpenSession, 1, aConnectionString: "
                + aConnectionString);

        closeSession();

        LOGGER.debug("tryToOpenSession, 2");

        config = getConfiguration(aConnectionString);

        LOGGER.debug("tryToOpenSession, 3");

        sessionFactory = config.buildSessionFactory();

        LOGGER.debug("tryToOpenSession, 4");

        session = getSession();

        LOGGER.debug("tryToOpenSession, 5");

        getAllNotDeletedTasks(null);

        LOGGER.debug("tryToOpenSession, 6");
    }

    private Configuration getConfiguration(final String aConnectionString) {
        final Configuration cnf = new Configuration();
        cnf.setProperty(Environment.DRIVER,
                "org.apache.derby.jdbc.ClientDriver");
        cnf.setProperty(Environment.URL, aConnectionString);
        cnf.setProperty(Environment.DIALECT, DerbyDialect.class.getName());
        cnf.setProperty(Environment.SHOW_SQL, "false");
        cnf.setProperty(Environment.HBM2DDL_AUTO, "update");
        cnf.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        cnf.setProperty(Environment.USER, "user");
        cnf.setProperty(Environment.PASS, "app");
        cnf.setProperty(Environment.DEFAULT_SCHEMA, "APP");

        cnf.addResource("persistence/DefaultResource.hbm.xml");
        cnf.addResource("persistence/DefaultResourceAllocation.hbm.xml");
        cnf.addResource("persistence/DefaultSchedulingObject.hbm.xml");
        cnf.addResource("persistence/DefaultBooking.hbm.xml");
        cnf.addResource("persistence/DefaultInvitationRequest.hbm.xml");
        cnf.addResource("persistence/DefaultUserData.hbm.xml");
        return cnf;
    }

    @Override
    public void clearDatabase() {
        final Transaction tx = session.beginTransaction();
        try {
            final String[] entitiesToDelete =
                    { "DefaultDailyLimitResourceAllocation",
                            "DefaultResourceAllocation",
                            "DefaultBooking",
                            "DefaultDailyPlan",
                            "DefaultDailySchedule",
                            "DefaultResource",

                            "DefaultEvent",
                            "DefaultMilestone",

                            "DefaultWorker",
                            "TBL_DAILY_TO_DO_LIST_TASKSTOCOMPLETETODAY",
                            "DefaultDailyToDoList",

                            "DefaultTask",
                            "DefaultSchedulingObject",
                            "DefaultUserData", };

            for (final String entityToDelete : entitiesToDelete) {
                LOGGER.debug("clearDatbase, delete from {}", entityToDelete);
                if (entityToDelete.startsWith("TBL_")) {
                    final SQLQuery query =
                            session.createSQLQuery("delete from APP."
                                    + entityToDelete);
                    query.executeUpdate();
                } else {
                    final Query query =
                            session.createQuery("delete from " + entityToDelete);
                    query.executeUpdate();
                }
            }
            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error(ErrorCodes.M_011_CLEAR_DATABASE, exception);
            tx.rollback();
        }
    }

    @Override
    public Resource getResource(final Long aResourceId) {
        if (aResourceId == null) {
            return null;
        } else {
            return (Resource) session.get(DefaultResource.class,
                    (Serializable) aResourceId);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public UserData getUserData() {
        final UserData userData = new DefaultUserData();

        final Query bookingsQuery = session.createQuery("from DefaultBooking");
        final List<Booking> bookings = bookingsQuery.list();
        
        final List<SchedulingObject> schedulingObjects =
                new LinkedList<SchedulingObject>();

        final Query tasksQuery =
                session.createQuery("from DefaultTask");
        final Query eventsQuery =
                session.createQuery("from DefaultEvent");
        final Query milestonesQuery =
                session.createQuery("from DefaultMilestone");

        final List<SchedulingObject> tasks = tasksQuery.list();
        final List<SchedulingObject> events = eventsQuery.list();
        final List<SchedulingObject> milestones = milestonesQuery.list();

        schedulingObjects.addAll(tasks);
        schedulingObjects.addAll(events);
        schedulingObjects.addAll(milestones);

        userData.setBookings(bookings);
        userData.setIdentifier("dp");
        userData.setSchedulingData(schedulingObjects);

        return userData;
    }

    @Override
    public Event createSubEvent(final String aEventName,
            final Long aParentProcessId, final UserData aUser) {
        final Transaction tx = session.beginTransaction();
        Event returnValue = null;

        try {
            final Event newEvent = new DefaultEvent();

            final Task parentTask = getParentTask(aParentProcessId);
            newEvent.setParent(parentTask);
            newEvent.setName(aEventName);
            newEvent.setPriority(getNextSchedulingObjectPriority(parentTask));
            newEvent.setUserData(aUser);

            session.save(newEvent);
            tx.commit();

            returnValue = newEvent;
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }
        return returnValue;
    }

    private boolean deleteSchedulingObject(
            final SchedulingObject aSchedulingObject) {
        final Transaction tx = session.beginTransaction();
        boolean success = false;
        LOGGER.debug("Deleting scheduling object: {}", aSchedulingObject);
        try {
            aSchedulingObject.setState(ProcessState.DELETED);
            session.update(aSchedulingObject);
            tx.commit();
            success = true;
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }
        return success;
    }

    @Override
    public boolean deleteEvent(final Event aEvent) {
        return deleteSchedulingObject(aEvent);
    }

    public Integer getNextSchedulingObjectPriority(
            final SchedulingObject aParent) {
        Integer maxPriority = MAX_PRIORITY;
        try {
            final String hql;
            if (aParent != null) {
                hql =
                        "SELECT MAX(priority) FROM DefaultSchedulingObject WHERE (parent <> null) AND (parent.id = ${parentId})"
                                .replace("${parentId}", aParent.getId()
                                        .toString());
            } else {
                hql =
                        "SELECT MAX(priority) FROM DefaultSchedulingObject WHERE (parent is null)";
            }
            LOGGER.debug("hql priority: {}", hql);

            final Query query = session.createQuery(hql);

            maxPriority = (Integer) query.uniqueResult();
            LOGGER.debug("maxPriority: {}", maxPriority);

            if ((maxPriority == null) && (aParent != null)) {
                maxPriority = aParent.getPriority();
            } else {
                maxPriority = 500;
            }
        } catch (final Exception exception) {
            LOGGER.error("", exception);
        }

        if (maxPriority == null) {
            maxPriority = MAX_PRIORITY;
        }

        return maxPriority + PRIORITY_INCREASE_STEP;
    }

    @Override
    public Worker getCurrentWorker(final UserData aUser) {
        final String resourceName = aUser.getResourceName();
        final String hql =
                "from DefaultWorker where abbreviation = '${resource}'".
                        replace("${resource}", resourceName);

        final Query query = session.createQuery(hql);

        @SuppressWarnings("rawtypes")
        final List list = query.list();
        if (list.size() == 1) {
            return (Worker) list.get(0);
        } else {
            final Worker worker = new DefaultWorker();

            worker.setAbbreviation(resourceName);
            worker.setDailyLimitInHours(DAILY_LIMIT_IN_HOURS);
            worker.setFirstName(resourceName);
            worker.setMiddleName("");
            worker.setSurname("");

            final Transaction tx = session.beginTransaction();

            try {
                session.save(worker);
                tx.commit();
            } catch (final Exception exception) {
                LOGGER.error("", exception);
                tx.rollback();
            }

            return worker;
        }
    }

    @Override
    public boolean hasChildren(final SchedulingObject aObject) {
        Long numberOfChildren = 0L;
        try {
            final String hql;
            hql =
                    "SELECT COUNT(*) FROM DefaultSchedulingObject WHERE parent.id = ${parentId}"
                            .replace("${parentId}", aObject.getId()
                                    .toString());

            final Query query = session.createQuery(hql);
            numberOfChildren = (Long) query.uniqueResult();
            LOGGER.debug("numberOfChildren: {}, task: {}", new Object[] {
                    numberOfChildren, aObject.getName() });
        } catch (final Exception exception) {
            LOGGER.error("", exception);
        }
        return numberOfChildren > 0L;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SchedulingObject> getTopLevelTasks(final UserData aUser) {
        @SuppressWarnings("rawtypes")
        List result = null;
        final Transaction tx = session.beginTransaction();

        try {
            final String hql =
                    "from DefaultSchedulingObject where ((state <> "
                            + STATE_DELETED
                            + ") and (state <> "
                            + STATE_ATTAINED
                            + ")) and (parent is null) and (userData.id = ${userId})"
                                    .
                                    replace(USER_ID,
                                            Long.toString(aUser.getId()));

            LOGGER.debug("getTopLevelTasks: hql: {}", hql);

            final Query query =
                    session.createQuery(hql);

            query.setParameter(STATE_DELETED.substring(1), ProcessState.DELETED);
            query.setParameter(STATE_ATTAINED.substring(1),
                    ProcessState.ATTAINED);

            result = query.list();

            LOGGER.debug("getTopLevelTasks: result.size: {}",
                    result.size());

            tx.commit();

        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }

        return (List<SchedulingObject>) result;
    }

    @Override
    public void
            createInvitationRequest(final String aEmail) {

        final InvitationRequest request = new DefaultInvitationRequest();

        request.setStatus(InvitationRequestStatus.SUBMITTED);
        request.setSubmissionDateTime(new Date());
        request.setEmail(aEmail);

        final Transaction tx = session.beginTransaction();

        try {
            session.save(request);
            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<InvitationRequest> getInvitationRequests() {
        @SuppressWarnings("rawtypes")
        List result = null;
        final Transaction tx = session.beginTransaction();

        try {
            final String hql = "from DefaultInvitationRequest";

            final Query query =
                    session.createQuery(hql);

            result = query.list();

            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }

        return (List<InvitationRequest>) result;
    }

    @Override
    public void
            rejectInvitationRequest(final InvitationRequest aSelectedRequest) {
        final DefaultInvitationRequest request =
                (DefaultInvitationRequest) aSelectedRequest;

        request.setStatus(InvitationRequestStatus.REJECTED);

        final Transaction tx = session.beginTransaction();

        try {
            session.update(request);
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }
    }

    @Override
    public void acceptInvitationRequest(final InvitationRequest aRequest,
            final String aPassword) {
        final DefaultInvitationRequest request =
                (DefaultInvitationRequest) aRequest;

        request.setStatus(InvitationRequestStatus.ACCEPTED);
        request.setPassword(aPassword);

        final DefaultUserData userData = new DefaultUserData();

        userData.setBookings(new LinkedList<Booking>());
        userData.setIdentifier("");
        userData.setPassword(aPassword);
        userData.setSchedulingData(new LinkedList<SchedulingObject>());
        userData.setUsername(aRequest.getEmail());

        final Transaction tx = session.beginTransaction();

        try {
            session.update(request);
            session.save(userData);
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }
    }

    @Override
    public void createSuperUser() {
        final UserData superUser =
                this.getUser(Persistence.SUPER_USER_NAME,
                        Persistence.SUPER_USER_PASSWORD);

        if (superUser == null) {
            final DefaultUserData userData = new DefaultUserData();

            userData.setBookings(new LinkedList<Booking>());
            userData.setIdentifier("");
            userData.setPassword(Persistence.SUPER_USER_PASSWORD);
            userData.setSchedulingData(new LinkedList<SchedulingObject>());
            userData.setUsername(Persistence.SUPER_USER_NAME);

            final Transaction tx = session.beginTransaction();

            try {
                session.save(userData);
            } catch (final Exception exception) {
                LOGGER.error("", exception);
                tx.rollback();
            }
        }
    }

    @Override
    public Long getUserCount() {
        Long result = null;
        final Transaction tx = session.beginTransaction();

        try {
            final String hql = "select count(*) from DefaultUserData";

            final Query query =
                    session.createQuery(hql);

            result = (Long) query.uniqueResult();

            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }

        return result;

    }

    @Override
    public UserData getUser(final String aUserName, final String aPassword) {
        @SuppressWarnings("rawtypes")
        List result = null;
        UserData returnValue = null;
        final Transaction tx = session.beginTransaction();

        try {
            final String hql =
                    "from DefaultUserData where username = '${username}' and password='${password}'"
                            .replace("${username}", aUserName)
                            .replace("${password}", aPassword);

            final Query query =
                    session.createQuery(hql);

            result = query.list();

            if (result.size() > 0) {
                returnValue = (UserData) result.get(0);
            } else {
                returnValue = null;
            }

            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }

        return returnValue;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Booking> getBookings(final UserData aUser) {
        List<Booking> result = null;
        final Transaction tx = session.beginTransaction();

        try {
            final String hql =
                    "from DefaultBooking where userData.id = ${userId}"
                            .replace("${userId}", Long.toString(aUser.getId()));

            final Query query =
                    session.createQuery(hql);

            result = (List<Booking>) query.list();

            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }

        return result;
    }

    @Override
    public void removeUserSchedulingObjects(final UserData aUser) {
        if (aUser == null) {
            LOGGER.debug("Attempt to invoke removeUserSchedulingObjects with null user.");
            return;
        } else if (aUser.getId() == null) {
            LOGGER.debug("Attempt to invoke removeUserSchedulingObjects with user with null ID.");
            return;
        }

        final Transaction tx = session.beginTransaction();

        final String[] queries =
            {
                    "delete from DefaultDailyLimitResourceAllocation",
                    "delete from DefaultResourceAllocation",
                    "delete from DefaultBooking where userData.id = ${userId}",
                    "delete from DefaultDailyPlan where userData.id = ${userId}",
                    "delete from DefaultDailySchedule where userData.id = ${userId}",
                    "delete from DefaultTask where userData.id = ${userId}",
                    "delete from DefaultEvent where userData.id = ${userId}",
                    "delete from DefaultMilestone where userData.id = ${userId}",
                    "delete from DefaultSchedulingObject where userData.id = ${userId}",
                    "delete from DefaultDailyToDoList where userData.id = ${userId}" };

        for (final String curHqlStatement : queries) {
            final String hql =
                        curHqlStatement.replace("${userId}",
                                Long.toString(aUser.getId()));

            final Query query =
                        session.createQuery(hql);

            query.executeUpdate();
        }

        tx.commit();
    }

    @Override
    public Task createTaskStub() {
        return new DefaultTask();
    }

    @Override
    public void exportSchema(final File aFile) {
        final SchemaExport schemaExport = new SchemaExport(this.config);

        schemaExport.setOutputFile(aFile.getAbsolutePath());

        schemaExport.execute(true, true, false, true);
    }

    @Override
    public UserData getUser(final Long aUserId) {
        UserData returnValue = null;
        final Transaction tx = session.beginTransaction();

        try {
            returnValue =
                    (UserData) session.get(DefaultUserData.class, aUserId);

            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }

        return returnValue;
    }

    @Override
    public void updateUser(final UserData aUser) {
        final Transaction tx = session.beginTransaction();

        try {
            session.save(aUser);

            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
            throw new RuntimeException(exception);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserData> getAllusersWithAutomaticScheduling() {
        List<UserData> result = null;
        final Transaction tx = session.beginTransaction();

        try {
            final String hql =
                    "from DefaultUserData where automaticScheduling = true";

            final Query query =
                    session.createQuery(hql);

            result = (List<UserData>) query.list();

            tx.commit();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            tx.rollback();
        }

        return result;
    }

    @Override
    public Task createTransientTask(final String aProcessName,
            final Long aParentProcessId,
            final UserData aUser, final long aTaskId) {
        Task returnValue = null;

        try {
            final DefaultTask newProcess = new DefaultTask();

            newProcess.setId(aTaskId);
            newProcess.setUserData(aUser);
            newProcess.setParent(getParentTask(aParentProcessId));
            newProcess.setName(aProcessName);

            newProcess.setPriority(getNextSchedulingObjectPriority(
                    getParentTask(aParentProcessId)));

            final DailyLimitResourceAllocation alloc =
                    new DefaultDailyLimitResourceAllocation();
            final Worker worker = this.getCurrentWorker(aUser);
            alloc.setResource(worker);
            alloc.setDailyLimit(worker.getDailyLimitInHours());
            newProcess
                    .setResourceAllocations(new LinkedList<ResourceAllocation>());
            newProcess.getResourceAllocations().add(alloc);

            returnValue = newProcess;
        } catch (final Exception exception) {
            LOGGER.error("", exception);
        }
        return returnValue;
    }

    @Override
    public List<Booking>
            updateBookingsTransientMode(
                    final List<BookingTuple> aBookingTuples,
                    final UserData aUserData,
                    final List<SchedulingObject> aSchedulingObjectsToExport) {
        final List<Booking> bookings = new LinkedList<Booking>();

        final Map<Long, SchedulingObject> tasksByIds =
                new HashMap<Long, SchedulingObject>();

        for (final SchedulingObject aSchedulingObject : aSchedulingObjectsToExport) {
            if (aSchedulingObject instanceof Task) {
                tasksByIds.put(aSchedulingObject.getId(), aSchedulingObject);
            }
        }

        try {
            for (final BookingTuple tuple : aBookingTuples) {
                final Booking booking = tuple.getBooking();

                LOGGER.debug("booking ID: {}", tuple.getBooking().getId());

                final SchedulingObject schedulingObject =
                        tasksByIds.get(tuple.getProcessId());

                if (schedulingObject instanceof Task) {
                    final Task process =
                            (Task) schedulingObject;
                    final Resource resource =
                            (Resource) session.load(DefaultResource.class,
                                    tuple.getResourceId());

                    booking.setProcess(process);
                    booking.setResource(resource);
                    booking.setUserData(aUserData);

                    bookings.add(booking);
                }
            }
        } catch (final ClassCastException exception) {
            throw exception;
        } catch (final Exception exception) {
            LOGGER.error("", exception);
        }
        return bookings;
    }

    @Override
    public Event createTransientEvent(final long aId) {
        final DefaultEvent event = new DefaultEvent();
        event.setId(aId);
        return event;
    }

}

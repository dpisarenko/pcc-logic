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

package at.silverstrike.pcc.api.persistence;

import java.io.File;
import java.util.Date;
import java.util.List;

import ru.altruix.commons.api.di.ModuleWithInjectableDependencies;

import at.silverstrike.pcc.api.model.Booking;
import at.silverstrike.pcc.api.model.Event;
import at.silverstrike.pcc.api.model.InvitationRequest;
import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.model.Task;
import at.silverstrike.pcc.api.model.Resource;
import at.silverstrike.pcc.api.model.UserData;
import at.silverstrike.pcc.api.model.Worker;
import at.silverstrike.pcc.api.tj3bookingsparser.BookingTuple;
import at.silverstrike.pcc.api.tj3deadlinesparser.ProcessEndTimeTuple;

public interface Persistence extends ModuleWithInjectableDependencies {
    final String SUPER_USER_PASSWORD = "DCvEu4LKyC";
    final String SUPER_USER_NAME = "dp@sw-dev.at";

    final String HOST_LOCAL = "localhost";
    final String HOST_DEV = "78.47.242.60";
    
    final String DB_DEV = "pcc-dev";
    final String DB_PRODUCTION = "pcc";
    
    void openSession(final String aHost, final String aUser, final String aPassword, final String aDatabase);

    void closeSession();

    Long createTask(final String aProcessName);

    Task createSubTask(final String aProcessName, final Long aParentProcessId,
            final UserData aUser);

 // Used only in tests
    List<SchedulingObject> getAllNotDeletedTasks(final UserData aUser);

    // Used only in tests
    Task getTask(final Object aProcessid);

    void updateTask(final Task aProcess);

 // Used only in tests
    Long createHumanResource(final String aAbbreviation,
            final String aFirstName, final String aMiddleName,
            final String aSurname, final double aDailyMaxWorkTimeInHours);

    List<SchedulingObject> getChildTasks(final SchedulingObject aParent);

    /**
     * Sets the estimate end time dates of the processes.
     * 
     * @param endTimeTuples
     */
    void updateTaskEndTimes(final List<ProcessEndTimeTuple> aEndTimeTuples);

    /**
     * <pre>
     * This method performs following steps:
     * 
     * 1) Start a transaction. 
     * 2) Delete all bookings from all processes. 
     * 3) Add booking information from the given tuples to all referenced 
     * tasks. 
     * 4) Commit transaction.
     * </pre>
     */
    void updateBookings(final List<BookingTuple> aBookingTuples, final UserData aUserData);

    void generateDailyPlans(final Date aNow);

    Booking createBooking();

    /**
     * Returns a list of all tasks, which are not completed yet and have an
     * estimated completion date/time.
     * 
     * Used only in tests
     */
    List<Task> getUncompletedTasksWithEstimatedEndTime();

    /**
     * Returns a list of processes, which
     * 
     * a) are sub-processes of process with the specified ID as their parent
     * process and b) have child processes themselves. Deleted scheduling
     * objects and completed tasks are not returned.
     * 
     * If processId is null, the top-level processes are returned.
     * 
     * Used only in tests
     */
    List<SchedulingObject> getSubProcessesWithChildren(final Long aProcessId,
            final UserData aUser);

    /**
     * Used only in tests
     */
    List<SchedulingObject> getChildTasks(final Long aProcessId);

    /**
     * Assigns the process with the specifid ID to the specified worker.
     * 
     * Used only in tests
     */
    void handoffProcess(final Long aProcessId, final Long aWorkerId);

    /**
     * Used only in tests
     * 
     * Removes all data from the database
     */
    void clearDatabase();

    Resource getResource(final Long aResourceId);

    UserData getUserData();

    // Used only in tests
    Event
            createSubEvent(final String aProcessName,
                    final Long aParentProcessId, final UserData aUser);

    // Used only in tests
    boolean deleteEvent(final Event aEvent);

    Worker getCurrentWorker(final UserData aUser);

    boolean hasChildren(final SchedulingObject aObject);

    List<SchedulingObject> getTopLevelTasks(final UserData aUser);

    void createInvitationRequest(final String aEmail);

    List<InvitationRequest> getInvitationRequests();

    void rejectInvitationRequest(final InvitationRequest aSelectedRequest);

    void acceptInvitationRequest(final InvitationRequest aRequest,
            final String aPassword);

    void createSuperUser();

    Long getUserCount();

    UserData getUser(final String aUserName, final String aPassword);

    List<Booking> getBookings(final UserData aUser);

    void removeUserSchedulingObjects(final UserData aUser);
    
    Task createTaskStub();

    void exportSchema(final File aFile);

    UserData getUser(final Long aUserId);
    
    void updateUser(final UserData aUser);
    
    List<UserData> getAllusersWithAutomaticScheduling();

    Task createTransientTask(final String aProcessName, final Long aParentProcessId,
            final UserData aUser, final long aTaskId);

    List<Booking>
            updateBookingsTransientMode(final List<BookingTuple> aBookingTuples,
                    final UserData aUserData,
                    final List<SchedulingObject> aSchedulingObjectsToExport);

    Event createTransientEvent(final long aId);
    
}

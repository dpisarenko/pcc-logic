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

package at.silverstrike.pcc.projectscheduler;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.conventions.TestConventions;
import ru.altruix.commons.api.di.InjectorFactory;
import ru.altruix.commons.api.di.PccException;

import at.silverstrike.pcc.api.gcaltasks2pccimporter.GoogleCalendarTasks2PccImporter2;
import at.silverstrike.pcc.api.gcaltasks2pccimporter.GoogleCalendarTasks2PccImporter2Factory;
import at.silverstrike.pcc.api.gtasks.GoogleTaskFields;
import at.silverstrike.pcc.api.model.Booking;
import at.silverstrike.pcc.api.model.Resource;
import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.model.Task;
import at.silverstrike.pcc.api.model.DailyPlan;
import at.silverstrike.pcc.api.model.DailySchedule;
import at.silverstrike.pcc.api.model.DailyToDoList;
import at.silverstrike.pcc.api.model.UserData;
import at.silverstrike.pcc.api.persistence.Persistence;
import at.silverstrike.pcc.api.projectscheduler.ProjectExportInfo;
import at.silverstrike.pcc.api.projectscheduler.ProjectScheduler;
import at.silverstrike.pcc.impl.jruby.RubyDateTimeUtils;
import at.silverstrike.pcc.impl.mockpersistence.MockObjectFactory;
import at.silverstrike.pcc.impl.persistence.DefaultPersistence;
import at.silverstrike.pcc.impl.testutils.MockInjectorFactory;

import com.google.inject.Injector;

public final class TestDefaultProjectScheduler {
    private static final String TJ3_PATH = "C:\\Ruby191\\bin\\tj3.bat";
    private static final String DIR = "src/test/resources/at/silverstrike/"
                            + "pcc/test/projectscheduler/";
    private final static Logger LOGGER =
            LoggerFactory.getLogger(TestDefaultProjectScheduler.class);
    private Helper helper = new Helper();

    @Test
    public void testTaskJugglerIIIInvokation01() {
        /**
         * Create persistence
         */
        final Persistence persistence = new MockPersistence01();

        /**
         * Create the injector
         */
        final InjectorFactory injectorFactory =
                new MockInjectorFactory(new MockInjectorModule(persistence));
        final Injector injector = injectorFactory.createInjector();

        /**
         * Get object under test
         */
        final ProjectScheduler objectUnderTest =
                injector.getInstance(ProjectScheduler.class);

        assertNotNull(objectUnderTest);

        final ProjectExportInfo projectInfo = objectUnderTest
                .getProjectExportInfo();

        assertNotNull(projectInfo);

        this.helper.fillProjectInfo01(projectInfo);
        objectUnderTest.setInjector(injector);
        objectUnderTest.setTaskJugglerPath(TJ3_PATH);

        /**
         * Set input data
         */
        objectUnderTest
                .setDirectory(DIR);

        /**
         * Run the method under test
         */
        try {
            objectUnderTest.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
            fail(exception.getMessage());
        }

        /**
         * Verify that TJ3 was successfully invoked and created an output file
         */
        final File bookingsFile =
                new File(DIR + ProjectScheduler.BOOKINGS_FILE);
        final File deadlinesFile =
                new File(DIR + ProjectScheduler.DEADLINE_CSV_FILE);

        assertTrue("Bookings file doesn't exist.", bookingsFile.exists());
        assertTrue("Deadlines file doesn't exist.", deadlinesFile.exists());
    }

    @Test
    public void testRun01() {
        LOGGER.info("");
        LOGGER.info("Starting test case testRun01");
        LOGGER.info("");

        /**
         * Create persistence
         */
        final Persistence persistence = new DefaultPersistence();

        /**
         * Init persistence
         */
        try {
            persistence.openSession(Persistence.HOST_LOCAL, null, null, "pcc");
        } catch (final RuntimeException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }

        /**
         * Empty the database
         */
        persistence.clearDatabase();

        /**
         * Create the injector
         */
        final InjectorFactory injectorFactory =
                new MockInjectorFactory(new MockInjectorModule(persistence));
        final Injector injector = injectorFactory.createInjector();

        /**
         * Get object under test
         */
        final ProjectScheduler objectUnderTest =
                injector.getInstance(ProjectScheduler.class);

        assertNotNull(objectUnderTest);

        final ProjectExportInfo projectInfo = objectUnderTest
                .getProjectExportInfo();

        assertNotNull(projectInfo);

        persistence.createSuperUser();
        final UserData user = persistence.getUser(Persistence.SUPER_USER_NAME,
                Persistence.SUPER_USER_PASSWORD);

        assertNotNull(user);

        this.helper.fillProjectInfo02(projectInfo, persistence, user);

        assertNotNull(projectInfo.getUserData());

        objectUnderTest.setInjector(injector);
        objectUnderTest.setTaskJugglerPath(TJ3_PATH);
        /**
         * Save all task and resource data in the database
         */

        /**
         * Set input data
         */
        objectUnderTest
                .setDirectory(DIR);
        objectUnderTest.setNow(projectInfo.getNow());

        /**
         * Verify that our only tasks exists in the database before invokation
         * of the method under test
         */

        /**
         * Run the method under test
         */
        try {
            objectUnderTest.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
            fail(exception.getMessage());
        }

        /**
         * Verify that now the result of getUncompletedTasksWithEstimatedEndTime
         * contains exactly one task.
         */
        final List<Task> processes =
                persistence.getUncompletedTasksWithEstimatedEndTime();

        Assert.assertNotNull(processes);
        Assert.assertEquals(1, processes.size());

        final Task process = processes.get(0);

        final Date date201010251130 =
                RubyDateTimeUtils.getDate(2010, Calendar.OCTOBER, 25, 11, 30);

        Assert.assertEquals(date201010251130,
                process.getBestEstimatedEndDateTime());
        Assert.assertEquals(date201010251130,
                process.getAverageEstimatedEndDateTime());
        Assert.assertEquals(date201010251130,
                process.getWorstEstimatedEndDateTime());

        /**
         * Verify that daily plan exists
         */
        final String resource =
                projectInfo.getResourcesToExport().get(0).getAbbreviation();

        Assert.assertNotNull(resource);
        Assert.assertFalse(StringUtils.isEmpty(resource));

        final Date date201010250000 =
                RubyDateTimeUtils.getDate(2010, Calendar.OCTOBER, 25, 0, 0);

        final DailyPlan dailyPlan =
                persistence.getDailyPlan(date201010250000, resource);

        Assert.assertNotNull(dailyPlan);

        final DailySchedule schedule = dailyPlan.getSchedule();

        Assert.assertNotNull(schedule);

        final List<Booking> bookings = schedule.getBookings();

        Assert.assertNotNull(bookings);
        Assert.assertEquals(1, bookings.size());

        final Booking booking = bookings.get(0);

        Assert.assertEquals(2.5, booking.getDuration(), TestConventions.DELTA);
        Assert.assertNotNull(booking.getProcess());
        Assert.assertNotNull(booking.getResource());
        Assert.assertNotNull(booking.getUserData());

        final SchedulingObject expectedTask =
                projectInfo.getSchedulingObjectsToExport().get(0);

        Assert.assertEquals(((Task) expectedTask).getName(), booking
                .getProcess().getName());
        Assert.assertEquals(projectInfo.getResourcesToExport().get(0)
                .getAbbreviation(), booking.getResource().getAbbreviation());

        final Date date201010250900 =
                RubyDateTimeUtils.getDate(2010, Calendar.OCTOBER, 25, 9, 0);

        Assert.assertEquals(date201010250900, booking.getStartDateTime());

        Assert.assertEquals(date201010251130, booking.getEndDateTime());

        final DailyToDoList toDoList = dailyPlan.getToDoList();

        Assert.assertNotNull(toDoList);

        final List<Task> tasks = toDoList.getTasksToCompleteToday();

        Assert.assertNotNull(tasks);

        Assert.assertEquals(1, tasks.size());

        final Task task = tasks.get(0);

        Assert.assertEquals(expectedTask.getId(), task.getId());
        Assert.assertEquals(((Task) expectedTask).getName(), task.getName());
    }

    @Test
    public void testDefect201109_1() {
        /**
         * Create persistence
         */
        final Persistence persistence = new DefaultPersistence();

        /**
         * Init persistence
         */
        try {
            persistence.openSession(Persistence.HOST_LOCAL, null, null, "pcc");
        } catch (final RuntimeException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }

        final InjectorFactory injectorFactory =
                new MockInjectorFactory(new MockInjectorModuleDefect201109_1(
                        persistence));
        final Injector injector = injectorFactory.createInjector();

        final List<com.google.api.services.tasks.v1.model.Task> googleTasks =
                getGoogleTasks();

        final List<SchedulingObject> pccTasks =
                importTasks(googleTasks, injector);

        final List<Booking> bookings =
                calculatePlan(injector, persistence, pccTasks);

        Assert.assertNotNull(bookings);
        Assert.assertEquals(5, bookings.size());
        
        
    }

    private List<Booking> calculatePlan(final Injector aInjector,
            final Persistence aPersistence,
            final List<SchedulingObject> aPccTasks) {
        final ProjectScheduler objectUnderTest =
                aInjector.getInstance(ProjectScheduler.class);

        assertNotNull(objectUnderTest);

        final ProjectExportInfo projectInfo =
                getProjectInfo(aPersistence, aPccTasks, objectUnderTest);

        objectUnderTest.setInjector(aInjector);
        objectUnderTest.setTaskJugglerPath(TJ3_PATH);
        objectUnderTest.setTransientMode(true);
        objectUnderTest
                .setDirectory(DIR);
        objectUnderTest.setNow(projectInfo.getNow());

        try {
            objectUnderTest.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
            fail(exception.getMessage());
        }

        final List<Booking> bookings = objectUnderTest.getBookings();

        return bookings;
    }

    private ProjectExportInfo getProjectInfo(final Persistence persistence,
            final List<SchedulingObject> pccTasks,
            final ProjectScheduler objectUnderTest) {
        final ProjectExportInfo projectInfo = objectUnderTest
                .getProjectExportInfo();

        assertNotNull(projectInfo);

        persistence.createSuperUser();
        final UserData user = persistence.getUser(Persistence.SUPER_USER_NAME,
                Persistence.SUPER_USER_PASSWORD);

        assertNotNull(user);

        final List<Resource> resources = getResources(persistence);

        projectInfo.setSchedulingObjectsToExport(pccTasks);
        projectInfo.setResourcesToExport(resources);
        projectInfo.setCopyright("DP");
        projectInfo.setCurrency("EUR");
        projectInfo.setNow(RubyDateTimeUtils.getDate(2011, Calendar.SEPTEMBER,
                4, 17,
                37));
        projectInfo.setProjectName("Sample project");
        projectInfo.setSchedulingHorizonMonths(1);
        projectInfo.setUserData(user);
        return projectInfo;
    }

    private List<Resource> getResources(final Persistence persistence) {
        final List<Resource> resources = new LinkedList<Resource>();

        final Long id =
                persistence.createHumanResource("DP", "Dmitri", "Anatl'evich",
                        "Pisarenko", 8.0);
        final Resource worker = persistence.getResource(id);
        worker.setDailyLimitInHours(8);
        resources.add(worker);
        return resources;
    }

    private List<com.google.api.services.tasks.v1.model.Task> getGoogleTasks() {
        // Prepare test data (START)
        final List<com.google.api.services.tasks.v1.model.Task> googleTasks =
                new LinkedList<com.google.api.services.tasks.v1.model.Task>();

        // Task T1, depends on nothing
        final com.google.api.services.tasks.v1.model.Task ball =
                new com.google.api.services.tasks.v1.model.Task();
        ball.set(GoogleTaskFields.ID, "1");
        ball.set(GoogleTaskFields.TITLE, "B: Ball");
        ball.set(GoogleTaskFields.NOTES, "");
        ball.set(GoogleTaskFields.POSITION, "1");
        ball.set(GoogleTaskFields.PARENT, null);

        final com.google.api.services.tasks.v1.model.Task smallBall =
                new com.google.api.services.tasks.v1.model.Task();
        smallBall.set(GoogleTaskFields.ID, "2");
        smallBall.set(GoogleTaskFields.TITLE, "SB: Small ball");
        smallBall.set(GoogleTaskFields.NOTES, "1h");
        smallBall.set(GoogleTaskFields.POSITION, "2");
        smallBall.set(GoogleTaskFields.PARENT, ball.id);

        final com.google.api.services.tasks.v1.model.Task bigBall =
                new com.google.api.services.tasks.v1.model.Task();
        bigBall.set(GoogleTaskFields.ID, "3");
        bigBall.set(GoogleTaskFields.TITLE, "BB: Big ball");
        bigBall.set(GoogleTaskFields.NOTES, "2h");
        bigBall.set(GoogleTaskFields.POSITION, "3");
        bigBall.set(GoogleTaskFields.PARENT, ball.id);

        final com.google.api.services.tasks.v1.model.Task train =
                new com.google.api.services.tasks.v1.model.Task();
        train.set(GoogleTaskFields.ID, "4");
        train.set(GoogleTaskFields.TITLE, "T: Train");
        train.set(GoogleTaskFields.NOTES, "3h");
        train.set(GoogleTaskFields.POSITION, "4");
        train.set(GoogleTaskFields.PARENT, null);

        final com.google.api.services.tasks.v1.model.Task doll =
                new com.google.api.services.tasks.v1.model.Task();
        doll.set(GoogleTaskFields.ID, "5");
        doll.set(GoogleTaskFields.TITLE, "D: Doll");
        doll.set(GoogleTaskFields.NOTES, "2h");
        doll.set(GoogleTaskFields.POSITION, "5");
        doll.set(GoogleTaskFields.PARENT, null);

        googleTasks.add(ball);
        googleTasks.add(smallBall);
        googleTasks.add(bigBall);
        googleTasks.add(train);
        googleTasks.add(doll);
        return googleTasks;
    }

    private
            List<SchedulingObject>
            importTasks(
                    final List<com.google.api.services.tasks.v1.model.Task> aGoogleTasks,
                    final Injector aInjector) {
        final GoogleCalendarTasks2PccImporter2Factory factory =
                aInjector
                        .getInstance(GoogleCalendarTasks2PccImporter2Factory.class);
        final GoogleCalendarTasks2PccImporter2 objectUnderTest =
                factory.create();
        objectUnderTest.setInjector(aInjector);

        final UserData user = new MockObjectFactory().createUserData();

        // Prepare test data (END)
        objectUnderTest.setGoogleTasks(aGoogleTasks);
        objectUnderTest.setInjector(aInjector);
        objectUnderTest.setUser(user);
        try {
            objectUnderTest.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }

        final List<SchedulingObject> createdPccTasks =
                objectUnderTest.getCreatedPccTasks();

        return createdPccTasks;
    }
}

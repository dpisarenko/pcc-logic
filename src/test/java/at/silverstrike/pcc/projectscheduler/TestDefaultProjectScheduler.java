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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.conventions.TestConventions;
import ru.altruix.commons.api.di.InjectorFactory;
import ru.altruix.commons.api.di.PccException;

import at.silverstrike.pcc.api.gtasks.GoogleTaskFields;
import at.silverstrike.pcc.api.model.Booking;
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
import at.silverstrike.pcc.impl.persistence.DefaultPersistence;
import at.silverstrike.pcc.impl.testutils.MockInjectorFactory;
import com.google.inject.Injector;

public final class TestDefaultProjectScheduler {
    private static final String B_BALL = "B: Ball";
    private static final String T_TRAIN = "T: Train";
    private static final String D_DOLL = "D: Doll";
    private static final String BB_BIG_BALL = "BB: Big ball";
    private static final String SB_SMALL_BALL = "SB: Small ball";
    private static final Logger LOGGER =
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
        objectUnderTest.setTaskJugglerPath(Helper.TJ3_PATH);

        /**
         * Set input data
         */
        objectUnderTest.setDirectory(Helper.DIR);

        /**
         * Delete project, bookings and deadline files
         */
        this.helper.cleanupTargetDirectory();

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
                new File(Helper.DIR + ProjectScheduler.BOOKINGS_FILE);
        final File deadlinesFile =
                new File(Helper.DIR + ProjectScheduler.DEADLINE_CSV_FILE);

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
            persistence.openSession(Persistence.HOST_LOCAL, null, null,
                    Persistence.DB_DEV);
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
        objectUnderTest.setTaskJugglerPath(Helper.TJ3_PATH);
        /**
         * Save all task and resource data in the database
         */

        /**
         * Set input data
         */
        objectUnderTest
                .setDirectory(Helper.DIR);
        objectUnderTest.setNow(projectInfo.getNow());

        /**
         * Verify that our only tasks exists in the database before invokation
         * of the method under test
         */

        /**
         * Delete project, bookings and deadline files
         */
        this.helper.cleanupTargetDirectory();

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
                process.getEstimatedCompletionDateTime());

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
    }

    @Test
    /**
     * evernote:///view/3784753/s35/d7d20fd2-70de-41fd-8ed3-5e08500c0cea/d7d20fd2-70de-41fd-8ed3-5e08500c0cea/
     */
    public void testDefect201109_1() {
        /**
         * Create persistence
         */
        final Persistence persistence = new DefaultPersistence();

        /**
         * Init persistence
         */
        try {
            persistence.openSession(Persistence.HOST_LOCAL, null, null,
                    Persistence.DB_DEV);
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
                getGoogleTasksDefect201109_1();

        final List<SchedulingObject> pccTasks =
                this.helper.importTasks(googleTasks, injector);

        final List<Booking> bookings =
                this.helper.calculatePlan(injector, persistence, pccTasks);

        Assert.assertNotNull(bookings);
        Assert.assertEquals(4, bookings.size());

        final Map<String, Booking> bookingsByTaskLabel =
                new HashMap<String, Booking>();

        for (final Booking curBooking : bookings) {
            bookingsByTaskLabel.put(curBooking.getProcess().getName(),
                    curBooking);
        }

        final Booking smallBallBooking = bookingsByTaskLabel.get(SB_SMALL_BALL);
        Assert.assertNotNull(smallBallBooking);
        Assert.assertEquals(smallBallBooking.getStartDateTime(),
                RubyDateTimeUtils.getDate(2011, Calendar.SEPTEMBER, 05, 9, 0));
        Assert.assertEquals(smallBallBooking.getEndDateTime(),
                RubyDateTimeUtils.getDate(2011, Calendar.SEPTEMBER, 05, 10, 0));

        final Booking bigBallBooking = bookingsByTaskLabel.get(BB_BIG_BALL);
        Assert.assertNotNull(bigBallBooking);
        Assert.assertEquals(bigBallBooking.getStartDateTime(),
                RubyDateTimeUtils.getDate(2011, Calendar.SEPTEMBER, 05, 10, 0));
        Assert.assertEquals(bigBallBooking.getEndDateTime(),
                RubyDateTimeUtils.getDate(2011, Calendar.SEPTEMBER, 05, 12, 0));

        final Booking trainBooking = bookingsByTaskLabel.get(T_TRAIN);
        Assert.assertNotNull(trainBooking);
        Assert.assertEquals(trainBooking.getStartDateTime(),
                RubyDateTimeUtils.getDate(2011, Calendar.SEPTEMBER, 05, 12, 0));
        Assert.assertEquals(trainBooking.getEndDateTime(),
                RubyDateTimeUtils.getDate(2011, Calendar.SEPTEMBER, 05, 15, 0));

        final Booking dollBooking = bookingsByTaskLabel.get(D_DOLL);
        Assert.assertNotNull(dollBooking);
        Assert.assertEquals(dollBooking.getStartDateTime(),
                RubyDateTimeUtils.getDate(2011, Calendar.SEPTEMBER, 05, 15, 0));
        Assert.assertEquals(dollBooking.getEndDateTime(),
                RubyDateTimeUtils.getDate(2011, Calendar.SEPTEMBER, 05, 17, 0));

    }

    @Test
    /**
     * Test case for reproducing defect 201109/2
     * evernote:///view/3784753/s35/4d8dc28e-4de8-4d46-b9f5-a103de0681b3/4d8dc28e-4de8-4d46-b9f5-a103de0681b3/
     */
    public void testDefect201109_2() {
        /**
         * Create persistence
         */
        final Persistence persistence = new DefaultPersistence();

        /**
         * Init persistence
         */
        try {
            persistence.openSession(Persistence.HOST_LOCAL, null, null,
                    Persistence.DB_DEV);
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
                getGoogleTasksDefect201109_2();

        final List<SchedulingObject> pccTasks =
                this.helper.importTasks(googleTasks, injector);

        final Task ball = getTaskByName(pccTasks, B_BALL);

        Assert.assertEquals(0, ball.getChildren().size());

        final List<Booking> bookings =
                this.helper.calculatePlan(injector, persistence, pccTasks);

        Assert.assertNotNull(bookings);
        Assert.assertEquals(2, bookings.size());
    }

    private Task getTaskByName(final List<SchedulingObject> aPccTasks,
            final String aName) {
        for (final SchedulingObject curObject : aPccTasks) {
            if (aName.equals(curObject.getName())) {
                return (Task) curObject;
            }
        }
        return null;
    }

    private List<com.google.api.services.tasks.v1.model.Task>
            getGoogleTasksDefect201109_2() {
        // Prepare test data (START)
        final List<com.google.api.services.tasks.v1.model.Task> googleTasks =
                new LinkedList<com.google.api.services.tasks.v1.model.Task>();

        // Task T1, depends on nothing
        final com.google.api.services.tasks.v1.model.Task ball =
                new com.google.api.services.tasks.v1.model.Task();
        ball.set(GoogleTaskFields.ID, "1");
        ball.set(GoogleTaskFields.TITLE, B_BALL);
        ball.set(GoogleTaskFields.NOTES, "");
        ball.set(GoogleTaskFields.POSITION, "1");
        ball.set(GoogleTaskFields.PARENT, null);

        final com.google.api.services.tasks.v1.model.Task smallBall =
                new com.google.api.services.tasks.v1.model.Task();
        smallBall.set(GoogleTaskFields.ID, "2");
        smallBall.set(GoogleTaskFields.TITLE, SB_SMALL_BALL);
        smallBall.set(GoogleTaskFields.NOTES, "1h");
        smallBall.set(GoogleTaskFields.POSITION, "2");
        smallBall.set(GoogleTaskFields.PARENT, ball.id);
        smallBall.set(GoogleTaskFields.COMPLETED, "2011-06-10T11:44:22.300Z");

        final com.google.api.services.tasks.v1.model.Task bigBall =
                new com.google.api.services.tasks.v1.model.Task();
        bigBall.set(GoogleTaskFields.ID, "3");
        bigBall.set(GoogleTaskFields.TITLE, BB_BIG_BALL);
        bigBall.set(GoogleTaskFields.NOTES, "2h");
        bigBall.set(GoogleTaskFields.POSITION, "3");
        bigBall.set(GoogleTaskFields.PARENT, ball.id);
        bigBall.set(GoogleTaskFields.COMPLETED, "2011-06-10T11:44:22.300Z");

        final com.google.api.services.tasks.v1.model.Task train =
                new com.google.api.services.tasks.v1.model.Task();
        train.set(GoogleTaskFields.ID, "4");
        train.set(GoogleTaskFields.TITLE, T_TRAIN);
        train.set(GoogleTaskFields.NOTES, "3h");
        train.set(GoogleTaskFields.POSITION, "4");
        train.set(GoogleTaskFields.PARENT, null);

        final com.google.api.services.tasks.v1.model.Task doll =
                new com.google.api.services.tasks.v1.model.Task();
        doll.set(GoogleTaskFields.ID, "5");
        doll.set(GoogleTaskFields.TITLE, D_DOLL);
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

    private List<com.google.api.services.tasks.v1.model.Task>
            getGoogleTasksDefect201109_1() {
        // Prepare test data (START)
        final List<com.google.api.services.tasks.v1.model.Task> googleTasks =
                new LinkedList<com.google.api.services.tasks.v1.model.Task>();

        // Task T1, depends on nothing
        final com.google.api.services.tasks.v1.model.Task ball =
                new com.google.api.services.tasks.v1.model.Task();
        ball.set(GoogleTaskFields.ID, "1");
        ball.set(GoogleTaskFields.TITLE, B_BALL);
        ball.set(GoogleTaskFields.NOTES, "");
        ball.set(GoogleTaskFields.POSITION, "1");
        ball.set(GoogleTaskFields.PARENT, null);

        final com.google.api.services.tasks.v1.model.Task smallBall =
                new com.google.api.services.tasks.v1.model.Task();
        smallBall.set(GoogleTaskFields.ID, "2");
        smallBall.set(GoogleTaskFields.TITLE, SB_SMALL_BALL);
        smallBall.set(GoogleTaskFields.NOTES, "1h");
        smallBall.set(GoogleTaskFields.POSITION, "2");
        smallBall.set(GoogleTaskFields.PARENT, ball.id);

        final com.google.api.services.tasks.v1.model.Task bigBall =
                new com.google.api.services.tasks.v1.model.Task();
        bigBall.set(GoogleTaskFields.ID, "3");
        bigBall.set(GoogleTaskFields.TITLE, BB_BIG_BALL);
        bigBall.set(GoogleTaskFields.NOTES, "2h");
        bigBall.set(GoogleTaskFields.POSITION, "3");
        bigBall.set(GoogleTaskFields.PARENT, ball.id);

        final com.google.api.services.tasks.v1.model.Task train =
                new com.google.api.services.tasks.v1.model.Task();
        train.set(GoogleTaskFields.ID, "4");
        train.set(GoogleTaskFields.TITLE, T_TRAIN);
        train.set(GoogleTaskFields.NOTES, "3h");
        train.set(GoogleTaskFields.POSITION, "4");
        train.set(GoogleTaskFields.PARENT, null);

        final com.google.api.services.tasks.v1.model.Task doll =
                new com.google.api.services.tasks.v1.model.Task();
        doll.set(GoogleTaskFields.ID, "5");
        doll.set(GoogleTaskFields.TITLE, D_DOLL);
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

}

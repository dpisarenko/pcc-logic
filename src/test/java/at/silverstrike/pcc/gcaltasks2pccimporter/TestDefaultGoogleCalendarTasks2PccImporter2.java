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

package at.silverstrike.pcc.gcaltasks2pccimporter;

import static at.silverstrike.pcc.api.gtaskprioritycalculator.GoogleTasksPriorityCalculator.HIGHEST_PRIORITY;
import static at.silverstrike.pcc.api.gtaskprioritycalculator.GoogleTasksPriorityCalculator.PRIORITY_STEP;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.InjectorFactory;
import ru.altruix.commons.api.di.PccException;

import com.google.api.services.tasks.v1.model.Task;
import com.google.inject.Injector;

import at.silverstrike.pcc.api.gcaltasks2pccimporter.GoogleCalendarTasks2PccImporter2;
import at.silverstrike.pcc.api.gcaltasks2pccimporter.GoogleCalendarTasks2PccImporter2Factory;
import at.silverstrike.pcc.api.gtasks.GoogleTaskFields;
import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.model.UserData;
import at.silverstrike.pcc.impl.mockpersistence.MockObjectFactory;
import at.silverstrike.pcc.impl.testutils.MockInjectorFactory;

/**
 * @author DP118M
 * 
 */
public final class TestDefaultGoogleCalendarTasks2PccImporter2 {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(TestDefaultGoogleCalendarTasks2PccImporter2.class);

    private static final MockObjectFactory MOCK_OBJECT_FACTORY =
            new MockObjectFactory();

    @Test
    public void testDependenciesReadingPrefix() {
        // Prepare test data (START)
        final List<Task> googleTasks = new LinkedList<Task>();

        // Task T1, depends on nothing
        final Task t1 = new Task();
        t1.set(GoogleTaskFields.ID, "1");
        t1.set(GoogleTaskFields.TITLE, "T1: Task 1");
        t1.set(GoogleTaskFields.NOTES, "1h");
        t1.set(GoogleTaskFields.POSITION, "1");

        // Task T2, depends on T1
        final Task t2 = new Task();
        t2.set(GoogleTaskFields.ID, "2");
        t2.set(GoogleTaskFields.TITLE, "T2: Task 2");
        t2.set(GoogleTaskFields.NOTES, "1h Depends on T1");
        t2.set(GoogleTaskFields.POSITION, "2");
        
        // Task T3, depends on T1 and T2
        final Task t3 = new Task();
        t3.set(GoogleTaskFields.ID, "3");
        t3.set(GoogleTaskFields.TITLE, "T3: Task 3");
        t3.set(GoogleTaskFields.NOTES, "1h Depends on T1, T2");
        t3.set(GoogleTaskFields.POSITION, "3");
        
        googleTasks.add(t1);
        googleTasks.add(t2);
        googleTasks.add(t3);

        testDependencyCreation(googleTasks);
    }

    @Test
    public void testDependenciesReadingHashtags() {
        // Prepare test data (START)
        final List<Task> googleTasks = new LinkedList<Task>();

        // Task T1, depends on nothing
        final Task t1 = new Task();
        t1.set(GoogleTaskFields.ID, "1");
        t1.set(GoogleTaskFields.TITLE, "T1: Task 1");
        t1.set(GoogleTaskFields.POSITION, "1");
        
        // Task T2, depends on T1
        final Task t2 = new Task();
        t2.set(GoogleTaskFields.ID, "2");
        t2.set(GoogleTaskFields.TITLE, "T2: Task 2");
        t2.set("notes", "#T1");
        t2.set(GoogleTaskFields.POSITION, "2");
        
        // Task T3, depends on T1 and T2
        final Task t3 = new Task();
        t3.set(GoogleTaskFields.ID, "3");
        t3.set(GoogleTaskFields.TITLE, "T3: Task 3");
        t3.set("notes", "#T1 #T2");
        t3.set(GoogleTaskFields.POSITION, "3");
        
        googleTasks.add(t1);
        googleTasks.add(t2);
        googleTasks.add(t3);

        testDependencyCreation(googleTasks);
    }

    private void testDependencyCreation(final List<Task> aGoogleTasks) {
        final Injector injector = getInjector();
        final GoogleCalendarTasks2PccImporter2 objectUnderTest =
                getObjectUnderTest(injector);
        final UserData user = MOCK_OBJECT_FACTORY.createUserData();

        // Prepare test data (END)
        objectUnderTest.setGoogleTasks(aGoogleTasks);
        objectUnderTest.setInjector(injector);
        objectUnderTest.setUser(user);
        try {
            objectUnderTest.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }

        final List<SchedulingObject> createdPccTasks =
                objectUnderTest.getCreatedPccTasks();

        Assert.assertNotNull(createdPccTasks);
        Assert.assertEquals(3, createdPccTasks.size());

        final Map<String, at.silverstrike.pcc.api.model.Task> pccTasksByLabels =
                getPccTasksByLabels(createdPccTasks);

        // Check T1
        final at.silverstrike.pcc.api.model.Task t1pcc =
                pccTasksByLabels.get("T1");
        Assert.assertEquals(0, t1pcc.getPredecessors().size());

        // Check T2
        final at.silverstrike.pcc.api.model.Task t2pcc =
                pccTasksByLabels.get("T2");
        Assert.assertEquals(1, t2pcc.getPredecessors().size());

        final at.silverstrike.pcc.api.model.SchedulingObject t2predecessor =
                t2pcc.getPredecessors().iterator().next();
        Assert.assertEquals("T1", t2predecessor.getLabel());

        // Check T3
        final at.silverstrike.pcc.api.model.Task t3pcc =
                pccTasksByLabels.get("T3");
        final Set<SchedulingObject> t3pccPredecessors = t3pcc.getPredecessors();

        Assert.assertEquals(2, t3pccPredecessors.size());

        final List<String> t3predecessorLabels =
                getPredecessorLabels(t3pccPredecessors);

        Assert.assertTrue(t3predecessorLabels.contains("T1"));
        Assert.assertTrue(t3predecessorLabels.contains("T2"));
    }

    private List<String> getPredecessorLabels(
            final Set<SchedulingObject> t3pccPredecessors) {
        final List<String> t3predecessorLabels = new LinkedList<String>();

        for (final SchedulingObject curTask : t3pccPredecessors) {
            t3predecessorLabels.add(curTask.getLabel());
        }
        return t3predecessorLabels;
    }

    private Map<String, at.silverstrike.pcc.api.model.Task>
            getPccTasksByLabels(
                    final List<SchedulingObject> aPccTasks) {
        final Map<String, at.silverstrike.pcc.api.model.Task> returnValue =
                new HashMap<String, at.silverstrike.pcc.api.model.Task>();

        for (final SchedulingObject curTask : aPccTasks) {
            returnValue.put(
                    ((at.silverstrike.pcc.api.model.Task) curTask).getLabel(),
                    (at.silverstrike.pcc.api.model.Task) curTask);
        }

        return returnValue;
    }

    private GoogleCalendarTasks2PccImporter2 getObjectUnderTest(
            final Injector aInjector) {
        final GoogleCalendarTasks2PccImporter2Factory factory =
                aInjector
                        .getInstance(GoogleCalendarTasks2PccImporter2Factory.class);
        final GoogleCalendarTasks2PccImporter2 objectUnderTest =
                factory.create();
        objectUnderTest.setInjector(aInjector);

        return objectUnderTest;
    }

    private Injector getInjector() {
        final InjectorFactory injectorFactory = new MockInjectorFactory(
                new MockInjectorModule(new MockPersistence()));
        final Injector injector = injectorFactory.createInjector();
        return injector;
    }

    /**
     * Test case for defect - 201109/1, priorities are not set
     * evernote:///view/3784753/s35/d7d20fd2-70de-41fd-
     * 8ed3-5e08500c0cea/d7d20fd2-70de-41fd-8ed3-5e08500c0cea/
     */
    @Test
    public void testDefect201109_1() {
        // Prepare test data (START)
        final List<Task> googleTasks = new LinkedList<Task>();

        // Task T1, depends on nothing
        final Task ball = new Task();
        ball.set(GoogleTaskFields.ID, "1");
        ball.set(GoogleTaskFields.TITLE, "B: Ball");
        ball.set(GoogleTaskFields.NOTES, "");
        ball.set(GoogleTaskFields.POSITION, "1");
        ball.set(GoogleTaskFields.PARENT, null);

        final Task smallBall = new Task();
        smallBall.set(GoogleTaskFields.ID, "2");
        smallBall.set(GoogleTaskFields.TITLE, "SB: Small ball");
        smallBall.set(GoogleTaskFields.NOTES, "1h");
        smallBall.set(GoogleTaskFields.POSITION, "2");
        smallBall.set(GoogleTaskFields.PARENT, ball.id);

        final Task bigBall = new Task();
        bigBall.set(GoogleTaskFields.ID, "3");
        bigBall.set(GoogleTaskFields.TITLE, "BB: Big ball");
        bigBall.set(GoogleTaskFields.NOTES, "2h");
        bigBall.set(GoogleTaskFields.POSITION, "3");
        bigBall.set(GoogleTaskFields.PARENT, ball.id);

        final Task train = new Task();
        train.set(GoogleTaskFields.ID, "4");
        train.set(GoogleTaskFields.TITLE, "T: Train");
        train.set(GoogleTaskFields.NOTES, "3h");
        train.set(GoogleTaskFields.POSITION, "4");
        train.set(GoogleTaskFields.PARENT, null);

        final Task doll = new Task();
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

        final List<SchedulingObject> pccTasks = importTasks(googleTasks);

        final Map<String, at.silverstrike.pcc.api.model.Task> pccTasksByLabels =
                getPccTasksByLabels(pccTasks);

        final at.silverstrike.pcc.api.model.Task pccTaskBall =
                pccTasksByLabels.get("B");
        final at.silverstrike.pcc.api.model.Task pccTaskSmallBall =
                pccTasksByLabels.get("SB");
        final at.silverstrike.pcc.api.model.Task pccTaskBigBall =
                pccTasksByLabels.get("BB");
        final at.silverstrike.pcc.api.model.Task pccTaskTrain =
                pccTasksByLabels.get("T");
        final at.silverstrike.pcc.api.model.Task pccTaskDoll =
                pccTasksByLabels.get("D");

        Assert.assertNotNull(pccTaskBall);
        Assert.assertNotNull(pccTaskSmallBall);
        Assert.assertNotNull(pccTaskBigBall);
        Assert.assertNotNull(pccTaskTrain);
        Assert.assertNotNull(pccTaskDoll);

        LOGGER.debug("pccTaskBall: {}", pccTaskBall.getPriority());
        LOGGER.debug("pccTaskSmallBall: {}", pccTaskSmallBall.getPriority());
        LOGGER.debug("pccTaskBigBall: {}", pccTaskBigBall.getPriority());
        LOGGER.debug("pccTaskTrain: {}", pccTaskTrain.getPriority());
        LOGGER.debug("pccTaskDoll: {}", pccTaskDoll.getPriority());

        Assert.assertEquals(HIGHEST_PRIORITY, (int) pccTaskBall.getPriority());
        Assert.assertEquals(HIGHEST_PRIORITY - PRIORITY_STEP,
                (int) pccTaskSmallBall.getPriority());
        Assert.assertEquals(HIGHEST_PRIORITY - PRIORITY_STEP * 2,
                (int) pccTaskBigBall.getPriority());
        Assert.assertEquals(HIGHEST_PRIORITY - PRIORITY_STEP * 3,
                (int) pccTaskTrain.getPriority());
        Assert.assertEquals(HIGHEST_PRIORITY - PRIORITY_STEP * 4,
                (int) pccTaskDoll.getPriority());

        Assert.assertNotNull(pccTaskSmallBall.getParent());
        Assert.assertNotNull(pccTaskBigBall.getParent());

        Assert.assertEquals(pccTaskBall.getId(), pccTaskSmallBall.getParent()
                .getId());
        Assert.assertEquals(pccTaskBall.getId(), pccTaskBigBall.getParent()
                .getId());
    }

    private List<SchedulingObject> importTasks(final List<Task> aGoogleTasks) {
        final Injector injector = getInjector();
        final GoogleCalendarTasks2PccImporter2 objectUnderTest =
                getObjectUnderTest(injector);
        final UserData user = MOCK_OBJECT_FACTORY.createUserData();

        // Prepare test data (END)
        objectUnderTest.setGoogleTasks(aGoogleTasks);
        objectUnderTest.setInjector(injector);
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

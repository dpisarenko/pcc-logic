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

package at.silverstrike.pcc.gtaskrelevance;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.InjectorFactory;
import ru.altruix.commons.api.di.PccException;

import com.google.api.services.tasks.v1.model.Task;
import com.google.inject.Injector;

import at.silverstrike.pcc.api.gtaskrelevance.IsGoogleTaskRelevantCalculator;
import at.silverstrike.pcc.api.gtaskrelevance.IsGoogleTaskRelevantCalculatorFactory;
import at.silverstrike.pcc.api.gtasks.GoogleTaskFields;
import at.silverstrike.pcc.impl.gtaskrelevance.DefaultIsGoogleTaskRelevantCalculatorFactory;
import at.silverstrike.pcc.impl.testutils.MockInjectorFactory;

/**
 * @author DP118M
 * 
 */
public final class TestDefaultIsGoogleTaskRelevantCalculator {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(TestDefaultIsGoogleTaskRelevantCalculator.class);

    @Test
    public void testCompleted() {
        final IsGoogleTaskRelevantCalculator objectUnderTest =
                getObjectUnderTest();

        final com.google.api.services.tasks.v1.model.Task task = new Task();

        task.set("title", "bla-bla task");
        task.set(GoogleTaskFields.COMPLETED,
                "2011-06-10T11:44:22.300Z");
        task.set(GoogleTaskFields.PARENT,
                "MTE5OTY3NjA1Mjc5NDc1OTc1NjI6MDo5");

        Assert.assertFalse(getActualRelevance(objectUnderTest, task));
    }

    private IsGoogleTaskRelevantCalculator getObjectUnderTest() {
        final InjectorFactory injectorFactory = new MockInjectorFactory(
                new MockInjectorModule());
        final Injector injector = injectorFactory.createInjector();
        final IsGoogleTaskRelevantCalculatorFactory factory =
                new DefaultIsGoogleTaskRelevantCalculatorFactory();
        final IsGoogleTaskRelevantCalculator objectUnderTest = factory.create();
        objectUnderTest.setInjector(injector);

        return objectUnderTest;
    }

    @Test
    public void testNotCompletedNullNote() {
        final IsGoogleTaskRelevantCalculator objectUnderTest =
                getObjectUnderTest();

        final com.google.api.services.tasks.v1.model.Task task = new Task();

        task.set("title", "bla-bla task");
        task.set(GoogleTaskFields.COMPLETED, null);
        task.set(GoogleTaskFields.NOTES, null);
        task.set(GoogleTaskFields.PARENT,
                "MTE5OTY3NjA1Mjc5NDc1OTc1NjI6MDo5");

        Assert.assertFalse(getActualRelevance(objectUnderTest, task));
    }

    @Test
    public void testNotCompletedEmptyNote() {
        final IsGoogleTaskRelevantCalculator objectUnderTest =
                getObjectUnderTest();

        final com.google.api.services.tasks.v1.model.Task task = new Task();

        task.set("title", "bla-bla task");
        task.set(GoogleTaskFields.COMPLETED, null);
        task.set(GoogleTaskFields.NOTES, "   ");
        task.set(GoogleTaskFields.PARENT,
                "MTE5OTY3NjA1Mjc5NDc1OTc1NjI6MDo5");

        Assert.assertFalse(getActualRelevance(objectUnderTest, task));
    }

    @Test
    public void testNotCompletedEmptyNoteTopLevelTask() {
        final IsGoogleTaskRelevantCalculator objectUnderTest =
                getObjectUnderTest();

        final com.google.api.services.tasks.v1.model.Task task = new Task();

        task.set("title", "bla-bla task");
        task.set(GoogleTaskFields.COMPLETED, null);
        task.set(GoogleTaskFields.NOTES, "   ");
        task.set(GoogleTaskFields.PARENT,
                null);

        Assert.assertTrue(getActualRelevance(objectUnderTest, task));
    }

    @Test
    public void testTopLevelTaskWithEffortEstimate() {
        final IsGoogleTaskRelevantCalculator objectUnderTest =
                getObjectUnderTest();

        final com.google.api.services.tasks.v1.model.Task task = new Task();

        task.set("title", "bla-bla task");
        task.set(GoogleTaskFields.COMPLETED, null);
        task.set(GoogleTaskFields.NOTES, "3h");
        task.set(GoogleTaskFields.PARENT,
                null);

        Assert.assertTrue(getActualRelevance(objectUnderTest, task));
    }

    @Test
    public void testChildTaskWithEffortEstimateAndDependencyPrefix() {
        final IsGoogleTaskRelevantCalculator objectUnderTest =
                getObjectUnderTest();

        final com.google.api.services.tasks.v1.model.Task task = new Task();

        task.set("title", "bla-bla task");
        task.set(GoogleTaskFields.COMPLETED, null);
        task.set(GoogleTaskFields.NOTES, "1h Depends on T1");
        task.set(GoogleTaskFields.PARENT,
                "someparent");

        Assert.assertTrue(getActualRelevance(objectUnderTest, task));
    }

    @Test
    public void testTopLevelTaskWithEmptyName() {
        final IsGoogleTaskRelevantCalculator objectUnderTest =
                getObjectUnderTest();

        final com.google.api.services.tasks.v1.model.Task task = new Task();

        task.set("title", "   ");

        Assert.assertFalse(getActualRelevance(objectUnderTest, task));
    }
    @Test
    public void testTopLevelTaskWithNullName() {
        final IsGoogleTaskRelevantCalculator objectUnderTest =
                getObjectUnderTest();

        final com.google.api.services.tasks.v1.model.Task task = new Task();

        task.set("title", null);

        Assert.assertFalse(getActualRelevance(objectUnderTest, task));
    }
    
    private boolean getActualRelevance(
            final IsGoogleTaskRelevantCalculator aObjectUnderTest,
            final com.google.api.services.tasks.v1.model.Task aTask) {
        boolean actualRelevance = false;
        try {
            aObjectUnderTest.setGoogleTask(aTask);
            aObjectUnderTest.run();
            actualRelevance = aObjectUnderTest.isRelevant();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }
        return actualRelevance;
    }
    
    @Test 
    public void testOnBlankCompletedField()
    {
        final IsGoogleTaskRelevantCalculator objectUnderTest =
            getObjectUnderTest();

        final com.google.api.services.tasks.v1.model.Task task = new Task();

        task.set("title", "Поработать по концепции");
        task.set("completed", "");
        task.set("id", "MDA4MjIwMTU4MjI3NTg0MzUxMTM6MDo0OTIxNjE2NzE");
        task.set("kind", null);
        task.set("notes", "1h");
        task.set("parent", "MDA4MjIwMTU4MjI3NTg0MzUxMTM6MDoxNjk");
        task.set("position", "00000000000003145727");
        task.set("status", null);
        task.set("updated", null);
        
        Assert.assertTrue(getActualRelevance(objectUnderTest, task));
        
    }
}

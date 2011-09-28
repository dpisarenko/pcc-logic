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

package at.silverstrike.pcc.gtaskrelevance2;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.InjectorFactory;
import ru.altruix.commons.api.di.PccException;

import com.google.api.services.tasks.v1.model.Task;
import com.google.inject.Injector;

import at.silverstrike.pcc.api.gtaskrelevance2.RelevantTaskSetCalculator;
import at.silverstrike.pcc.api.gtaskrelevance2.RelevantTaskSetCalculatorFactory;
import at.silverstrike.pcc.impl.testutils.Csv2GoogleTasks;
import at.silverstrike.pcc.impl.testutils.MockInjectorFactory;

/**
 * @author DP118M
 * 
 */
public class TestDefaultRelevantTaskSetCalculator {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(TestDefaultRelevantTaskSetCalculator.class);

    @Test
    public void testDefect201109271() {
        final Injector injector = getInjector();
        final RelevantTaskSetCalculator objectUnderTest =
                getObjectUnderTest(injector);

        final List<com.google.api.services.tasks.v1.model.Task> googleTasks =
                getGoogleTasks();

        objectUnderTest.setGoogleTasks(googleTasks);
        try {
            objectUnderTest.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }
        
        final List<com.google.api.services.tasks.v1.model.Task> relevantTasks =
            objectUnderTest.getRelevantTasks();

        
        final List<String> relevantTaskIds =
            new LinkedList<String>();
        for (final com.google.api.services.tasks.v1.model.Task curTask : relevantTasks)
        {
            relevantTaskIds.add(curTask.id);
        }
        
        Assert.assertTrue(relevantTaskIds.contains("MDA4MjIwMTU4MjI3NTg0MzUxMTM6MDo0MQ"));
    }

    private Injector getInjector() {
        final InjectorFactory injectorFactory = new MockInjectorFactory(
                new MockInjectorModule());
        final Injector injector = injectorFactory.createInjector();
        return injector;
    }

    private RelevantTaskSetCalculator getObjectUnderTest(
            final Injector aInjector) {
        final RelevantTaskSetCalculatorFactory factory =
                aInjector.getInstance(RelevantTaskSetCalculatorFactory.class);
        final RelevantTaskSetCalculator objectUnderTest = factory.create();

        return objectUnderTest;
    }

    private List<Task> getGoogleTasks() {
        return Csv2GoogleTasks.csvToGoogleTasks(new File(
                "src/test/resources/at/silverstrike/"
                        + "pcc/test/gtaskrelevance2/"
                        + "TestDefect201109271-2011-09-28___02-32-44-396.csv"));
    }
}

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

package at.silverstrike.pcc.gtask2pcctaskconverter;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Injector;

import ru.altruix.commons.api.di.InjectorFactory;
import ru.altruix.commons.api.di.PccException;
import at.silverstrike.pcc.api.gtask2pcctaskconverter.GoogleTask2PccTaskConverter;
import at.silverstrike.pcc.api.gtask2pcctaskconverter.GoogleTask2PccTaskConverterFactory;
import at.silverstrike.pcc.api.model.UserData;
import at.silverstrike.pcc.impl.gtask2pcctaskconverter.DefaultGoogleTask2PccTaskConverterFactory;
import at.silverstrike.pcc.impl.mockpersistence.MockObjectFactory;
import at.silverstrike.pcc.impl.testutils.MockInjectorFactory;

/**
 * Test cases for defect "20110908/6: Не задать время меньше часа"
 * evernote://
 * /view/3784753/s35/bb36cad3-9935-4356-84d7-d5dea5751a59/bb36cad3
 * -9935-4356-84d7-d5dea5751a59/
 */
public class TestDefect201109086 {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(TestDefect201109086.class);

    @Test
    public void testDefect201109086_15min() {
        final GoogleTask2PccTaskConverter objectUnderTest =
                getObjectUnderTest();

        /**
         * Run the first time, with non-null notes
         */
        final com.google.api.services.tasks.v1.model.Task task1 =
                new com.google.api.services.tasks.v1.model.Task();
        task1.set("notes", "15m");
        objectUnderTest.setGoogleTask(task1);
        objectUnderTest.setUser(getUserData());
        try {
            objectUnderTest.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }

        final at.silverstrike.pcc.api.model.Task pccTask =
                objectUnderTest.getPccTask();

        Assert.assertEquals(0.25, pccTask.getEffort());
    }

    @Test
    public void testDefect201109086_30min() {
        final GoogleTask2PccTaskConverter objectUnderTest =
                getObjectUnderTest();

        /**
         * Run the first time, with non-null notes
         */
        final com.google.api.services.tasks.v1.model.Task task1 =
                new com.google.api.services.tasks.v1.model.Task();
        task1.set("notes", "30m");
        objectUnderTest.setGoogleTask(task1);
        objectUnderTest.setUser(getUserData());
        try {
            objectUnderTest.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }

        final at.silverstrike.pcc.api.model.Task pccTask =
                objectUnderTest.getPccTask();

        Assert.assertEquals(0.5, pccTask.getEffort());
    }

    @Test
    public void testDefect201109086_45min() {
        final GoogleTask2PccTaskConverter objectUnderTest =
                getObjectUnderTest();

        /**
         * Run the first time, with non-null notes
         */
        final com.google.api.services.tasks.v1.model.Task task1 =
                new com.google.api.services.tasks.v1.model.Task();
        task1.set("notes", "45m");
        objectUnderTest.setGoogleTask(task1);
        objectUnderTest.setUser(getUserData());
        try {
            objectUnderTest.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }

        final at.silverstrike.pcc.api.model.Task pccTask =
                objectUnderTest.getPccTask();

        Assert.assertEquals(0.75, pccTask.getEffort());
    }

    
    private GoogleTask2PccTaskConverter getObjectUnderTest() {
        final InjectorFactory injectorFactory = new MockInjectorFactory(
                new MockInjectorModule(new MockPersistence()));
        final Injector injector = injectorFactory.createInjector();
        final GoogleTask2PccTaskConverterFactory factory =
                new DefaultGoogleTask2PccTaskConverterFactory();
        final GoogleTask2PccTaskConverter objectUnderTest = factory.create();
        objectUnderTest.setInjector(injector);

        return objectUnderTest;
    }
    private UserData getUserData() {
        final MockObjectFactory mockObjectFactory = new MockObjectFactory();
        return mockObjectFactory.createUserData();
    }
}

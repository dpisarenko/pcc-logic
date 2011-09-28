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

import java.io.File;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.InjectorFactory;
import at.silverstrike.pcc.api.model.Booking;
import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.persistence.Persistence;
import at.silverstrike.pcc.impl.persistence.DefaultPersistence;
import at.silverstrike.pcc.impl.testutils.Csv2GoogleTasks;
import at.silverstrike.pcc.impl.testutils.MockInjectorFactory;

import com.google.api.services.tasks.v1.model.Task;
import com.google.inject.Injector;

/**
 * @author DP118M
 * 
 */
public class TestDefect201109271 {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(TestDefect201109271.class);
    private Helper helper = new Helper();

    /**
     * Test case for reproducing defect 20110927/1
     * evernote:///view/3784753/s35/edc7f152
     * -2e80-4945-8ff1-331697d7b2a9/edc7f152-2e80-4945-8ff1-331697d7b2a9/
     */
    @Test
    public void testDefect201109271() {
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
                getGoogleTasks();

        final List<SchedulingObject> pccTasks =
                this.helper.importTasks(googleTasks, injector);

        final List<Booking> bookings =
                this.helper.calculatePlan(injector, persistence, pccTasks);

        Assert.assertNotNull(bookings);
        Assert.assertEquals(3, bookings.size());

        Assert.assertEquals(17L, (long) bookings.get(0).getProcess().getId());
        Assert.assertEquals(12L, (long) bookings.get(1).getProcess().getId());
        Assert.assertEquals(14L, (long) bookings.get(2).getProcess().getId());
    }

    private List<Task> getGoogleTasks() {
        return Csv2GoogleTasks.csvToGoogleTasks(new File(Helper.DIR
                + "TestDefect201109271-2011-09-28___02-32-44-396.csv"));
    }
}

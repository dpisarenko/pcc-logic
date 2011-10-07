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
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.InjectorFactory;
import ru.altruix.commons.api.di.PccException;
import at.silverstrike.pcc.api.model.Booking;
import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.persistence.Persistence;
import at.silverstrike.pcc.impl.jruby.RubyDateTimeUtils;
import at.silverstrike.pcc.impl.persistence.DefaultPersistence;
import at.silverstrike.pcc.impl.testutils.Csv2GoogleCalendarEventEntries;
import at.silverstrike.pcc.impl.testutils.Csv2GoogleTasks;
import at.silverstrike.pcc.impl.testutils.MockInjectorFactory;

import co.altruix.pcc.api.calendarevent2pcceventconverter.CalendarEventEntry2PccEventConverter;
import co.altruix.pcc.api.calendarevent2pcceventconverter.CalendarEventEntry2PccEventConverterFactory;

import com.google.api.services.tasks.v1.model.Task;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.inject.Injector;

/**
 * @author DP118M
 * 
 */
public class TestDefect201110051 {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(TestDefect201110051.class);
    private Helper helper = new Helper();

    @Test
    public void testDefect201110051() {
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
                new MockInjectorFactory(new MockInjectorModuleDefect201110051(
                        persistence));
        final Injector injector = injectorFactory.createInjector();

        final List<com.google.api.services.tasks.v1.model.Task> googleTasks =
                getGoogleTasks();

        final List<SchedulingObject> pccTasks =
                this.helper.importTasks(googleTasks, injector);

        final List<SchedulingObject> importedEvents = importEvents(injector);

        final List<SchedulingObject> schedulingObjects =
                new LinkedList<SchedulingObject>();
        schedulingObjects.addAll(pccTasks);
        schedulingObjects.addAll(importedEvents);

        final List<Booking> bookings =
                this.helper.calculatePlan(injector, persistence,
                        schedulingObjects, RubyDateTimeUtils.getDate(2011,
                                Calendar.OCTOBER, 5, 22, 46));
        
        
        final Date event1Start = new Date(DateTime.parseDateTime("2011-10-07T14:10:00.000+02:00").getValue());
        final Date event1End = new Date(DateTime.parseDateTime("2011-10-07T14:55:00.000+02:00").getValue());
        
        final Date event2Start = new Date(DateTime.parseDateTime("2011-10-07T12:05:00.000+02:00").getValue());
        final Date event2End = new Date(DateTime.parseDateTime("2011-10-07T12:50:00.000+02:00").getValue());

        
        Assert.assertNotNull(bookings);
                        
        final List<Booking> scheduledTaskBookings = new LinkedList<Booking>();
        
        for (final Booking curBooking : bookings) {
            if ("ScheduledTask1".equals(curBooking.getProcess().getName()))
            {
                scheduledTaskBookings.add(curBooking);
            }
        }

        Assert.assertTrue(scheduledTaskBookings.size() > 0);

        
        
        for (final Booking curBooking : scheduledTaskBookings)
        {
            final Date taskStart = curBooking.getStartDateTime();
            final Date taskEnd = curBooking.getEndDateTime();

            Assert.assertNotNull(taskStart);
            Assert.assertNotNull(taskEnd);

            Assert.assertTrue(taskEnd.before(event1Start) || taskStart.after(event1End));
            Assert.assertTrue(taskEnd.before(event2Start) || taskStart.after(event2End));
            
        }        
    }

    private List<SchedulingObject> importEvents(final Injector aInjector) {
        final List<CalendarEventEntry> googleEvents =
                Csv2GoogleCalendarEventEntries
                        .csvToGoogleEvents(new File(
                                Helper.DIR
                                        + "TestDefect201110051-diagnostic_gevents-2011-10-05___22-46-45-369.csv"));

        return convertCalendarEventEntriesToPccEvents(googleEvents, aInjector);
    }

    private List<Task> getGoogleTasks() {
        return Csv2GoogleTasks
                .csvToGoogleTasks(new File(
                        Helper.DIR
                                + "TestDefect201110051-diagnostic_gtasks-2011-10-05___22-46-45-369.csv"));
    }

    private List<SchedulingObject> convertCalendarEventEntriesToPccEvents(
            final List<CalendarEventEntry> calendarEventEntriesToImport,
            final Injector aInjector) {
        final CalendarEventEntry2PccEventConverterFactory converterFactory =
                aInjector
                        .getInstance(CalendarEventEntry2PccEventConverterFactory.class);
        final CalendarEventEntry2PccEventConverter converter =
                converterFactory.create();

        converter.setCalendarEventEntries(calendarEventEntriesToImport);
        converter.setInjector(aInjector);
        try {
            converter.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
        }
        final List<SchedulingObject> importedEvents = converter.getPccEvents();
        return importedEvents;
    }

}

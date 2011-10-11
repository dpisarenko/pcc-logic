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
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.InjectorFactory;
import ru.altruix.commons.api.di.PccException;
import at.silverstrike.pcc.api.model.Booking;
import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.persistence.Persistence;
import at.silverstrike.pcc.impl.persistence.DefaultPersistence;
import at.silverstrike.pcc.impl.testutils.Csv2GoogleCalendarEventEntries;
import at.silverstrike.pcc.impl.testutils.Csv2GoogleTasks;
import at.silverstrike.pcc.impl.testutils.MockInjectorFactory;
import co.altruix.pcc.api.calendarevent2pcceventconverter.CalendarEventEntry2PccEventConverter;
import co.altruix.pcc.api.calendarevent2pcceventconverter.CalendarEventEntry2PccEventConverterFactory;

import com.google.api.services.tasks.v1.model.Task;
import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.inject.Injector;

/**
 * @author DP118M
 *
 */
@Ignore
class SchedulingDefectTestCase {
    private static final Logger LOGGER =
        LoggerFactory.getLogger(SchedulingDefectTestCase.class);
    protected Helper helper = new Helper();

    protected List<SchedulingObject> importEvents(final Injector aInjector, final String aFileName) {
        final List<CalendarEventEntry> googleEvents =
                Csv2GoogleCalendarEventEntries
                        .csvToGoogleEvents(new File(
                                Helper.DIR
                                        + aFileName));
    
        return convertCalendarEventEntriesToPccEvents(googleEvents, aInjector);
    }

    protected List<Task> getGoogleTasks(final String aFileName) {
        return Csv2GoogleTasks
                .csvToGoogleTasks(new File(
                        Helper.DIR
                                + aFileName));
    }

    private List<SchedulingObject> convertCalendarEventEntriesToPccEvents(final List<CalendarEventEntry> calendarEventEntriesToImport,
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

    protected List<Booking> calculatePlan(final String aTasksFile, final String aEventsFile, final Date aNow) {
        final Persistence persistence = initPersistence();
    
        final InjectorFactory injectorFactory =
                new MockInjectorFactory(new MockInjectorModuleDefect201110051(
                        persistence));
        final Injector injector = injectorFactory.createInjector();
    
        final List<com.google.api.services.tasks.v1.model.Task> googleTasks =
                getGoogleTasks(aTasksFile);
    
        final List<SchedulingObject> pccTasks =
                this.helper.importTasks(googleTasks, injector);
    
        final List<SchedulingObject> importedEvents =
                importEvents(injector, aEventsFile);
    
        final List<SchedulingObject> schedulingObjects =
                new LinkedList<SchedulingObject>();
        schedulingObjects.addAll(pccTasks);
        schedulingObjects.addAll(importedEvents);
    
        final List<Booking> bookings =
                this.helper.calculatePlan(injector, persistence,
                        schedulingObjects, aNow);
        return bookings;
    }

    protected Persistence initPersistence() {
        final Persistence persistence = new DefaultPersistence();
    
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
        return persistence;
    }

}

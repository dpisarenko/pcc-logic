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

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import jruby.joda.time.Interval;
import junit.framework.Assert;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.silverstrike.pcc.api.model.Booking;
import at.silverstrike.pcc.impl.jruby.RubyDateTimeUtils;
import com.google.gdata.data.DateTime;

/**
 * @author DP118M
 * 
 */
public class TestDefect201110051 extends SchedulingDefectTestCase {
    static final Logger LOGGER =
            LoggerFactory.getLogger(TestDefect201110051.class);

    @Test
    @Ignore
    public void testDefect201110051() {

        final Date now = RubyDateTimeUtils.getDate(2011,
                Calendar.OCTOBER, 5, 22, 46);

        final List<Booking> bookings =
                calculatePlan(
                        "TestDefect201110051-diagnostic_gtasks-2011-10-05___22-46-45-369.csv",
                        "TestDefect201110051-diagnostic_gevents-2011-10-05___22-46-45-369.csv",
                        now);

        Assert.assertNotNull(bookings);

        final Interval event1Interval = new Interval(DateTime
                .parseDateTime("2011-10-07T14:10:00.000+02:00")
                .getValue(), DateTime
                .parseDateTime("2011-10-07T14:55:00.000+02:00")
                .getValue());

        final Interval event2Interval = new Interval(DateTime.parseDateTime(
                "2011-10-07T12:05:00.000+02:00")
                .getValue(), DateTime.parseDateTime(
                "2011-10-07T12:50:00.000+02:00")
                .getValue());

        final List<Booking> scheduledTaskBookings = new LinkedList<Booking>();

        for (final Booking curBooking : bookings) {
            if ("ScheduledTask1".equals(curBooking.getProcess().getName())) {
                scheduledTaskBookings.add(curBooking);
            }
        }

        Assert.assertTrue(scheduledTaskBookings.size() > 0);

        for (final Booking curBooking : scheduledTaskBookings) {
            final Date taskStart =
                    DateUtils.addSeconds(curBooking.getStartDateTime(), 1);
            final Date taskEnd =
                    DateUtils.addSeconds(curBooking.getEndDateTime(), -1);

            Assert.assertNotNull(taskStart);
            Assert.assertNotNull(taskEnd);

            final Interval taskInterval =
                    new Interval(taskStart.getTime(), taskEnd.getTime());

            Assert.assertFalse(taskInterval.overlaps(event1Interval));
            Assert.assertFalse(event1Interval.overlaps(taskInterval));

            Assert.assertFalse(taskInterval.overlaps(event2Interval));
            Assert.assertFalse(event2Interval.overlaps(taskInterval));
        }

    }
}

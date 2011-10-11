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
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import at.silverstrike.pcc.api.model.Booking;
import at.silverstrike.pcc.impl.jruby.RubyDateTimeUtils;

/**
 * @author DP118M
 * 
 */
public class TestDefect201110112 extends SchedulingDefectTestCase {
    @Test
    public void testDefect201110112() {
        final Date now = RubyDateTimeUtils.getDate(2011,
                Calendar.OCTOBER, 5, 22, 46);

        final List<Booking> bookings =
                calculatePlan(
                        "defect201110112/diagnostic_gtasks-2011-10-11___14-07-47-712.csv",
                        "defect201110112/diagnostic_gevents-2011-10-11___14-07-47-712.csv",
                        now);
        
        Assert.assertTrue(bookings.size() > 0);
    }

}

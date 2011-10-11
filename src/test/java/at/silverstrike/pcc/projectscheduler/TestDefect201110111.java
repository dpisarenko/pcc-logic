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
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.silverstrike.pcc.impl.jruby.RubyDateTimeUtils;

/**
 * @author DP118M
 * 
 */
public class TestDefect201110111 extends SchedulingDefectTestCase {
    static final Logger LOGGER =
            LoggerFactory.getLogger(TestDefect201110111.class);

    @Test
    public void testDefect201110051() {

        final Date now = RubyDateTimeUtils.getDate(2011,
                Calendar.OCTOBER, 5, 22, 46);

        calculatePlan(
                        "defect201110111/diagnostic_gtasks-2011-10-11___11-38-36-285.csv",
                        "defect201110111/diagnostic_gevents-2011-10-11___11-38-36-285.csv",
                        now);
    }

}

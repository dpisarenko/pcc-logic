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

package at.silverstrike.pcc.impl.testutils;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gdata.data.DateTime;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.gdata.data.extensions.When;

/**
 * @author DP118M
 * 
 */
public final class Csv2GoogleCalendarEventEntries {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(Csv2GoogleCalendarEventEntries.class);
    private static final String CSV_FIELD_SEPARATOR = ";";

    @SuppressWarnings("unchecked")
    public static List<CalendarEventEntry> csvToGoogleEvents(final File aFile) {
        List<String> lines = null;
        try {
            lines = FileUtils.readLines(aFile, "UTF-8");
        } catch (final IOException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }

        List<CalendarEventEntry> returnValue =
                new LinkedList<CalendarEventEntry>();
        for (final String curLine : lines) {
            final String[] fields =
                    StringUtils.splitByWholeSeparatorPreserveAllTokens(curLine,
                            CSV_FIELD_SEPARATOR);
            final CalendarEventEntry event = new CalendarEventEntry();

            event.setTitle(new PlainTextConstruct(fields[1]));
            final When when = new When();
            when.setStartTime(DateTime.parseDateTime(fields[2]));
            when.setEndTime(DateTime.parseDateTime(fields[3]));
            event.getTimes().add(when);

            returnValue.add(event);
        }

        return returnValue;
    }
}

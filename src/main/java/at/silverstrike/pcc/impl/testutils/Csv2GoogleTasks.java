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

/**
 * @author DP118M
 * 
 */
public final class Csv2GoogleTasks {
    private static final String CSV_FIELD_SEPARATOR = ";";
    private static final int POSITION_INDEX = 5;
    private static final int COMPLETED_INDEX = 4;
    private static final int NOTES_INDEX = 3;
    private static final int PARENT_INDEX = 2;
    private static final int TITLE_INDEX = 1;
    private static final int ID_INDEX = 0;
    private static final Logger LOGGER =
            LoggerFactory.getLogger(Csv2GoogleTasks.class);

    @SuppressWarnings("unchecked")
    public static List<com.google.api.services.tasks.v1.model.Task> csvToGoogleTasks(
            final File aFile) {
        List<String> lines = null;
        try {
            lines = FileUtils.readLines(aFile, "UTF-8");
        } catch (final IOException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }
        final List<com.google.api.services.tasks.v1.model.Task> returnValue =
                new LinkedList<com.google.api.services.tasks.v1.model.Task>();

        for (final String curLine : lines) {
            final String[] fields =
                    StringUtils.splitByWholeSeparatorPreserveAllTokens(curLine,
                            CSV_FIELD_SEPARATOR);
            final com.google.api.services.tasks.v1.model.Task task =
                    new com.google.api.services.tasks.v1.model.Task();

            task.id = fields[ID_INDEX];
            task.title = fields[TITLE_INDEX];
            task.parent = fields[PARENT_INDEX];
            task.notes = fields[NOTES_INDEX];
            task.completed = fields[COMPLETED_INDEX];
            task.position = fields[POSITION_INDEX];

            returnValue.add(task);
        }

        return returnValue;
    }

}

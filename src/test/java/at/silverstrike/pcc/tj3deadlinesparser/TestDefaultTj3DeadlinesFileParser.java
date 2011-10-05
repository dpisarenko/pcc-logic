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

package at.silverstrike.pcc.tj3deadlinesparser;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;
import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.PccException;

import at.silverstrike.pcc.api.tj3deadlinesparser.Tj3DeadlinesFileParser;
import at.silverstrike.pcc.impl.testutils.MockInjectorFactory;
import at.silverstrike.pcc.impl.tj3deadlinesparser.DefaultTj3DeadlinesFileParserFactory;

import com.google.inject.Injector;

/**
 * @author DP118M
 * 
 */
public class TestDefaultTj3DeadlinesFileParser {
    private static final Logger LOGGER =
            LoggerFactory
                    .getLogger(TestDefaultTj3DeadlinesFileParserFactory.class);
    public static final String DIR = "src/test/resources/at/silverstrike/"
        + "pcc/test/tj3deadlinesparser/";

    @Test
    public void testRun() {
        Tj3DeadlinesFileParser parser = getParser();
        parser.setInputFileName(DIR+"testRun.csv");
        try {
            parser.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }
    }

    private Tj3DeadlinesFileParser getParser() {
        final Injector injector =
                new MockInjectorFactory(new MockInjectorModule())
                        .createInjector();
        final DefaultTj3DeadlinesFileParserFactory objectUnderTest =
                new DefaultTj3DeadlinesFileParserFactory();

        objectUnderTest.setInjector(injector);

        Tj3DeadlinesFileParser parser = null;
        try {
            parser = objectUnderTest.create();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            fail(exception.getMessage());
        }

        assertNotNull(parser);

        parser.setInjector(injector);
        return parser;
    }
}

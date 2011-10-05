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

package at.silverstrike.pcc.export2tj3;

import static at.silverstrike.pcc.impl.testutils.LineComparer.assertLinesEqual;

import java.io.File;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.InjectorFactory;
import ru.altruix.commons.api.di.PccException;
import at.silverstrike.pcc.api.export2tj3.TaskJuggler3Exporter;
import at.silverstrike.pcc.api.projectscheduler.ProjectExportInfo;
import at.silverstrike.pcc.impl.mockpersistence.MockProjectExportInfo;
import at.silverstrike.pcc.impl.testutils.LineReader;
import at.silverstrike.pcc.impl.testutils.MockInjectorFactory;

import com.google.inject.Injector;

/**
 * @author DP118M
 * 
 */
public class TestDefaultTaskJuggler3Defect201109301 {
    private static final File ACTUAL_RESULTS_FILE = new File(
            "src/test/resources/at/silverstrike/pcc/test/export2tj3/"
                    + "testDefect201109301.actual.txt");
    private static final File EXPECTED_RESULTS_FILE = new File(
            "src/test/resources/at/silverstrike/pcc/test/export2tj3/"
                    + "testDefect201109301.expected.txt");
    private final Helper helper = new Helper();
    private static final Logger LOGGER = LoggerFactory
            .getLogger(TestDefaultTaskJuggler3Defect201109301.class);

    @Test
    public void testDefect201109301() {
        /**
         * Create the injector
         */
        final InjectorFactory injectorFactory = new MockInjectorFactory(
                new MockInjectorModule());
        final Injector injector = injectorFactory.createInjector();

        /**
         * Get object under test
         */
        final TaskJuggler3Exporter objectUnderTest = injector
                .getInstance(TaskJuggler3Exporter.class);

        Assert.assertNotNull(objectUnderTest);

        objectUnderTest.setInjector(injector);

        /**
         * Set input data
         */
        final ProjectExportInfo projectExportInfo = new MockProjectExportInfo();

        objectUnderTest.setProjectExportInfo(projectExportInfo);

        projectExportInfo.setSchedulingObjectsToExport(this.helper
                .getDefect201109301Processes());
        projectExportInfo.setCopyright("Dmitri Pisarenko");
        projectExportInfo.setCurrency(Helper.EURO);
        projectExportInfo.setNow(helper.getDateDefect201109301());
        projectExportInfo.setProjectName("MyProject");
        projectExportInfo.setResourcesToExport(this.helper
                .getTestRun03Resources());
        projectExportInfo.setSchedulingHorizonMonths(Helper.ONE_MONTH);

        /**
         * Run the method under test
         */
        try {
            objectUnderTest.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }

        /**
         * Get actual results
         */
        final String actualResult = objectUnderTest
                .getTaskJugglerIIIProjectFileContents();

        helper.writeStringToFile(actualResult, ACTUAL_RESULTS_FILE);

        final List<String> actualLines = LineReader
                .readTrimmedLines(ACTUAL_RESULTS_FILE);

        /**
         * Get expected results
         */
        final List<String> expectedLines = LineReader
                .readTrimmedLines(EXPECTED_RESULTS_FILE);

        /**
         * Compare actual and expected result
         */
        assertLinesEqual(expectedLines, actualLines);

    }
}

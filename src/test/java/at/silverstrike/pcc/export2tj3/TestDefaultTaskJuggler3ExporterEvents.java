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

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.InjectorFactory;
import ru.altruix.commons.api.di.PccException;
import at.silverstrike.pcc.api.export2tj3.TaskJuggler3Exporter;
import at.silverstrike.pcc.api.projectscheduler.ProjectExportInfo;
import at.silverstrike.pcc.impl.mockpersistence.MockProjectExportInfo;
import at.silverstrike.pcc.impl.testutils.MockInjectorFactory;

import com.google.inject.Injector;

/**
 * @author DP118M
 * 
 */
public class TestDefaultTaskJuggler3ExporterEvents {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(TestDefaultTaskJuggler3ExporterEvents.class);
    private final Helper helper = new Helper();
    
    @Test
    public void testOnEvents() {
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
                .getTestOnEvents());
        projectExportInfo.setCopyright("Dmitri Pisarenko");
        projectExportInfo.setCurrency(Helper.EURO);
        projectExportInfo.setNow(helper.getDate18October2010());
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
            /**
             * If a class cast exception occurs, the test case fails.
             */
        }
    }

}

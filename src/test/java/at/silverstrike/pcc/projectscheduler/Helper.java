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

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.Assert;
import ru.altruix.commons.api.di.PccException;

import com.google.inject.Injector;

import at.silverstrike.pcc.api.gcaltasks2pccimporter.GoogleCalendarTasks2PccImporter2;
import at.silverstrike.pcc.api.gcaltasks2pccimporter.GoogleCalendarTasks2PccImporter2Factory;
import at.silverstrike.pcc.api.model.Booking;
import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.model.Task;
import at.silverstrike.pcc.api.model.Resource;
import at.silverstrike.pcc.api.model.ResourceAllocation;
import at.silverstrike.pcc.api.model.UserData;
import at.silverstrike.pcc.api.persistence.Persistence;
import at.silverstrike.pcc.api.projectscheduler.ProjectExportInfo;
import at.silverstrike.pcc.api.projectscheduler.ProjectScheduler;
import at.silverstrike.pcc.impl.jruby.RubyDateTimeUtils;
import at.silverstrike.pcc.impl.mockpersistence.MockObjectFactory;

/**
 * @author dp118m
 * 
 */
class Helper {
    private static final String CSV_FIELD_SEPARATOR = ";";
    private static final int POSITION_INDEX = 5;
    private static final int COMPLETED_INDEX = 4;
    private static final int NOTES_INDEX = 3;
    private static final int PARENT_INDEX = 2;
    private static final int TITLE_INDEX = 1;
    private static final int ID_INDEX = 0;
    private static final Logger LOGGER =
            LoggerFactory.getLogger(Helper.class);
    public static final String DIR = "src/test/resources/at/silverstrike/"
            + "pcc/test/projectscheduler/";
    public static final String TJ3_PATH = "C:\\Ruby191\\bin\\tj3.bat";

    private static final MockObjectFactory MOCK_OBJECT_FACTORY =
            new MockObjectFactory();

    public void fillProjectInfo01(final ProjectExportInfo aInfo) {
        final MockObjectFactory mockObjectFactory = new MockObjectFactory();

        final List<SchedulingObject> processes =
                new LinkedList<SchedulingObject>();

        final Task task = mockObjectFactory.createControlProcess(2010L);

        task.setName("Some interesting task");
        task.setPriority(200);
        task.setBestCaseEffort(2.5);
        task.setWorstCaseEffort(2.5);

        final ResourceAllocation resourceAllocation =
                mockObjectFactory.createResourceAllocation();
        resourceAllocation.setResource(getWorker1210());

        assertNotNull(task.getResourceAllocations());

        task.getResourceAllocations().add(resourceAllocation);

        processes.add(task);

        final List<Resource> resources = new LinkedList<Resource>();

        resources.add(getWorker1210());

        aInfo.setSchedulingObjectsToExport(processes);
        aInfo.setResourcesToExport(resources);
        aInfo.setCopyright("DP");
        aInfo.setCurrency("EUR");
        aInfo.setNow(RubyDateTimeUtils.getDate(2010, Calendar.OCTOBER, 25, 11,
                30));
        aInfo.setProjectName("Sample project");
        aInfo.setSchedulingHorizonMonths(1);
    }

    private Resource getWorker1210() {
        final Resource worker = MOCK_OBJECT_FACTORY.createResource(1210L);

        worker.setAbbreviation("DP");
        worker.setDailyLimitInHours(8);
        return worker;
    }

    private Resource getWorkerDP(final Persistence aPersistence) {
        final Long id =
                aPersistence.createHumanResource("DP", "Dmitri", "Anatl'evich",
                        "Pisarenko", 8.0);
        final Resource worker = aPersistence.getResource(id);
        worker.setDailyLimitInHours(8);
        return worker;
    }

    public void fillProjectInfo02(final ProjectExportInfo aInfo,
            final Persistence aPersistence, final UserData aUserData) {
        final List<SchedulingObject> processes =
                new LinkedList<SchedulingObject>();

        final Long id = aPersistence.createTask("Some interesting task");
        final Task task = aPersistence.getTask(id);

        task.setPriority(200);
        task.setBestCaseEffort(2.5);
        task.setWorstCaseEffort(2.5);

        final Resource resource = getWorkerDP(aPersistence);

        aPersistence.handoffProcess(id, resource.getId());

        assertNotNull(task.getResourceAllocations());

        processes.add(task);

        final List<Resource> resources = new LinkedList<Resource>();

        resources.add(resource);

        aInfo.setSchedulingObjectsToExport(processes);
        aInfo.setResourcesToExport(resources);
        aInfo.setCopyright("DP");
        aInfo.setCurrency("EUR");
        aInfo.setNow(RubyDateTimeUtils.getDate(2010, Calendar.OCTOBER, 25, 11,
                30));
        aInfo.setProjectName("Sample project");
        aInfo.setSchedulingHorizonMonths(1);
        aInfo.setUserData(aUserData);

    }

    public
            List<SchedulingObject>
            importTasks(
                    final List<com.google.api.services.tasks.v1.model.Task> aGoogleTasks,
                    final Injector aInjector) {
        final GoogleCalendarTasks2PccImporter2Factory factory =
                aInjector
                        .getInstance(GoogleCalendarTasks2PccImporter2Factory.class);
        final GoogleCalendarTasks2PccImporter2 objectUnderTest =
                factory.create();
        objectUnderTest.setInjector(aInjector);

        final UserData user = new MockObjectFactory().createUserData();

        // Prepare test data (END)
        objectUnderTest.setGoogleTasks(aGoogleTasks);
        objectUnderTest.setInjector(aInjector);
        objectUnderTest.setUser(user);
        try {
            objectUnderTest.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }

        final List<SchedulingObject> createdPccTasks =
                objectUnderTest.getCreatedPccTasks();

        return createdPccTasks;
    }

    public List<Booking> calculatePlan(final Injector aInjector,
            final Persistence aPersistence,
            final List<SchedulingObject> aPccTasks) {
        final ProjectScheduler objectUnderTest =
                aInjector.getInstance(ProjectScheduler.class);

        assertNotNull(objectUnderTest);

        final ProjectExportInfo projectInfo =
                getProjectInfo(aPersistence, aPccTasks, objectUnderTest);

        objectUnderTest.setInjector(aInjector);
        objectUnderTest.setTaskJugglerPath(TJ3_PATH);
        objectUnderTest.setTransientMode(true);
        objectUnderTest
                .setDirectory(DIR);
        objectUnderTest.setNow(projectInfo.getNow());

        /**
         * Delete project, bookings and deadline files
         */
        cleanupTargetDirectory();

        try {
            objectUnderTest.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
            fail(exception.getMessage());
        }

        final List<Booking> bookings = objectUnderTest.getBookings();

        return bookings;
    }

    private ProjectExportInfo getProjectInfo(final Persistence aPersistence,
            final List<SchedulingObject> aPccTasks,
            final ProjectScheduler aObjectUnderTest) {
        final ProjectExportInfo projectInfo = aObjectUnderTest
                .getProjectExportInfo();

        assertNotNull(projectInfo);

        aPersistence.createSuperUser();
        final UserData user = aPersistence.getUser(Persistence.SUPER_USER_NAME,
                Persistence.SUPER_USER_PASSWORD);

        assertNotNull(user);

        final List<Resource> resources = getResources(aPersistence);

        projectInfo.setSchedulingObjectsToExport(aPccTasks);
        projectInfo.setResourcesToExport(resources);
        projectInfo.setCopyright("DP");
        projectInfo.setCurrency("EUR");
        projectInfo.setNow(RubyDateTimeUtils.getDate(2011, Calendar.SEPTEMBER,
                4, 17,
                37));
        projectInfo.setProjectName("Sample project");
        projectInfo.setSchedulingHorizonMonths(1);
        projectInfo.setUserData(user);
        return projectInfo;
    }

    private List<Resource> getResources(final Persistence aPersistence) {
        final List<Resource> resources = new LinkedList<Resource>();

        final Long id =
                aPersistence.createHumanResource("DP", "Dmitri", "Anatl'evich",
                        "Pisarenko", 8.0);
        final Resource worker = aPersistence.getResource(id);
        worker.setDailyLimitInHours(8);
        resources.add(worker);
        return resources;
    }

    public void cleanupTargetDirectory() {
        new File(DIR + "/pccBookings.tji.tjp").delete();
        new File(DIR + "/pccDeadlines.csv").delete();
        new File(DIR + "/pccProject.tjp").delete();
    }

    @SuppressWarnings("unchecked")
    public List<com.google.api.services.tasks.v1.model.Task> csvToGoogleTasks(
            final File aFile) {
        List<String> lines = null;
        try {
            lines = FileUtils.readLines(aFile);
        } catch (final IOException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }
        final List<com.google.api.services.tasks.v1.model.Task> returnValue =
                new LinkedList<com.google.api.services.tasks.v1.model.Task>();

        for (final String curLine : lines) {
            final String[] fields =
                    StringUtils.splitByWholeSeparatorPreserveAllTokens(curLine, CSV_FIELD_SEPARATOR);
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

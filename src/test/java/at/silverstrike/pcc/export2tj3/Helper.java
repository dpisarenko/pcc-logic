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

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.model.Task;
import at.silverstrike.pcc.api.model.Resource;
import at.silverstrike.pcc.api.model.ResourceAllocation;
import at.silverstrike.pcc.impl.mockpersistence.MockObjectFactory;

final class Helper {
    public static final int ONE_MONTH = 1;
    public static final String EURO = "EUR";

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Helper.class);

    private static final MockObjectFactory MOCK_OBJECT_FACTORY =
            new MockObjectFactory();

    public String readStringFromFile(final File aFile) {
        String expectedResult = null;

        try {
            expectedResult = FileUtils.readFileToString(aFile);
        } catch (final IOException exception) {
            LOGGER.error("", exception);
            fail(exception.getMessage());
        }
        return expectedResult;
    }

    public void writeStringToFile(final String aActualResult, final File aFile) {
        try {
            FileUtils.writeStringToFile(aFile,
                    aActualResult);
        } catch (final IOException exception) {
            LOGGER.error("", exception);
            fail(exception.getMessage());
        }
    }

    public Date getDate18October2010() {
        final GregorianCalendar calendar =
                new GregorianCalendar(2010, Calendar.OCTOBER, 18);
        final Date now = calendar.getTime();
        return now;
    }

    public List<SchedulingObject> getTestRun01Processes() {
        final List<SchedulingObject> processes =
                new LinkedList<SchedulingObject>();

        processes.add(MOCK_OBJECT_FACTORY.createControlProcess(null));
        processes.add(MOCK_OBJECT_FACTORY.createControlProcess(null));

        return processes;
    }

    public List<Resource> getTestRun01Resources() {
        final List<Resource> resources = new LinkedList<Resource>();

        resources.add(MOCK_OBJECT_FACTORY.createResource(null));

        return resources;
    }

    public List<Resource> getTestRun03Resources() {
        final List<Resource> resources = new LinkedList<Resource>();

        resources.add(getWorker1210());

        return resources;

    }

    private Resource getWorker1210() {
        final Resource worker = MOCK_OBJECT_FACTORY.createResource(1210L);

        worker.setAbbreviation("DP");
        worker.setDailyLimitInHours(8);
        return worker;
    }

    public List<SchedulingObject> getTestRun03Processes() {
        final List<SchedulingObject> processes =
                new LinkedList<SchedulingObject>();

        final Task task = MOCK_OBJECT_FACTORY.createControlProcess(2010L);

        task.setName("Some interesting task");
        task.setPriority(200);
        task.setEffort(2.5);

        final ResourceAllocation resourceAllocation =
                MOCK_OBJECT_FACTORY.createResourceAllocation();
        resourceAllocation.setResource(getWorker1210());

        assertNotNull(task.getResourceAllocations());

        task.getResourceAllocations().add(resourceAllocation);

        processes.add(task);

        return processes;
    }

    public List<SchedulingObject> getTestDefect59Processes() {
        final List<SchedulingObject> processes =
                new LinkedList<SchedulingObject>();

        final Task task = MOCK_OBJECT_FACTORY.createControlProcess(null);

        task.setName(null);
        task.setPriority(null);

        Assert.assertNull(task.getName());
        Assert.assertNull(task.getId());
        Assert.assertNull(task.getPriority());
        Assert.assertNull(task.getEffort());

        final ResourceAllocation resourceAllocation =
                MOCK_OBJECT_FACTORY.createResourceAllocation();
        resourceAllocation.setResource(getWorker1210());

        assertNotNull(task.getResourceAllocations());

        task.getResourceAllocations().add(resourceAllocation);

        processes.add(task);

        return processes;
    }

    public List<Resource> getTestValidateInputsResources() {
        final List<Resource> resources = new LinkedList<Resource>();

        resources.add(MOCK_OBJECT_FACTORY.createResource(20L));

        return resources;

    }

    public List<SchedulingObject> getTestValidateInputsProcesses() {
        final List<SchedulingObject> processes =
                new LinkedList<SchedulingObject>();

        final Task task = MOCK_OBJECT_FACTORY.createControlProcess(null);

        task.setName(null);
        task.setPriority(null);

        Assert.assertNull(task.getName());
        Assert.assertNull(task.getId());
        Assert.assertNull(task.getPriority());
        Assert.assertNull(task.getEffort());

        processes.add(task);

        return processes;
    }

    public List<SchedulingObject> getTestOnEvents() {
        final List<SchedulingObject> processes =
                new LinkedList<SchedulingObject>();

        processes.add(MOCK_OBJECT_FACTORY.createControlProcess(null));
        processes.add(MOCK_OBJECT_FACTORY.createEvent());

        return processes;
    }

    public Date getDateDefect201109301() {
        final GregorianCalendar calendar =
                new GregorianCalendar(2011, Calendar.OCTOBER, 5, 22, 02);
        final Date now = calendar.getTime();
        return now;
    }

    public List<SchedulingObject> getDefect201109301Processes() {
        return getTestRun03Processes();
    }

}

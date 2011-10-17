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

package at.silverstrike.pcc.xmlserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ru.altruix.commons.api.di.PccException;

import at.silverstrike.pcc.api.model.Booking;
import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.model.Task;
import at.silverstrike.pcc.api.model.ProcessState;
import at.silverstrike.pcc.api.model.Resource;
import at.silverstrike.pcc.api.model.ResourceAllocation;
import at.silverstrike.pcc.api.model.UserData;
import at.silverstrike.pcc.api.xmlserialization.XmlDeserializer;
import at.silverstrike.pcc.api.xmlserialization.XmlDeserializerFactory;
import at.silverstrike.pcc.api.xmlserialization.XmlSerializer;
import at.silverstrike.pcc.api.xmlserialization.XmlSerializerFactory;
import at.silverstrike.pcc.impl.mockpersistence.MockObjectFactory;
import at.silverstrike.pcc.impl.xmlserialization.DefaultXmlDeserializerFactory;
import at.silverstrike.pcc.impl.xmlserialization.DefaultXmlSerializerFactory;

import junit.framework.Assert;
import junit.framework.TestCase;

public class XmlSerializerDeserializerTest extends TestCase {

    @Test
    public final void testSerializationDeserialization() {
        // Init objects under test
        final XmlSerializerFactory serializerFactory =
                new DefaultXmlSerializerFactory();
        final XmlSerializer serializer = serializerFactory.create();
        final XmlDeserializerFactory deserializerFactory;
        deserializerFactory = new DefaultXmlDeserializerFactory();
        final XmlDeserializer deserializer = deserializerFactory.create();
        // Build the object graph (start)
        final MockObjectFactory objectFactory = new MockObjectFactory();
        final UserData writtenData = objectFactory.createUserData();
        // Now add stuff to UserData instance -
        // control processes,
        // nested control processes,
        // bookings,
        // daily plans,
        // to-do lists and
        // schedules.
        final Task process1 = objectFactory.createControlProcess();
        process1.setName("process1");
        process1.setEstimatedCompletionDateTime(new Date());
        process1.setEffort(1.1);
        
        final Task parent = objectFactory.createControlProcess();
        parent.setEstimatedCompletionDateTime(new Date());
        parent.setEffort(3.3);
        parent.setName("parent");
        parent.setParent(objectFactory.createControlProcess());
        parent.setPredecessors(new HashSet<SchedulingObject>());
        parent.setPriority(1);
        parent.setResourceAllocations(new ArrayList<ResourceAllocation>());
        parent.setState(ProcessState.ATTAINED);
        parent.setEffort(6.7);
        process1.setParent(parent);
        final Set<SchedulingObject> predecessors =
                new HashSet<SchedulingObject>();
        final Task firstPredecessors = objectFactory.createControlProcess();
        firstPredecessors.setEstimatedCompletionDateTime(new Date());
        firstPredecessors.setEffort(2.2);
        firstPredecessors.setName("firstPredecessors");
        firstPredecessors.setParent(objectFactory.createControlProcess());
        firstPredecessors.setPriority(1);
        final List<ResourceAllocation> resourceAllocations =
                new ArrayList<ResourceAllocation>();
        final ResourceAllocation resourceAllocation = objectFactory
                .createResourceAllocation();
        final Resource resource = objectFactory.createResource();
        resource.setAbbreviation("Abbreviation");
        resource.setDailyLimitInHours(4.4);
        resourceAllocation.setResource(resource);
        resourceAllocations.add(resourceAllocation);
        firstPredecessors.setResourceAllocations(resourceAllocations);
        firstPredecessors.setState(ProcessState.REPORTED);
        firstPredecessors.setEffort(5.5);
        firstPredecessors.setEstimatedCompletionDateTime(new Date());
        predecessors.add(firstPredecessors);
        process1.setPredecessors(predecessors);
        process1.setPriority(5);
        process1.setResourceAllocations(new ArrayList<ResourceAllocation>());
        process1.setState(ProcessState.ATTAINED);
        process1.setEffort(7.7);
        process1.setEstimatedCompletionDateTime(new Date());
        writtenData.setSchedulingData(new ArrayList<SchedulingObject>());
        writtenData.getSchedulingData().add(process1);
        final Booking booking = objectFactory.createBooking();
        booking.setDuration(3.4);
        booking.setProcess(objectFactory.createControlProcess());
        booking.setResource(objectFactory.createResource());
        booking.setStartDateTime(new Date());
        writtenData.setIdentifier("1st user data identifier");
        writtenData.setBookings(new ArrayList<Booking>());
        final Booking booking1 = objectFactory.createBooking();
        booking1.setDuration(1.6);
        booking1.setProcess(objectFactory.createControlProcess());
        booking1.setResource(objectFactory.createResource());
        booking1.setStartDateTime(new Date());
        writtenData.getBookings().add(booking1);

        // Build the object graph (end)

        // Serialize writtenData to targetFile (start)
        // targetFile should be located somewhere
        // in test/resources/at/swdev/
        // test/xmlserialization/testSerializationDeserialization.xml
        File targetFile = null;
        targetFile =
                new File(
                        "src/test/resources/at/silverstrike/"
                                + "pcc/test/xmlserialization/testSerializationDeserialization.xml");
        FileOutputStream fileOutputStream = null;
        // Init fileOutputStream
        try {
            fileOutputStream = new FileOutputStream(targetFile);
        } catch (final FileNotFoundException exception) {
            Assert.fail(exception.getMessage());
        }
        serializer.setOutputStream(fileOutputStream);
        serializer.setUserData(writtenData);
        try {
            serializer.run();
        } catch (final PccException exception) {
            Assert.fail(exception.getMessage());
        }
        // Serialize writtenData to targetFile (end)
        // Deserialize (start)
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(targetFile);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
        deserializer.setInputStream(fileInputStream);
        try {
            deserializer.run();
        } catch (final PccException exception) {
            Assert.fail(exception.getMessage());
        }

        final UserData readData = deserializer.getUserData();
        // Deserialize (end)

        // Compare serialized and deserialized object graphs
        Assert.assertNotNull(readData);
        Assert.assertEquals(writtenData.getSchedulingData().size(), readData
                .getSchedulingData().size());

        Assert.assertNotNull(readData);

        // test processes
        final int writtenProcessesSize = writtenData.getSchedulingData().size();
        final int readProcessesSize = readData.getSchedulingData().size();
        Assert.assertEquals(writtenProcessesSize, readProcessesSize);
        if (writtenProcessesSize == readProcessesSize) {
            for (int i = 0; i < writtenProcessesSize; i++) {
                testProcess((Task) writtenData.getSchedulingData().get(i),
                        (Task) readData
                                .getSchedulingData().get(i));
            }
        }

        // test identifier
        Assert.assertEquals(writtenData.getIdentifier(),
                readData.getIdentifier());

        // test bookings
        final int writtenDataBookingsSize = writtenData.getBookings().size();
        final int readDataBookingsSize = readData.getBookings().size();
        Assert.assertEquals(writtenDataBookingsSize, readDataBookingsSize);
        if (writtenDataBookingsSize == readDataBookingsSize) {
            for (int i = 0; i < writtenDataBookingsSize; i++) {
                final Booking written = writtenData.getBookings().get(i);
                final Booking read = readData.getBookings().get(i);
                testBooking(written, read);
            }
        }
    }



    private void testResource(final Resource aWritten,
            final Resource aRead) {
        if (aWritten.getAbbreviation() != null) {
            Assert.assertEquals(aWritten.getAbbreviation(),
                    aRead.getAbbreviation());
        }
        Assert.assertEquals(aWritten.getDailyLimitInHours(),
                aRead.getDailyLimitInHours());
        if (aWritten.getId() != null) {
            Assert.assertEquals(aWritten.getId(), aRead.getId());
        }
    }


    private void testBooking(final Booking aWritten, final Booking aRead) {
        if (aWritten.getDuration() != 0) {
            Assert.assertEquals(aWritten.getDuration(), aRead.getDuration());
        }
        if (aWritten.getEndDateTime() != null) {
            Assert.assertEquals(aWritten.getEndDateTime(),
                    aRead.getEndDateTime());
        }
        if (aWritten.getId() != null) {
            Assert.assertEquals(aWritten.getId(), aRead.getId());
        }
        if (aWritten.getStartDateTime() != null) {
            Assert.assertEquals(aWritten.getStartDateTime(),
                    aRead.getStartDateTime());
        }
        if (aWritten.getResource() != null) {
            testResource(aWritten.getResource(), aRead.getResource());
        }
        if (aWritten.getProcess() != null) {
            testProcess(aWritten.getProcess(), aRead.getProcess());
        }
    }

    private void testProcess(final Task aWritten, final Task aRead) {
        if (aWritten.getName() != null) {
            Assert.assertEquals(aWritten.getName(), aRead.getName());
        }
        if (aWritten.getEstimatedCompletionDateTime() != null)
        {
            Assert.assertEquals(aWritten.getEstimatedCompletionDateTime(),
                    aRead.getEstimatedCompletionDateTime());
        }
        if (aWritten.getId() != null) {
            Assert.assertEquals(aWritten.getId(), aRead.getId());
        }
        if (aWritten.getParent() != null) {
            testProcess((Task) aWritten.getParent(), (Task) aRead.getParent());
        }
        if (aWritten.getPredecessors() != null) {
            final int writtenPredecesors = aWritten.getPredecessors().size();
            final int readPredecesors = aRead.getPredecessors().size();
            Assert.assertEquals(writtenPredecesors, readPredecesors);
            if (writtenPredecesors == readPredecesors) {
                for (int i = 0; i < writtenPredecesors; i++) {
                    testProcess((Task) aWritten.getPredecessors()
                            .toArray()[i], (Task) aRead
                            .getPredecessors().toArray()[i]);
                }
            }
        }
        if (aWritten.getPriority() != null) {
            Assert.assertEquals(aWritten.getPriority(), aRead.getPriority());
        }

        if (aWritten.getResourceAllocations() != null) {
            final int writtenResourceAllocation =
                    aWritten.getResourceAllocations()
                            .size();
            final int readResourceAllocation =
                    aRead.getResourceAllocations().size();
            Assert.assertEquals(writtenResourceAllocation,
                    readResourceAllocation);
            if (writtenResourceAllocation == readResourceAllocation) {
                for (int i = 0; i < writtenResourceAllocation; i++) {
                    testResourceAllocation(aWritten.getResourceAllocations()
                            .get(i), aRead.getResourceAllocations().get(i));
                }
            }
        }
        if (aWritten.getState() != null) {
            Assert.assertEquals(aWritten.getState(), aRead.getState());
        }
        if (aWritten.getEffort() != null) {
            Assert.assertEquals(aWritten.getEffort(),
                    aRead.getEffort());
        }
        if (aWritten.getEstimatedCompletionDateTime() != null) {
            Assert.assertEquals(aWritten.getEstimatedCompletionDateTime(),
                    aRead.getEstimatedCompletionDateTime());
        }
    }

    private void testResourceAllocation(final ResourceAllocation aWritten,
            final ResourceAllocation aRead) {
        if (aWritten.getId() != null) {
            Assert.assertEquals(aWritten.getId(), aRead.getId());
        }
        if (aWritten.getResource() != null) {
            testResource(aWritten.getResource(), aRead.getResource());
        }
    }
}

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

package at.silverstrike.pcc.impl.mockpersistence;

import at.silverstrike.pcc.api.model.Booking;
import at.silverstrike.pcc.api.model.Event;
import at.silverstrike.pcc.api.model.Milestone;
import at.silverstrike.pcc.api.model.Task;
import at.silverstrike.pcc.api.model.DailyLimitResourceAllocation;
import at.silverstrike.pcc.api.model.Resource;
import at.silverstrike.pcc.api.model.ResourceAllocation;
import at.silverstrike.pcc.api.model.UserData;
import at.silverstrike.pcc.api.model.Worker;
import at.silverstrike.pcc.api.persistence.Persistence;

public final class MockObjectFactory {

    public UserData createUserData() {
        return new MockUserData();
    }

    public Task createControlProcess(final Long aId) {
        final MockControlProcess mockControlProcess = new MockControlProcess();

        mockControlProcess.setId(aId);

        return mockControlProcess;
    }

    public Task createControlProcess() {
        return new MockControlProcess();
    }

    public Booking createBooking() {
        return new MockBooking();
    }

    public DailyLimitResourceAllocation
            createDailyLimitResourceAllocation() {
        return new MockDailyLimitResourceAllocation();
    }

    public Resource createResource() {
        return new MockResource();
    }

    public ResourceAllocation createResourceAllocation() {
        return new MockResourceAllocation();
    }

    public Worker createWorker() {
        return new MockWorker();
    }

    public Milestone createMilestone() {
        return new MockMilestone();
    }

    public Event createEvent() {
        return new MockEvent();
    }

    public Task createTask() {
        return new MockControlProcess();
    }

    public Resource createResource(final Long aId) {
        final MockResource returnValue = new MockResource();

        returnValue.setId(aId);
        returnValue.setAbbreviation("R");

        return returnValue;
    }

    public Persistence createPersistence() {
        return new MockPersistence();
    }
}

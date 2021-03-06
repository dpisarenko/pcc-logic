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

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.NotImplementedException;

import at.silverstrike.pcc.api.model.Booking;
import at.silverstrike.pcc.api.model.Event;
import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.model.Task;
import at.silverstrike.pcc.api.model.Resource;
import at.silverstrike.pcc.api.model.UserData;
import at.silverstrike.pcc.api.persistence.Persistence;
import at.silverstrike.pcc.api.tj3deadlinesparser.ProcessEndTimeTuple;

import com.google.inject.Injector;

class MockPersistence extends MockPersistenceAdapter implements Persistence {
    public static final long TASK_ID_1 = 1L;

    @Override
    public void closeSession() {
        throw new NotImplementedException();
    }

    @Override
    public Booking createBooking() {
        throw new NotImplementedException();
    }

    @Override
    public Long createHumanResource(final String aAbbreviation,
            final String aFirstName,
            final String aMiddleName, final String aSurname,
            final double aWorkHours) {
        throw new NotImplementedException();

    }

    @Override
    public Long createTask(final String aProcessName) {
        throw new NotImplementedException();

    }

    @Override
    public void generateDailyPlans(final Date aNow) {
        throw new NotImplementedException();

    }

    @Override
    public List<SchedulingObject> getChildTasks(final SchedulingObject aParent) {
        return new LinkedList<SchedulingObject>();
    }

    @Override
    public List<SchedulingObject> getChildTasks(final Long aProcessId) {
        throw new NotImplementedException();
    }

    @Override
    public List<SchedulingObject> getSubProcessesWithChildren(
            final Long aProcessId, final UserData aUser) {
        throw new NotImplementedException();
    }

    @Override
    public Task getTask(final Object aProcessid) {

        throw new NotImplementedException();
    }

    @Override
    public List<Task> getUncompletedTasksWithEstimatedEndTime() {
        throw new NotImplementedException();
    }

    @Override
    public void handoffProcess(final Long aProcessId, final Long aWorkerId) {
        throw new NotImplementedException();

    }

    @Override
    public void openSession(final String aHost, final String aUser,
            final String aPassword, final String aDatabase) {
        throw new NotImplementedException();

    }

    @Override
    public void setInjector(final Injector aInjector) {
        throw new NotImplementedException();

    }

    @Override
    public void updateTask(final Task aProcess) {
        throw new NotImplementedException();

    }

    @Override
    public void
            updateTaskEndTimes(final List<ProcessEndTimeTuple> aEndTimeTuples) {
        throw new NotImplementedException();

    }

    @Override
    public void clearDatabase() {
        throw new NotImplementedException();
    }

    @Override
    public Resource getResource(final Long aResourceId) {
        return null;
    }

    @Override
    public UserData getUserData() {
        throw new NotImplementedException();
    }

    @Override
    public boolean deleteEvent(final Event aEvent) {
        return false;
    }
}

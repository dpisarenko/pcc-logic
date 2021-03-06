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

import java.io.File;
import java.util.Date;
import java.util.List;

import com.google.inject.Injector;

import at.silverstrike.pcc.api.model.Booking;
import at.silverstrike.pcc.api.model.Event;
import at.silverstrike.pcc.api.model.InvitationRequest;
import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.model.Task;
import at.silverstrike.pcc.api.model.Resource;
import at.silverstrike.pcc.api.model.UserData;
import at.silverstrike.pcc.api.model.Worker;
import at.silverstrike.pcc.api.persistence.Persistence;
import at.silverstrike.pcc.api.tj3bookingsparser.BookingTuple;
import at.silverstrike.pcc.api.tj3deadlinesparser.ProcessEndTimeTuple;

public abstract class MockPersistenceAdapter implements Persistence {
    @Override
    public void closeSession() {
    }

    @Override
    public Booking createBooking() {
        return new MockBooking();
    }

    @Override
    public Long createHumanResource(final String aAbbreviation,
            final String aFirstName,
            final String aMiddleName, final String aSurname,
            final double aWorkTime) {
        return null;
    }

    @Override
    public Task createSubTask(final String aProcessName,
            final Long aParentProcessId, final UserData aUser) {
        return null;
    }

    @Override
    public Long createTask(final String aProcessName) {
        return null;
    }

    @Override
    public void generateDailyPlans(final Date aNow) {

    }

    @Override
    public List<SchedulingObject> getAllNotDeletedTasks(final UserData aUser) {
        return null;
    }

    @Override
    public List<SchedulingObject> getChildTasks(final SchedulingObject aParent) {
        return null;
    }

    @Override
    public List<SchedulingObject> getChildTasks(final Long aProcessId) {
        return null;
    }

    @Override
    public List<SchedulingObject> getSubProcessesWithChildren(
            final Long aProcessId, final UserData aUser) {
        return null;
    }

    @Override
    public Task getTask(final Object aProcessid) {
        return null;
    }

    @Override
    public List<Task> getUncompletedTasksWithEstimatedEndTime() {
        return null;
    }

    @Override
    public void handoffProcess(final Long aProcessId, final Long aWorkerId) {

    }

    @Override
    public void openSession(final String aHost, final String aUser,
            final String aPassword, final String aDatabase) {
    }

    @Override
    public void updateBookings(final List<BookingTuple> aBookingTuples,
            final UserData aUserData) {
    }

    @Override
    public void updateTask(final Task aProcess) {
    }

    @Override
    public void
            updateTaskEndTimes(final List<ProcessEndTimeTuple> aEndTimeTuples) {
    }

    @Override
    public void setInjector(final Injector aInjector) {
    }

    @Override
    public void clearDatabase() {
    }

    @Override
    public Resource getResource(final Long aResourceId) {
        return null;
    }

    @Override
    public UserData getUserData() {
        return null;
    }

    @Override
    public Event createSubEvent(final String aProcessName,
            final Long aParentProcessId, final UserData aUser) {
        return null;
    }

    @Override
    public boolean deleteEvent(final Event aEvent) {

        return false;
    }

    @Override
    public Worker getCurrentWorker(final UserData aUser) {

        return null;
    }

    @Override
    public boolean hasChildren(final SchedulingObject aObject) {

        return false;
    }

    @Override
    public void
            createInvitationRequest(final String aUserUrl) {

    }

    @Override
    public List<InvitationRequest> getInvitationRequests() {

        return null;
    }

    @Override
    public void
            rejectInvitationRequest(final InvitationRequest aSelectedRequest) {

    }

    @Override
    public void acceptInvitationRequest(final InvitationRequest aRequest,
            final String aUserIdentity) {
    }

    @Override
    public void createSuperUser() {

    }

    @Override
    public Long getUserCount() {

        return null;
    }

    @Override
    public UserData getUser(final String aUuserName, final String aPassword) {

        return null;
    }

    @Override
    public List<SchedulingObject> getTopLevelTasks(final UserData aUser) {
        return null;
    }

    @Override
    public List<Booking> getBookings(final UserData aUser) {

        return null;
    }

    @Override
    public void removeUserSchedulingObjects(final UserData aUser) {

    }

    @Override
    public Task createTaskStub() {
        return null;
    }

    public void exportSchema(final File aFile) {
    }

    @Override
    public UserData getUser(final Long aUserId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateUser(final UserData aUser) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<UserData> getAllusersWithAutomaticScheduling() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Task createTransientTask(final String aProcessName,
            final Long aParentProcessId,
            final UserData aUser, final long aTaskId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Booking> updateBookingsTransientMode(
            final List<BookingTuple> aBookingTuples, final UserData aUserData,
            final List<SchedulingObject> aSchedulingObjectsToExport) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Event createTransientEvent(final long aId) {
        // TODO Auto-generated method stub
        return null;
    }

}

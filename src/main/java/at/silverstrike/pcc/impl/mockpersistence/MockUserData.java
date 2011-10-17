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

import java.util.List;

import at.silverstrike.pcc.api.model.Booking;
import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.model.UserData;

class MockUserData implements UserData {
    private String identifier;
    private List<SchedulingObject> processes;
    private List<Booking> bookings;
    private String googleUsername;
    private String googlePassword;
    private boolean automaticScheduling;
    private int automaticSchedulingInterval; 

    
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(final String aIdentifier) {
        this.identifier = aIdentifier;
    }

    public List<SchedulingObject> getSchedulingData() {
        return processes;
    }

    public void setSchedulingData(final List<SchedulingObject> aProcesses) {
        this.processes = aProcesses;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(final List<Booking> aBookings) {
        this.bookings = aBookings;
    }

    @Override
    public void setUsername(final String aUsername) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPassword(final String aPassword) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long getId() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String getResourceName() {
        final StringBuilder builder = new StringBuilder();
        
        builder.append("R");
        builder.append(this.identifier);
        
        return builder.toString();
    }

    public String getGoogleUsername() {
        return googleUsername;
    }

    public void setGoogleUsername(final String aGoogleUsername) {
        this.googleUsername = aGoogleUsername;
    }

    public String getGooglePassword() {
        return googlePassword;
    }

    public void setGooglePassword(final String aGooglePassword) {
        this.googlePassword = aGooglePassword;
    }


    @Override
    public boolean isGoogleCalendarAccessGranted() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isGoogleTasksAccessGranted() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setGoogleTasksRefreshToken(final String aRefreshToken) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getGoogleTasksRefreshToken() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setGoogleCalendarOAuthVerifier(final String aVerifier) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getGoogleCalendarOAuthVerifier() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setGoogleCalendarOAuthToken(final String aToken) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getGoogleCalendarOAuthToken() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setGoogleCalendarOAuthTokenSecret(final String aTokenSecret) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getGoogleCalendarOAuthTokenSecret() {
        // TODO Auto-generated method stub
        return null;
    }

    public Boolean isAutomaticScheduling() {
        return automaticScheduling;
    }

    public void setAutomaticScheduling(final Boolean aAutomaticScheduling) {
        this.automaticScheduling = aAutomaticScheduling;
    }

    public Integer getAutomaticSchedulingInterval() {
        return automaticSchedulingInterval;
    }

    public void setAutomaticSchedulingInterval(final Integer aAutomaticSchedulingInterval) {
        this.automaticSchedulingInterval = aAutomaticSchedulingInterval;
    }
}

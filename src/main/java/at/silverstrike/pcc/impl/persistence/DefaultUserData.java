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

package at.silverstrike.pcc.impl.persistence;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import at.silverstrike.pcc.api.model.Booking;
import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.model.DailyPlan;
import at.silverstrike.pcc.api.model.UserData;

class DefaultUserData implements UserData {
    private String identifier;
    private List<SchedulingObject> schedulingObjects;
    private List<DailyPlan> dailyPlans;
    private List<Booking> bookings;
    private String username;
    private String password;
    private Long id;
    private String googleTasksRefreshToken;
    private String googleCalendarOAuthVerifier;
    private String googleCalendarOAuthToken;
    private String googleCalendarOAuthTokenSecret;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(final String aIdentifier) {
        this.identifier = aIdentifier;
    }

    public List<SchedulingObject> getSchedulingData() {
        return schedulingObjects;
    }

    public void setSchedulingData(final List<SchedulingObject> aProcesses) {
        this.schedulingObjects = aProcesses;
    }

    public List<DailyPlan> getDailyPlans() {
        return dailyPlans;
    }

    public void setDailyPlans(final List<DailyPlan> aDailyPlans) {
        this.dailyPlans = aDailyPlans;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(final List<Booking> aBookings) {
        this.bookings = aBookings;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long aId) {
        this.id = aId;
    }

    @Override
    public String getResourceName() {
        final StringBuilder builder = new StringBuilder();

        builder.append("R");
        builder.append(this.identifier);

        return builder.toString();
    }

    @Override
    public boolean isGoogleCalendarAccessGranted() {
        return (!StringUtils.isBlank(this.googleCalendarOAuthToken)) &&
                (!StringUtils.isBlank(this.googleCalendarOAuthTokenSecret)) &&
                (!StringUtils.isBlank(this.googleCalendarOAuthVerifier));
    }

    @Override
    public boolean isGoogleTasksAccessGranted() {
        return !StringUtils.isBlank(this.googleTasksRefreshToken);
    }

    public String getGoogleTasksRefreshToken() {
        return googleTasksRefreshToken;
    }

    public void setGoogleTasksRefreshToken(final String aRefreshToken) {
        this.googleTasksRefreshToken = aRefreshToken;
    }

    public String getGoogleCalendarOAuthVerifier() {
        return googleCalendarOAuthVerifier;
    }

    public void setGoogleCalendarOAuthVerifier(
            String aGoogleCalendarOAuthVerifier) {
        this.googleCalendarOAuthVerifier = aGoogleCalendarOAuthVerifier;
    }

    public String getGoogleCalendarOAuthToken() {
        return googleCalendarOAuthToken;
    }

    public void setGoogleCalendarOAuthToken(String googleCalendarOAuthToken) {
        this.googleCalendarOAuthToken = googleCalendarOAuthToken;
    }

    public String getGoogleCalendarOAuthTokenSecret() {
        return googleCalendarOAuthTokenSecret;
    }

    public void setGoogleCalendarOAuthTokenSecret(
            String googleCalendarOAuthTokenSecret) {
        this.googleCalendarOAuthTokenSecret = googleCalendarOAuthTokenSecret;
    }
}

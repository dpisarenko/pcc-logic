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
package at.silverstrike.pcc.api.model;

import java.util.List;

import ru.altruix.commons.api.conventions.UniquelyIdentifiableObject;

public interface UserData extends UniquelyIdentifiableObject {
    void setIdentifier(final String aIdentifier);

    String getIdentifier();

    void setSchedulingData(final List<SchedulingObject> aProcesses);

    List<SchedulingObject> getSchedulingData();

    void setDailyPlans(List<DailyPlan> aDailyPlans);

    List<DailyPlan> getDailyPlans();

    void setBookings(List<Booking> aBookings);

    List<Booking> getBookings();
    
    void setUsername(final String aUsername);
    String getUsername();
    
    void setPassword(final String aPassword);
    String getPassword();

    String getResourceName();
    
    boolean isGoogleCalendarAccessGranted();
    
    boolean isGoogleTasksAccessGranted();

    void setGoogleTasksRefreshToken(final String aRefreshToken);
    String getGoogleTasksRefreshToken();
    
    void setGoogleCalendarOAuthVerifier(final String aVerifier);
    String getGoogleCalendarOAuthVerifier();

    void setGoogleCalendarOAuthToken(final String aToken);
    String getGoogleCalendarOAuthToken();

    void setGoogleCalendarOAuthTokenSecret(final String aTokenSecret);
    String getGoogleCalendarOAuthTokenSecret();

    boolean isAutomaticScheduling();       
    void setAutomaticScheduling(final boolean aValue);
    
    int getAutomaticSchedulingInterval();
    void setAutomaticSchedulingInterval(final int aValue);
}

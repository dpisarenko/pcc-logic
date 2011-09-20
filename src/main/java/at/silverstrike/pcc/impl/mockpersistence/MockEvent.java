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

import at.silverstrike.pcc.api.model.Event;
import at.silverstrike.pcc.api.model.UserData;

/**
 * @author DP118M
 *
 */
class MockEvent extends MockSchedulingObject implements Event {
    private String place;
    private Date startDateTime;
    private Date endDateTime;
    private UserData user;

    public UserData getUserData() {
            return user;
    }

    public void setUserData(final UserData aUser) {
            this.user = aUser;
    }
    
    public String getPlace() {
        return place;
    }
    public void setPlace(final String aPlace) {
        this.place = aPlace;
    }
    public Date getStartDateTime() {
        return startDateTime;
    }
    public void setStartDateTime(final Date aStartDateTime) {
        this.startDateTime = aStartDateTime;
    }
    public Date getEndDateTime() {
        return endDateTime;
    }
    public void setEndDateTime(final Date aEndDateTime) {
        this.endDateTime = aEndDateTime;
    }

}

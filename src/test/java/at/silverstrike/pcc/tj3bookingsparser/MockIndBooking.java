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

package at.silverstrike.pcc.tj3bookingsparser;

import at.silverstrike.pcc.api.tj3bookingsparser.IndBooking;

public final class MockIndBooking implements IndBooking {

    private String startTime;

    private String duration;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(final String aStartTime) {
        this.startTime = aStartTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(final String aDuration) {
        this.duration = aDuration;
    }

}

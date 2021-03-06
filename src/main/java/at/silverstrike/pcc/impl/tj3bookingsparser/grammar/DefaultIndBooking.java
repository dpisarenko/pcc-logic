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

package at.silverstrike.pcc.impl.tj3bookingsparser.grammar;

import at.silverstrike.pcc.api.tj3bookingsparser.IndBooking;

/**
 * @author Dmitri Pisarenko
 * 
 */
public class DefaultIndBooking implements IndBooking {
    private String startTime;
    private String duration;

    public DefaultIndBooking(final String aStartTime, final String aDuration) {
        this.startTime = aStartTime;
        this.duration = aDuration;
    }

    public final String getStartTime() {
        return startTime;
    }

    public final String getDuration() {
        return duration;
    }
}

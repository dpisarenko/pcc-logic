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

import java.util.LinkedList;
import java.util.List;

import at.silverstrike.pcc.api.tj3bookingsparser.BookingStatement;
import at.silverstrike.pcc.api.tj3bookingsparser.SupplementStatement;

public final class MockSupplementStatement implements SupplementStatement {
    private String taskId;

    private List<BookingStatement> bookingStatements =
            new LinkedList<BookingStatement>();

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(final String aTaskId) {
        this.taskId = aTaskId;
    }

    public List<BookingStatement> getBookingStatements() {
        return bookingStatements;
    }

    public void setBookingStatements(
            final List<BookingStatement> aBookingStatements) {
        this.bookingStatements = aBookingStatements;
    }

}

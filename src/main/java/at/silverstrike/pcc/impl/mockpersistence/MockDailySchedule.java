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
import at.silverstrike.pcc.api.model.DailySchedule;
import at.silverstrike.pcc.api.model.UserData;

class MockDailySchedule implements DailySchedule {
    private Long id;
    private List<Booking> bookings;
    private UserData user;

    public UserData getUserData() {
        return user;
    }

    public void setUserData(UserData user) {
        this.user = user;
    }

    public Long getId() {
        return this.id;
    }

    public void setBookings(final List<Booking> aBookings) {
        this.bookings = aBookings;
    }

    public List<Booking> getBookings() {
        return this.bookings;
    }

}

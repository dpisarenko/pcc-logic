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

import at.silverstrike.pcc.api.model.Worker;

class MockWorker implements Worker {

    private String abbreviation;
    private double dailyLimit;
    private Long id;
    private String firstName;
    private String middleName;
    private String surname;

    public void setAbbreviation(final String aAbbreviation) {
        this.abbreviation = aAbbreviation;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public void setDailyLimitInHours(final double aDailyLimit) {
        this.dailyLimit = aDailyLimit;
    }

    public double getDailyLimitInHours() {
        return this.dailyLimit;
    }

    public Long getId() {
        return this.id;
    }

    public void setFirstName(final String aFirstName) {
        this.firstName = aFirstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setMiddleName(final String aMiddleName) {
        this.middleName = aMiddleName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setSurname(final String aSurname) {
        this.surname = aSurname;
    }

    public String getSurname() {
        return this.surname;
    }

}

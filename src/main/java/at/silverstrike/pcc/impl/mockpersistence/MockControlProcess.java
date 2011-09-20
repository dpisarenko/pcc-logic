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
import java.util.LinkedList;
import java.util.List;

import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.model.SchedulingObjectValidationError;
import at.silverstrike.pcc.api.model.Task;
import at.silverstrike.pcc.api.model.ResourceAllocation;
import at.silverstrike.pcc.api.model.UserData;

class MockControlProcess extends MockSchedulingObject implements Task {

    private Double bestCaseEffort;
    private Double worstCaseEffort;
    private List<ResourceAllocation> resourceAllocations =
            new LinkedList<ResourceAllocation>();
    private Date averageEstimatedEndDateTime;
    private Date bestEstimatedEndDateTime;
    private Date worstEstimatedEndDateTime;
    private SchedulingObjectValidationError validationError;
    private UserData user;
    private List<SchedulingObject> children;

    public MockControlProcess() {
        this.children = new LinkedList<SchedulingObject>();
    }

    public UserData getUserData() {
        return user;
    }

    public void setUserData(final UserData aUser) {
        this.user = aUser;
    }

    public Double getBestCaseEffort() {
        return this.bestCaseEffort;
    }

    public void setBestCaseEffort(final Double aEffortInHours) {
        this.bestCaseEffort = aEffortInHours;
    }

    @Override
    public double getAverageCaseEffort() {
        if ((this.bestCaseEffort != null) && (this.worstCaseEffort == null)) {
            return this.bestCaseEffort;
        } else if ((this.bestCaseEffort == null)
                && (this.worstCaseEffort != null)) {
            return this.worstCaseEffort;
        } else if ((this.bestCaseEffort == null)
                && (this.worstCaseEffort == null)) {
            return 0.;
        } else {
            return (this.bestCaseEffort + this.worstCaseEffort) / 2;
        }
    }

    public Double getWorstCaseEffort() {
        return this.worstCaseEffort;
    }

    public void setWorstCaseEffort(final Double aEffortInHours) {
        this.worstCaseEffort = aEffortInHours;

    }

    public void setResourceAllocations(
            final List<ResourceAllocation> aResourceAllocations) {
        this.resourceAllocations = aResourceAllocations;
    }

    public List<ResourceAllocation> getResourceAllocations() {
        return this.resourceAllocations;
    }

    public Date getAverageEstimatedEndDateTime() {
        return this.averageEstimatedEndDateTime;
    }

    public void setAverageEstimatedEndDateTime(final Date aDate) {
        this.averageEstimatedEndDateTime = aDate;
    }

    public Date getBestEstimatedEndDateTime() {
        return this.bestEstimatedEndDateTime;
    }

    public void setBestEstimatedEndDateTime(final Date aDate) {
        this.bestEstimatedEndDateTime = aDate;
    }

    public Date getWorstEstimatedEndDateTime() {
        return this.worstEstimatedEndDateTime;
    }

    public void setWorstEstimatedEndDateTime(final Date aDate) {
        this.worstEstimatedEndDateTime = aDate;
    }

    public SchedulingObjectValidationError getValidationError() {
        return validationError;
    }

    public void setValidationError(
            final SchedulingObjectValidationError aValidationError) {
        this.validationError = aValidationError;
    }

    public List<SchedulingObject> getChildren() {
        return children;
    }

    public void setChildren(final List<SchedulingObject> aChildren) {
        this.children = aChildren;
    }

}

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
    private Double effort;
    private Date dueDateTime;
    private Date estimatedCompletionDateTime;

    private List<ResourceAllocation> resourceAllocations =
            new LinkedList<ResourceAllocation>();
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

    public void setResourceAllocations(
            final List<ResourceAllocation> aResourceAllocations) {
        this.resourceAllocations = aResourceAllocations;
    }

    public List<ResourceAllocation> getResourceAllocations() {
        return this.resourceAllocations;
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

    public Double getEffort() {
        return effort;
    }

    public void setEffort(Double effort) {
        this.effort = effort;
    }

    public Date getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(Date dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public Date getEstimatedCompletionDateTime() {
        return estimatedCompletionDateTime;
    }

    public void setEstimatedCompletionDateTime(Date estimatedCompletionDateTime) {
        this.estimatedCompletionDateTime = estimatedCompletionDateTime;
    }

}

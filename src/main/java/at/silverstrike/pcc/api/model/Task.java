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

import java.util.Date;
import java.util.List;

public interface Task extends SchedulingObject {
    /**
     * Effort estimate property
     */
    Double getEffort();
    void setEffort(final Double aEffortInHours);
    
    /**
     * "Due to" date/time (deadline) property
     */
    Date getDueDateTime();
    void setDueDateTime(final Date aDueDateTime);
    
    /**
     * Estimated completion date/time
     */
    Date getEstimatedCompletionDateTime();
    void setEstimatedCompletionDateTime(final Date aEstimatedCompletionDate);
    
    void setResourceAllocations(final List<ResourceAllocation> aResourceAllocations);

    List<ResourceAllocation> getResourceAllocations();

    /**
     * Child tasks
     */
    void setChildren(final List<SchedulingObject> aChildren);
    List<SchedulingObject> getChildren();
}

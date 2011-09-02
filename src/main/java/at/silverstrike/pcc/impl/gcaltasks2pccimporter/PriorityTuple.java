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

package at.silverstrike.pcc.impl.gcaltasks2pccimporter;

final class PriorityTuple implements Comparable<PriorityTuple> {
    private String googleTaskId;
    private long position;
    private long parentPosition;
    private int priority;

    public String getGoogleTaskId() {
        return googleTaskId;
    }

    public void setGoogleTaskId(final String aGoogleTaskId) {
        this.googleTaskId = aGoogleTaskId;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(final long aPosition) {
        this.position = aPosition;
    }

    public long getParentPosition() {
        return parentPosition;
    }

    public void setParentPosition(final long aParentPosition) {
        this.parentPosition = aParentPosition;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(final int aPriority) {
        this.priority = aPriority;
    }

    public long getMaxPositionParentPosition() {
        return Math.max(this.parentPosition, this.position);
    }

    @Override
    public int compareTo(final PriorityTuple aOtherTuple) {
        return (int) (this.getMaxPositionParentPosition() - aOtherTuple
                .getMaxPositionParentPosition());
    }
}

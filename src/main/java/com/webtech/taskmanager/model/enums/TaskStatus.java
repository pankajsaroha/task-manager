package com.webtech.taskmanager.model.enums;

public enum TaskStatus {
    CREATED("created"),
    ASSIGNED("assigned"),
    UNASSIGNED("unassigned"),
    PENDING("pending"),
    REVIEW("review"),
    COMPLETED("completed");

    public final String value;
    TaskStatus(String value) {
        this.value = value;
    }
}

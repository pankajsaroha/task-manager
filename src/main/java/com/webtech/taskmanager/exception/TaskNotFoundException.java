package com.webtech.taskmanager.exception;

import com.webtech.taskmanager.model.enums.Errors;

public class TaskNotFoundException extends Exception{

    private Errors errors;

    public TaskNotFoundException(Errors e) {
        super(e.getMessage());
    }

    public TaskNotFoundException(Throwable e) {
        super(e);
    }

    public TaskNotFoundException(Errors errors, Throwable e) {
        super(e);
        this.errors = errors;
    }
}

package com.webtech.taskmanager.model.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum Errors {
    TASK_NOT_FOUND(404, HttpStatus.NOT_FOUND, "Task Not Found");

    @Getter
    private final int code;
    @Getter
    private final HttpStatus httpStatus;
    @Getter
    private final String message;

    Errors(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}

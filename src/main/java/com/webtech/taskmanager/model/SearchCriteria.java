package com.webtech.taskmanager.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchCriteria {
    String key;
    String operation;
    Object value;
}

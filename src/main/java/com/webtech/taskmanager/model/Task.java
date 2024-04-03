package com.webtech.taskmanager.model;

import com.webtech.taskmanager.model.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.File;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String taskName;
    private String description;
    private String createdBy;
    private String assignedTo;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private File attachment;
    private String remark;
    private Date createdDate;
    private Date lastUpdatedDate;
}

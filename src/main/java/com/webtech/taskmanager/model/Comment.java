package com.webtech.taskmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.File;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="comments")
public class Comment {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String comment;
    private File attachment;
    private String createdBy;
    private Date createdDate;
    private Date lastUpdatedDate;
    private boolean updated;
    private int taskId;
}

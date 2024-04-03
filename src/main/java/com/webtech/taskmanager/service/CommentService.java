package com.webtech.taskmanager.service;

import com.webtech.taskmanager.exception.TaskNotFoundException;
import com.webtech.taskmanager.model.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    Comment addComment(Comment comment) throws TaskNotFoundException;
}

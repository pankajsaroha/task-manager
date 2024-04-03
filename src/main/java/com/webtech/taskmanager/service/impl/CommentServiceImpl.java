package com.webtech.taskmanager.service.impl;

import com.webtech.taskmanager.exception.TaskNotFoundException;
import com.webtech.taskmanager.model.Comment;
import com.webtech.taskmanager.model.Task;
import com.webtech.taskmanager.repository.CommentRepository;
import com.webtech.taskmanager.service.CommentService;
import com.webtech.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TaskService taskService;

    @Override
    public Comment addComment(Comment comment) throws TaskNotFoundException {
        Task task = taskService.findById(comment.getTaskId());
        comment.setCreatedDate(new Date());
        comment.setLastUpdatedDate(new Date());
        return commentRepository.save(comment);
    }
}

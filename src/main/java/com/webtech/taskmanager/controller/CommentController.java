package com.webtech.taskmanager.controller;

import com.webtech.taskmanager.exception.TaskNotFoundException;
import com.webtech.taskmanager.model.Comment;
import com.webtech.taskmanager.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webtech/task-manager")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add-comment")
    public ResponseEntity<Comment> addComment (@RequestBody Comment comment) throws TaskNotFoundException {
        return ResponseEntity.ok(commentService.addComment(comment));
    }
}

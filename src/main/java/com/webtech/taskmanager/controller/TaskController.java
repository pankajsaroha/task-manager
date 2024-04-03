package com.webtech.taskmanager.controller;

import com.webtech.taskmanager.exception.TaskNotFoundException;
import com.webtech.taskmanager.model.Task;
import com.webtech.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webtech/task-manager")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add-task")
    public ResponseEntity<Task> addTask (@RequestBody Task task) {
        return ResponseEntity.ok(taskService.addTask(task));
    }

    @GetMapping("/fetch-tasks")
    public ResponseEntity<List<Task>> fetchTasks (@RequestParam(required = false) String createdBy,
                                                  @RequestParam(required = false) String assignedTo) {
        return ResponseEntity.ok(taskService.fetchTasks(createdBy, assignedTo));
    }

    @PatchMapping("/edit-task")
    public ResponseEntity<Task> editTask (@RequestParam int id, @RequestBody Task task) throws TaskNotFoundException {
        return ResponseEntity.ok(taskService.editTask(id, task));
    }

    @PatchMapping("/assign")
    public ResponseEntity<Task> assign (@RequestParam int id, @RequestParam String user) throws TaskNotFoundException {
        return ResponseEntity.ok(taskService.assign(id, user));
    }
}

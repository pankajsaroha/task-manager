package com.webtech.taskmanager.service;

import com.webtech.taskmanager.exception.TaskNotFoundException;
import com.webtech.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    Task addTask(Task task);
    Task findById (int taskId) throws TaskNotFoundException;
    List<Task> fetchTasks(String createdBy, String assignedTo);
    Task editTask (int id, Task task) throws TaskNotFoundException;
    Task assign (int id, String user) throws TaskNotFoundException;
}

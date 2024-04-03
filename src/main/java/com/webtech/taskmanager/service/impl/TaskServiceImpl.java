package com.webtech.taskmanager.service.impl;

import com.webtech.taskmanager.exception.TaskNotFoundException;
import com.webtech.taskmanager.model.Constants;
import com.webtech.taskmanager.model.SearchCriteria;
import com.webtech.taskmanager.model.Task;
import com.webtech.taskmanager.model.enums.Errors;
import com.webtech.taskmanager.model.enums.TaskStatus;
import com.webtech.taskmanager.repository.TaskRepository;
import com.webtech.taskmanager.service.TaskService;
import com.webtech.taskmanager.specification.TaskSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.webtech.taskmanager.model.Constants.*;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task addTask(Task task) {
        task.setCreatedDate(new Date());
        task.setLastUpdatedDate(new Date());
        task.setStatus(TaskStatus.CREATED);
        return taskRepository.save(task);
    }

    @Override
    public Task findById(int taskId) throws TaskNotFoundException {
        Optional<Task> task = taskRepository.findById(taskId);
        if (!task.isPresent()) {
            throw new TaskNotFoundException(Errors.TASK_NOT_FOUND);
        }
        return task.get();
    }

    @Override
    public List<Task> fetchTasks(String createdBy, String assignedTo) {
        List<SearchCriteria> searchCriteria = getSearchCriteria(createdBy, assignedTo);
        TaskSpecification taskSpecification = new TaskSpecification(searchCriteria);

        return taskRepository.findAll(taskSpecification);
    }

    @Override
    public Task editTask(int id, Task task) throws TaskNotFoundException {
        Optional<Task> existingTask = taskRepository.findById(task.getId());
        if(existingTask.isEmpty()) {
            throw new TaskNotFoundException(Errors.TASK_NOT_FOUND);
        }
        Task taskToBeEdited = existingTask.get();
        taskToBeEdited.setTaskName(Optional.ofNullable(task.getTaskName()).orElse(taskToBeEdited.getTaskName()));
        taskToBeEdited.setStatus(Optional.ofNullable(task.getStatus()).orElse(taskToBeEdited.getStatus()));
        taskToBeEdited.setLastUpdatedDate(new Date());
        taskToBeEdited.setDescription(Optional.ofNullable(task.getDescription()).orElse(taskToBeEdited.getDescription()));
        taskToBeEdited.setRemark(Optional.ofNullable(task.getRemark()).orElse(taskToBeEdited.getTaskName()));
        return taskRepository.save(taskToBeEdited);
    }

    @Override
    public Task assign(int id, String user) throws TaskNotFoundException {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isEmpty()) {
            throw new TaskNotFoundException(Errors.TASK_NOT_FOUND);
        }
        Task taskToBeAssigned = existingTask.get();
        taskToBeAssigned.setAssignedTo(user);
        return taskRepository.save(taskToBeAssigned);
    }

    private List<SearchCriteria> getSearchCriteria (String createdBy, String assignedTo) {
        List<SearchCriteria> searchCriteriaList = new ArrayList<>();
        if (createdBy != null) {
            searchCriteriaList.add(SearchCriteria.builder().key(CREATED_BY).operation(EQUALS).value(createdBy).build());
        }
        if (assignedTo != null) {
            searchCriteriaList.add(SearchCriteria.builder().key(ASSIGNED_TO).operation(EQUALS).value(assignedTo).build());
        }
        return searchCriteriaList;
    }
}

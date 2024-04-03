package com.webtech.taskmanager.repository;

import com.webtech.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer>, JpaSpecificationExecutor<Task> {

    @Query("select t from Task t where createdBy = :user")
    List<Task> fetchTasksByUser(@Param("user") String user);
}

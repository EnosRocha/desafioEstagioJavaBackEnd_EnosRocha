package com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.repositories;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.Task;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.objectvalue.TaskPriority;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.objectvalue.TaskStatus;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.jpa.persistence.task.TaskEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Optional<Task> findByName(String name);
    Optional<Task> findById(Long id);
    List<Task> filter(TaskStatus status, TaskPriority priority, LocalDate deadLine);
    Task save(Task task);
    int delete(Long id, String name);
    List<Task> finbByUser(String name);
}

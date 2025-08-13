package com.example.desafioEstagioJavaBackEnd_EnosRocha.application.dto;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.Task;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.objectvalue.TaskPriority;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.objectvalue.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public record CreateNewTask(
        @NotBlank(message = "name cant be blank") @Size(min = 1, max = 100, message = "task name must to be between 1 and 100 characteres") String taskName,
        @NotBlank(message = "description cant be blank") @Size(min = 10, message = "description mus to have at least 10 characteres") String description,
        @NotNull(message = "deadLine cant be null") LocalDate deadLine,
        @NotNull(message = "task status cant be null") TaskStatus status,
        @NotNull(message = "task priority cant be null") TaskPriority priority,
        @Nullable List<@Valid Task> subtasks,
        @NotBlank(message = "responsible user cant be blank") String responsibleUser) {
}

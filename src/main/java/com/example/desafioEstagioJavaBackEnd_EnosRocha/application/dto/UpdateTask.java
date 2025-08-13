package com.example.desafioEstagioJavaBackEnd_EnosRocha.application.dto;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.Task;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.objectvalue.TaskPriority;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.objectvalue.TaskStatus;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;

public record UpdateTask(
        @Nullable LocalDate newDeadLine,
        @Nullable TaskStatus newStatus,
        @Nullable TaskPriority newPriority,
        @Nullable List<@Valid Task> newSubtasks
) {
}

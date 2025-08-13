package com.example.desafioEstagioJavaBackEnd_EnosRocha.application.mappers;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.dto.CreateNewTask;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.dto.UpdateTask;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.Task;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.User;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.objectvalue.TaskPriority;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.objectvalue.TaskStatus;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.jpa.persistence.task.TaskEntity;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.mappers.UserEntityMapper;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Mapper(componentModel = "spring", uses = {UserEntityMapper.class})
public interface TaskMapper {


    @Mapping(target = "user", source = "responsibleUser")
    TaskEntity toEntity(Task task);

    @Mapping(target = "status", expression = "java(updateTask.newStatus() != null ? updateTask.newStatus() : task.getStatus())")
    @Mapping(target = "priority", expression = "java(updateTask.newPriority() != null ? updateTask.newPriority() : task.getPriority())")
    @Mapping(target = "subtasks", expression = "java(updateTask.newSubtasks() != null ? updateTask.newSubtasks() : task.getSubtasks())")
    @Mapping(target = "deadLine", expression = "java(updateTask.newDeadLine() != null ? updateTask.newDeadLine() : task.getDeadLine())")
    Task toDomainUpdate(Task task, UpdateTask updateTask);



    default Task fromCreateNewTaskAndUser(CreateNewTask dto, String user) {
        return new Task(
                null,
                dto.taskName(),
                dto.description(),
                LocalDate.parse(dto.deadLine().toString()),
                TaskStatus.valueOf(dto.status().toString().toUpperCase()),
                TaskPriority.valueOf(dto.priority().toString().toUpperCase()),
                dto.subtasks() != null ? dto.subtasks() : new ArrayList<>(),
                user
        );
    }

}

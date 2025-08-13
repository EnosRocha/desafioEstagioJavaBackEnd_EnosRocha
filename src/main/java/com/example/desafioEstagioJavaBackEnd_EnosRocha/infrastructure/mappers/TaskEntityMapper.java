package com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.mappers;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.Task;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.jpa.persistence.task.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface TaskEntityMapper {

    @Mapping(target = "deadLine", source = "deadLine")
    @Mapping(target = "priority", expression = "java(task.getPriority().name().toUpperCase())")
    @Mapping(target = "status", expression = "java(task.getStatus().name().toUpperCase())")
    @Mapping(target = "name", source = "taskName")
    @Mapping(target = "user", source = "responsibleUser")
    TaskEntity toEntity(Task task);

    @Mapping(target = "deadLine", source = "deadLine")
    @Mapping(target = "priority", expression = "java(TaskPriority.valueOf(entity.getPriority()))")
    @Mapping(target = "status", expression = "java(TaskStatus.valueOf(entity.getStatus()))")
    @Mapping(target = "taskName", source = "name")
    @Mapping(target = "responsibleUser", source = "user")
    Task toDomain(TaskEntity entity);


}

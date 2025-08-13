package com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.jpa.persistence.task;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.Task;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.jpa.persistence.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task_entity")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @NotBlank(message = "name cant be blank")
    @Size(min = 1, max = 100, message = "task name must to be between 1 and 100 characteres")
    private String name;

    @NotBlank(message = "description cant be blank")
    @Size(min = 10, message = "description mus to have at least 10 characteres")
    private String description;

    @NotNull(message = "deadLine cant be null")
    private LocalDate deadLine;

    @NotNull(message = "task status cant be null")
    private String status;

    @NotNull(message = "task priority cant be null")
    private String priority;

    @Nullable
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskEntity> subtasks = new ArrayList();

    @NotBlank(message = "user cant be blank")
    private String user;
}

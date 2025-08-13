package com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.exceptions.DeadLineDomainException;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.exceptions.PriorityNotAllowedException;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.exceptions.StatusNotAllowedException;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.objectvalue.TaskPriority;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.objectvalue.TaskStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task {

    private Long taskId;
    private String taskName;
    private String description;
    private LocalDate deadLine;
    private TaskStatus status;
    private TaskPriority priority;
    private List<Task> subtasks = new ArrayList();
    private String responsibleUser;

    public Task(Long taskId, String taskName, String description, LocalDate deadLine, TaskStatus status, TaskPriority priority, List<Task> subtasks, String responsibleUser) {
        if (taskId != null && taskId < 0) {
            throw new IllegalArgumentException("id cant be negative");
        }
        if (taskName == null || taskName.isEmpty()) {
            throw new IllegalArgumentException("taskName cant be null or empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("description cant be null or empty");
        }
        if (deadLine == null || deadLine.isBefore(LocalDate.now())) {
            throw new DeadLineDomainException("deadLine cant be null or before the current date");
        }
        if (status == null) {
            throw new StatusNotAllowedException("status cant be null or empty");
        }
        if (priority == null) {
            throw new PriorityNotAllowedException("priority cant be null or empty");
        }
        this.taskId = taskId;
        this.taskName = taskName;
        this.description = description;
        this.deadLine = deadLine;
        this.status = status;
        this.priority = priority;
        this.subtasks = subtasks;
        this.responsibleUser = responsibleUser;
    }

    public static boolean isTaskUpdatebleToCompleted(Task task) {
        if (task.getSubtasks() == null ||task.getSubtasks().isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public Long getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public List<Task> getSubtasks() {
        return subtasks;
    }

    public String getResponsibleUser() {
        return responsibleUser;
    }
}

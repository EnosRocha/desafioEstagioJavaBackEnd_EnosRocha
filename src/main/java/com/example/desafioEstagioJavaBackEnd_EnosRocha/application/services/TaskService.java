package com.example.desafioEstagioJavaBackEnd_EnosRocha.application.services;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.dto.CreateNewTask;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.dto.UpdateTask;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.exceptions.TaskAlreadyExistException;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.exceptions.TaskCantBeCompletedException;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.exceptions.TaskNotFoundException;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.exceptions.UserNotFoundException;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.mappers.TaskMapper;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.Task;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.User;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.objectvalue.TaskPriority;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.objectvalue.TaskStatus;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.repositories.TaskRepository;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.repositories.UserRepository;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.jpa.persistence.task.TaskEntity;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.mappers.TaskEntityMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.Task.isTaskUpdatebleToCompleted;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;
    private final TaskEntityMapper taskEntityMapper;


    public TaskService(TaskRepository taskRepository, UserRepository userRepository, TaskMapper taskMapper, TaskEntityMapper taskEntityMapper) {

        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.taskMapper = taskMapper;
        this.taskEntityMapper = taskEntityMapper;
    }

    @Transactional
    public Task createNewTaskService(CreateNewTask createNewTask) {

        User user = userRepository.findByName(createNewTask.responsibleUser())
                .orElseThrow(() -> new UserNotFoundException("user not found in databse"));

        Task task = taskMapper.fromCreateNewTaskAndUser(createNewTask, user.getName());

        System.out.println(task.getResponsibleUser());
        System.out.println(task.getResponsibleUser());
        System.out.println(task.getResponsibleUser());
        System.out.println(task.getResponsibleUser());

        Optional<Task> foundTask = taskRepository.findByName(task.getTaskName());
        if (foundTask.isPresent()) {
            throw new TaskAlreadyExistException("A task with this name already existis, check out the task list");
        }

        return taskRepository.save(task);

    }

    @Transactional
    public List<Task> getTasksService(String status, String priority, LocalDate deadLine) {
        TaskStatus taskStatus = null;
        TaskPriority taskPriority = null;
        LocalDate taskDeadLine = null;

        if (status != null) {
            taskStatus = TaskStatus.valueOf(status.toUpperCase());
        }
        if (priority != null) {
            taskPriority = TaskPriority.valueOf(priority.toUpperCase());
        }
        if (deadLine != null) {
            taskDeadLine = deadLine;
        }

        List<Task> tasksServiceResponse = taskRepository.filter(taskStatus, taskPriority, taskDeadLine);
        return tasksServiceResponse;
    }

    @Transactional
    public Task updateTask(Long id, UpdateTask updateTask) {
        Optional<Task> task = taskRepository.findById(id);
        if (!task.isPresent()) {
            throw new TaskNotFoundException("task not found in database");
        }

        System.out.println(isTaskUpdatebleToCompleted(task.get()));
        System.out.println(isTaskUpdatebleToCompleted(task.get()));
        System.out.println(isTaskUpdatebleToCompleted(task.get()));

        if (!isTaskUpdatebleToCompleted(task.get()) && updateTask.newStatus() != null && updateTask.newStatus() == TaskStatus.COMPLETED) {
            throw new TaskCantBeCompletedException("there are still subtasks remaining to be completed");
        }
        Task taskToSave = taskMapper.toDomainUpdate(task.get(), updateTask);
        return taskRepository.save(taskToSave);
    }

    @Transactional
    public boolean deleteTaskByIdOrName(Long id, String name) {
        int deleteResponse = taskRepository.delete(id, name);
        return deleteResponse > 0 ? true : false;
    }
}

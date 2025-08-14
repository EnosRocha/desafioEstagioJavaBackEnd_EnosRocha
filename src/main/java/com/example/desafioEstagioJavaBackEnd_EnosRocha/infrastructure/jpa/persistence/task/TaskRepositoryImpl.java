package com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.jpa.persistence.task;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.Task;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.objectvalue.TaskPriority;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.objectvalue.TaskStatus;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.repositories.TaskRepository;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.mappers.TaskEntityMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final TaskJpaRepository taskRepository;
    private final TaskEntityMapper taskEntityMapper;

    public TaskRepositoryImpl(TaskJpaRepository taskRepository, TaskEntityMapper taskEntityMapper) {
        this.taskRepository = taskRepository;
        this.taskEntityMapper = taskEntityMapper;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id).map(taskEntityMapper::toDomain);
    }

    @Override
    public List<Task> filter(TaskStatus status, TaskPriority priority, LocalDate deadLine) {
        String statusSring = status != null ? status.name() : null;
        String priorityString = priority != null ? priority.name() : null;
        LocalDate deadLineString = deadLine != null ? deadLine : null;
        return taskRepository.filter(statusSring, priorityString, deadLineString).stream().map(taskEntityMapper::toDomain).toList();
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = taskEntityMapper.toEntity(task);
        TaskEntity savedEntity = taskRepository.save(taskEntity);
        return taskEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Task> findByName(String name) {
        return taskRepository.findByName(name).map(taskEntityMapper::toDomain);
    }

    @Override
    public int delete(Long id, String name) {
        if (id != null || name != null) {
            return taskRepository.delete(id, name);
        }
        return 0;
    }

    @Override
    public List<Task> finbByUser(String name) {
        return taskRepository.findByUser(name).stream().map(taskEntityMapper::toDomain).toList();
    }
}

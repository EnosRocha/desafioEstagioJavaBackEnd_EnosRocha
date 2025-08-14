package com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.jpa.persistence.task;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TaskJpaRepository extends JpaRepository<TaskEntity, Long> {
    Optional<TaskEntity> findById(Long id);


    Optional<TaskEntity> findByName(String name);




    List<TaskEntity> findByUser(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("""
                DELETE FROM TaskEntity t WHERE (:id IS NULL OR t.taskId = :id) AND (:name IS NULL OR t.name = :name)
            """)
    int delete(@Param("id") Long id, @Param("name") String name);

    @Query("""
            SELECT t FROM TaskEntity t WHERE (:status IS NULL OR t.status = :status)
                        AND(:priority IS NULL OR t.priority = :priority)
                        AND(:deadLine IS NULL OR t.deadLine = :deadLine)""")
    List<TaskEntity> filter(@Param("status") String status, @Param("priority") String priority, @Param("deadLine") LocalDate deadLine);
}

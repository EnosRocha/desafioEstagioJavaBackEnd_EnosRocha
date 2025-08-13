package com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.jpa.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByName(String name);
    UserEntity save(UserEntity user);
}

package com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.repositories;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByName(String name);

    User save(User user);
}

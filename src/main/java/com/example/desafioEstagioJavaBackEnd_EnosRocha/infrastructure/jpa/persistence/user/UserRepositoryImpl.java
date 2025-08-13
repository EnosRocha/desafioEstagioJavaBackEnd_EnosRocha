package com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.jpa.persistence.user;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.User;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.repositories.UserRepository;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.mappers.UserEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository, UserEntityMapper userEntityMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public Optional<User> findByName(String name) {
        return userJpaRepository.findByName(name).map(userEntityMapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        userJpaRepository.save(userEntity);
        return user;
    }
}

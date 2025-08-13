package com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.mappers;


import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.User;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.jpa.persistence.user.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {


    UserEntity toEntity(User user);

    User toDomain(UserEntity user);
}

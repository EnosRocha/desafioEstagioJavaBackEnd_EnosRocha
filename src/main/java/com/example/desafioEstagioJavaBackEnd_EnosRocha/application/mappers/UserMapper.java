package com.example.desafioEstagioJavaBackEnd_EnosRocha.application.mappers;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.dto.CreateNewUser;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "password", source = "encodedPassword")
    User toDomain(CreateNewUser createNewUser, String encodedPassword);
}

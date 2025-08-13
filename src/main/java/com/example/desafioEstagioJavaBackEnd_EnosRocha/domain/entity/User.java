package com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.exceptions.UserSignUpNotAllowedException;

public class User {

    private String name;
    private String password;

    public User(String name, String password) {
        if(name == null || name.isEmpty()){
            throw new UserSignUpNotAllowedException("name cant be null or empty");
        }
        if(password == null || password.isEmpty()){
            throw new UserSignUpNotAllowedException("password cant be null or empty");
        }
        this.name = name;
        this.password = password;
    }

    public String getName() {

        return name;
    }

    public String getPassword() {
        return password;
    }
}

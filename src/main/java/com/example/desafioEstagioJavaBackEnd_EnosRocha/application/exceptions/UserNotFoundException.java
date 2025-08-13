package com.example.desafioEstagioJavaBackEnd_EnosRocha.application.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}

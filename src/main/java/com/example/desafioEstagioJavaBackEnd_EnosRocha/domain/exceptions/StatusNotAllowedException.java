package com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.exceptions;

public class StatusNotAllowedException extends RuntimeException {
    public StatusNotAllowedException(String message) {
        super(message);
    }
}

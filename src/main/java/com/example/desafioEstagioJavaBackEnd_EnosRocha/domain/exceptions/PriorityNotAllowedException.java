package com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.exceptions;

public class PriorityNotAllowedException extends RuntimeException {
    public PriorityNotAllowedException(String message) {
        super(message);
    }
}

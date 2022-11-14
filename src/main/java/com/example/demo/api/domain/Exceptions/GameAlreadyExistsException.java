package com.example.demo.api.domain.Exceptions;

public class GameAlreadyExistsException extends Exception {
    public GameAlreadyExistsException(String message) {
        super(message);
    }
}

package com.radekwt.AuthApp.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String message) {
        super("Username already exists: " + message);
    }
}

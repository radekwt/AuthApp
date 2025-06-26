package com.radekwt.AuthApp.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String message) {
        super("Email already exists: "+ message);
    }
}

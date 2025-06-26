package com.radekwt.AuthApp.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<ErrorObject> handleUsernameAlreadyExists(UsernameAlreadyExistsException ex){
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        ErrorObject error = new ErrorObject(
                httpStatus.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error,httpStatus);
    }
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorObject> handleEmailAlreadyExists(EmailAlreadyExistsException ex){
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        ErrorObject error = new ErrorObject(
                httpStatus.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error,httpStatus);
    }
}

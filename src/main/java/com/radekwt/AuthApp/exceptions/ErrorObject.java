package com.radekwt.AuthApp.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class ErrorObject {
    private Integer statusCode;
    private String message;
    private LocalDateTime timestamp;
}

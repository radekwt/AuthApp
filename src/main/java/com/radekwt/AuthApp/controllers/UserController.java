package com.radekwt.AuthApp.controllers;

import com.radekwt.AuthApp.dtos.RegisterRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {
    @GetMapping("/{id}")
    public RegisterRequest getUser(){
        return new RegisterRequest();
    }
}

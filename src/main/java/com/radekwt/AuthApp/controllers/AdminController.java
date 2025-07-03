package com.radekwt.AuthApp.controllers;

import com.radekwt.AuthApp.dtos.RegisterRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/admin")
public class AdminController {
    @GetMapping("/user/{id}")
    public RegisterRequest showUser(){
        return new RegisterRequest();
    }
    @GetMapping("/users")
    public Page<RegisterRequest> showAllUsers(){
        Page<RegisterRequest> users = null;
        return users;
    }
}

package com.radekwt.AuthApp.controllers;

import com.radekwt.AuthApp.entities.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/auth")
public class AuthController {
    @PostMapping("/register")
    public User registerUser(){
        return new User();
    }
    @PostMapping("/login")
    public User loginUser(){
        return new User();
    }
    @PostMapping("/logout")
    public User logoutUser(){
        return new User();
    }

}

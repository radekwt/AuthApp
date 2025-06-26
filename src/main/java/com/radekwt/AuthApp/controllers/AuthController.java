package com.radekwt.AuthApp.controllers;

import com.radekwt.AuthApp.dtos.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/auth")
public class AuthController {
    @PostMapping("/register")
    public UserDto registerUser(){
        return new UserDto();
    }
    @PostMapping("/login")
    public UserDto loginUser(){
        return new UserDto();
    }
    @PostMapping("/logout")
    public UserDto logoutUser(){
        return new UserDto();
    }

}

package com.radekwt.AuthApp.controllers;

import com.radekwt.AuthApp.dtos.UserDto;
import com.radekwt.AuthApp.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {
    @GetMapping("/{id}")
    public UserDto getUser(){
        return new UserDto();
    }
}

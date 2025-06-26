package com.radekwt.AuthApp.controllers;

import com.radekwt.AuthApp.dtos.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/admin")
public class AdminController {
    @GetMapping("/user/{id}")
    public UserDto showUser(){
        return new UserDto();
    }
    @GetMapping("/users")
    public Page<UserDto> showAllUsers(){
        Page<UserDto> users = null;
        return users;
    }
}

package com.radekwt.AuthApp.controllers;

import com.radekwt.AuthApp.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/admin")
public class AdminController {
    @GetMapping("/user/{id}")
    public User showUser(){
        return new User();
    }
    @GetMapping("/users")
    public Page<User> showAllUsers(){
        Page<User> users = null;
        return users;
    }
}

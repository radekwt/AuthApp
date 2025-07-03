package com.radekwt.AuthApp.services.impl;

import com.radekwt.AuthApp.dtos.LoginRequest;
import com.radekwt.AuthApp.dtos.RegisterRequest;
import com.radekwt.AuthApp.dtos.UserDto;
import com.radekwt.AuthApp.exceptions.EmailAlreadyExistsException;
import com.radekwt.AuthApp.exceptions.UsernameAlreadyExistsException;
import com.radekwt.AuthApp.mappers.UserMapper;
import com.radekwt.AuthApp.services.AuthService;
import com.radekwt.AuthApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserMapper userMapper;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserMapper userMapper,UserService userService,PasswordEncoder passwordEncoder){
        this.userMapper = userMapper;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserDto registerUser(RegisterRequest request) {
        if(userService.isUsernameExists(request.getUsername())){
            throw new UsernameAlreadyExistsException(request.getUsername());
        }
        if(userService.isEmailExists(request.getEmail())){
            throw new EmailAlreadyExistsException(request.getEmail());
        }
        UserDto userDto = userMapper.toDto(request);
        userDto.setPassword(passwordEncoder.encode(request.getPassword()));

        return userService.createUser(userDto);
    }

    @Override
    public UserDto loginUser(LoginRequest request) {
        return null;
    }

}

package com.radekwt.AuthApp.services.impl;

import com.radekwt.AuthApp.dtos.UserDto;
import com.radekwt.AuthApp.entities.User;
import com.radekwt.AuthApp.exceptions.EmailAlreadyExistsException;
import com.radekwt.AuthApp.exceptions.UsernameAlreadyExistsException;
import com.radekwt.AuthApp.mappers.UserMapper;
import com.radekwt.AuthApp.repositories.UserRepository;
import com.radekwt.AuthApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public UserDto createUser(UserDto userDto) {
        if(userRepository.findByUsername(userDto.getUsername()).isPresent()){
            throw new UsernameAlreadyExistsException(userDto.getUsername());
        }
        if(userRepository.findByEmail(userDto.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException(userDto.getEmail());
        }
        User user = userRepository.save(userMapper.toEntity(userDto));
        return userMapper.toDto(user);
    }

    @Override
    public UserDto deleteUser() {
        return null;
    }

    @Override
    public UserDto updateUser() {
        return null;
    }

    @Override
    public UserDto getUser() {
        return null;
    }
}

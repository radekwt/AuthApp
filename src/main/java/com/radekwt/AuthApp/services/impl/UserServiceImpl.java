package com.radekwt.AuthApp.services.impl;

import com.radekwt.AuthApp.dtos.UserDto;
import com.radekwt.AuthApp.entities.User;
import com.radekwt.AuthApp.mappers.UserMapper;
import com.radekwt.AuthApp.repositories.UserRepository;
import com.radekwt.AuthApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userRepository.save(userMapper.toEntity(userDto));
        return userMapper.toDto(user);
    }

    @Override
    public UserDto deleteUser(Long UserId)
    {
        User user = userRepository.findById(UserId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + UserId));
        userRepository.delete(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {// update by email,doesnt check if username already exists
        User user = userRepository.findByEmail(userDto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userDto.getUsername()));
        userMapper.updateEntityFromDto(userDto, user);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        return null;
    }
    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return null;
    }
    @Override
    public UserDto getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
        return null;
    }

    @Override
    public boolean isEmailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public boolean isUsernameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}

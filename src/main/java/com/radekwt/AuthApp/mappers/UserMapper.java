package com.radekwt.AuthApp.mappers;

import com.radekwt.AuthApp.dtos.LoginRequest;
import com.radekwt.AuthApp.dtos.RegisterRequest;
import com.radekwt.AuthApp.dtos.UserDto;
import com.radekwt.AuthApp.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User toEntity(RegisterRequest registerRequest);
    User toEntity(UserDto userDto);
    User toEntity(LoginRequest loginRequest);

    UserDto toDto(User user);
    UserDto toDto(RegisterRequest registerRequest);
    UserDto toDto(LoginRequest loginRequest);

    RegisterRequest toRegisterRequest(User user);
    LoginRequest toLoginRequest(User user);

    void updateEntityFromDto(UserDto userDto, @MappingTarget User user);
}

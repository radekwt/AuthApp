package com.radekwt.AuthApp.mappers;

import com.radekwt.AuthApp.dtos.UserDto;
import com.radekwt.AuthApp.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
    void updateUserFromDto(UserDto userDto, @MappingTarget User user);
}

package io.kimleang.springmvc.dto.mapper;

import io.kimleang.springmvc.dto.model.UserDto;
import io.kimleang.springmvc.model.auth.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}

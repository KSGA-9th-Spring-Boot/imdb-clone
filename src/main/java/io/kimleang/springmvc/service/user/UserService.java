package io.kimleang.springmvc.service.user;

import io.kimleang.springmvc.dto.model.UserDto;
import io.kimleang.springmvc.exception.IdNotFoundException;

public interface UserService {
    UserDto findUserById(Integer id) throws IdNotFoundException;
}

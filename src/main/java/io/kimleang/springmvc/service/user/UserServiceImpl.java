package io.kimleang.springmvc.service.user;

import io.kimleang.springmvc.dto.mapper.UserMapper;
import io.kimleang.springmvc.dto.model.UserDto;
import io.kimleang.springmvc.exception.IdNotFoundException;
import io.kimleang.springmvc.model.auth.User;
import io.kimleang.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto findUserById(Integer id) throws IdNotFoundException {
        User user = userRepository.findUserById(id)
                .orElseThrow(() -> new IdNotFoundException(""));
        return userMapper.userToUserDto(user);
    }

}

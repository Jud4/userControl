package com.edae.users.userControl.services.implement;

import com.edae.users.userControl.dto.UserDTO;
import com.edae.users.userControl.repositories.UserRepository;
import com.edae.users.userControl.services.UserService;
import com.edae.users.userControl.services.mapper.UserDetailMapper;
import com.edae.users.userControl.services.mapper.UserMapper;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public List<UserDTO> listDetailUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDetailedDTO).toList();
    }
}

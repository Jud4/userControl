package com.edae.users.userControl.services.mapper;

import com.edae.users.userControl.domain.entities.User;
import com.edae.users.userControl.dto.UserDTO;
import com.edae.users.userControl.dto.UserDetailDTO;

import java.time.LocalDateTime;

public class UserMapper implements CustomMapper<UserDTO, User>{

    private final UserDetailMapper userDetailMapper;

    public UserMapper(UserDetailMapper userDetailMapper) {
        this.userDetailMapper = userDetailMapper;
    }

    @Override
    public UserDTO toDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        return dto;
    }

    @Override
    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }

    public UserDTO toDetailedDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setDetails(userDetailMapper.toDto(user.getUserDetail()));
        return dto;
    }
}

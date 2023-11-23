package com.edae.users.userControl.services.mapper;

import com.edae.users.userControl.domain.entities.User;
import com.edae.users.userControl.dto.CreateUserDTO;
import com.edae.users.userControl.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
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

    public CreateUserDTO toCreatedDTO(User user){
        CreateUserDTO dto = new CreateUserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        return dto;
    }

    public User toEntity(CreateUserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }
    public UserDTO toDetailedDTO(User user){
        var dto = this.toDto(user);
        if(user.getUserDetail()!=null){
            dto.setDetails(userDetailMapper.toDto(user.getUserDetail()));
        }
        return dto;
    }
    public User toDetailedEntity(UserDTO dto){
        User user = toEntity(dto);
        if(dto.getDetails()!=null){
            user.setUserDetail(userDetailMapper.toEntity(dto.getDetails()));
        }
        return user;
    }
}

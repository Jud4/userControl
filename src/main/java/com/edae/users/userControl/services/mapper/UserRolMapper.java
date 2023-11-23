package com.edae.users.userControl.services.mapper;

import com.edae.users.userControl.domain.entities.User;
import com.edae.users.userControl.domain.entities.UserRol;
import com.edae.users.userControl.dto.UserRolDTO;
import org.springframework.stereotype.Component;

@Component
public class UserRolMapper implements CustomMapper<UserRolDTO, UserRol>{
    private final RolMapper rolMapper;

    public UserRolMapper(RolMapper rolMapper) {
        this.rolMapper = rolMapper;
    }

    @Override
    public UserRolDTO toDto(UserRol userRol) {
        UserRolDTO dto = new UserRolDTO();
        dto.setRol(rolMapper.toDto(userRol.getRol()));
        dto.setId(userRol.getId());
        dto.setActive(userRol.getActive());
        return dto;
    }

    @Override
    public UserRol toEntity(UserRolDTO dto) {
        UserRol userRol = new UserRol();
        userRol.setRol(rolMapper.toEntity(dto.getRol()));
        userRol.setId(dto.getId());
        userRol.setActive(dto.getActive());
        return userRol;
    }

    public UserRol toEntity(UserRolDTO dto, User user){
        UserRol userRol = this.toEntity(dto);
        userRol.setUser(user);
        return userRol;
    }
}

package com.edae.users.userControl.services;

import com.edae.users.userControl.dto.UserRolDTO;

import java.util.List;

public interface UserRolService {
    List<UserRolDTO> save(List<UserRolDTO> dtos,Long userId);
    UserRolDTO deactivate(Long userId,Integer id);
}

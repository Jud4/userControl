package com.edae.users.userControl.services;

import com.edae.users.userControl.dto.CreateUserDTO;
import com.edae.users.userControl.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> listUsers();
    List<UserDTO> listDetailUsers();
    CreateUserDTO save(CreateUserDTO dto);
    UserDTO saveDetailed(UserDTO dto);
    void deleteUser(Long id);
}

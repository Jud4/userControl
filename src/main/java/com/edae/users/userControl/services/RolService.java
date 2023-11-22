package com.edae.users.userControl.services;

import com.edae.users.userControl.dto.RolDTO;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<RolDTO> listRoles();
    Optional<RolDTO> getRolById(Integer rolId);
    RolDTO save(RolDTO dto);
    void delete(Integer rolId);
}

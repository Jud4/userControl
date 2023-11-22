package com.edae.users.userControl.services;

import com.edae.users.userControl.dto.UserDetailDTO;

public interface UserDetailService {
    UserDetailDTO getUserDetailById(Long id);
}

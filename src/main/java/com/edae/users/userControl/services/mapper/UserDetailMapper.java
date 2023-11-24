package com.edae.users.userControl.services.mapper;

import com.edae.users.userControl.domain.entities.UserDetail;
import com.edae.users.userControl.dto.UserDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDetailMapper implements CustomMapper<UserDetailDTO, UserDetail>{
    @Override
    public UserDetailDTO toDto(UserDetail userDetail) {
        UserDetailDTO dto = new UserDetailDTO();
        dto.setAge(userDetail.getAge());
        dto.setBirthDay(userDetail.getBirthDay());
        dto.setFirstName(userDetail.getFirstName());
        dto.setLastName(userDetail.getLastName());
        return dto;
    }

    @Override
    public UserDetail toEntity(UserDetailDTO dto) {
        UserDetail userDetail = new UserDetail();
        userDetail.setAge(dto.getAge());
        userDetail.setBirthDay(dto.getBirthDay());
        userDetail.setFirstName(dto.getFirstName());
        userDetail.setLastName(dto.getLastName());
        return userDetail;
    }
}

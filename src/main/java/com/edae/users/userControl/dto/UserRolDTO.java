package com.edae.users.userControl.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRolDTO {
    private Integer id;
    private Boolean active;
    private RolDTO rol;

    public UserRolDTO() {
    }
}

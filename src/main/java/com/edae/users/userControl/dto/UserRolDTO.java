package com.edae.users.userControl.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRolDTO {
    private Integer id;
    @NotNull(message = "Active state is mandatory")
    private Boolean active;
    private RolDTO rol;

    public UserRolDTO() {
    }
}

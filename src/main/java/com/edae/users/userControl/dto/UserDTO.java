package com.edae.users.userControl.dto;

public class UserDTO extends CreateUserDTO{
    private UserDetailDTO details;
    public UserDTO() {
    }

    public UserDTO(Long id, String username, String password, String email, UserDetailDTO details) {
        super(id, username, password, email);
        this.details = details;
    }

    public UserDetailDTO getDetails() {
        return details;
    }

    public void setDetails(UserDetailDTO details) {
        this.details = details;
    }
}

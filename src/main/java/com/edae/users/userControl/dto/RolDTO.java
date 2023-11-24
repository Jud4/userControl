package com.edae.users.userControl.dto;


import jakarta.validation.constraints.NotBlank;

public class RolDTO {
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;

    public RolDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

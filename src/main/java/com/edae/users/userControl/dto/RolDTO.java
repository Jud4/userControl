package com.edae.users.userControl.dto;

import java.io.Serializable;

public class RolDTO implements Serializable {
    private static final long serialVersionUID = 786546548674712000L;
    private Integer id;
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

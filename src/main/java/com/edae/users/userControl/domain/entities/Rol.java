package com.edae.users.userControl.domain.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {
    private static final long serialVersionUID = 786546548674712000L;
    @Id
    @SequenceGenerator(name = "rol_seq",sequenceName = "rol_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "rol_seq")
    private Integer id;
    private String name;

    public Rol() {
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

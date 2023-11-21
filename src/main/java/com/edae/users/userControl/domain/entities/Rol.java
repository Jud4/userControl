package com.edae.users.userControl.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @SequenceGenerator(name = "rol_seq",sequenceName = "rol_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "rol_seq")
    private Integer id;
    private String name;
}

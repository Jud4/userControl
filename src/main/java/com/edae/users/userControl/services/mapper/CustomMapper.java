package com.edae.users.userControl.services.mapper;

public interface CustomMapper <DTO,E>{
    DTO toDto(E entity);
    E toEntity(DTO dto);
}

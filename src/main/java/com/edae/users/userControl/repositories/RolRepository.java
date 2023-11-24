package com.edae.users.userControl.repositories;

import com.edae.users.userControl.domain.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol,Integer> {
}

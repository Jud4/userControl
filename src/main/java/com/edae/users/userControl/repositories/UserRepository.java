package com.edae.users.userControl.repositories;

import com.edae.users.userControl.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

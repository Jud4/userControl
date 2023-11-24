package com.edae.users.userControl.repositories;

import com.edae.users.userControl.domain.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserDetailRepository extends JpaRepository<UserDetail,Long> {
    @Query("SELECT ud FROM UserDetail ud WHERE ud.user.id = ?1")
    UserDetail findByUserId(Long id);
}

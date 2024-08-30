package com.scalops.Scallops.repo;/*  gaajiCode
    99
    30/08/2024
    */

import com.scalops.Scallops.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

}

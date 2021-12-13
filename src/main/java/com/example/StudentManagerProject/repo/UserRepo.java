package com.example.StudentManagerProject.repo;

import com.example.StudentManagerProject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}

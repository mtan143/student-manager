package com.example.StudentManagerProject.repo;

import com.example.StudentManagerProject.entity.TeacherEntity;
import com.example.StudentManagerProject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<TeacherEntity, Integer> {

    TeacherEntity findByUsername(String username);
    TeacherEntity findByEmail(String email);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}

package com.example.StudentManagerProject.repo;

import com.example.StudentManagerProject.entity.ScoreBoardEntity;
import com.example.StudentManagerProject.entity.StudentEntity;
import com.example.StudentManagerProject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {
    StudentEntity findByUsername(String username);
    StudentEntity findByEmail(String email);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}

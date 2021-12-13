package com.example.StudentManagerProject.repo;

import com.example.StudentManagerProject.entity.SemesterScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterScoreRepo extends JpaRepository<SemesterScoreEntity, Integer> {
}

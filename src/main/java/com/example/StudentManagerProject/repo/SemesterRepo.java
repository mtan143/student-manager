package com.example.StudentManagerProject.repo;

import com.example.StudentManagerProject.entity.SemesterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepo extends JpaRepository<SemesterEntity, Integer> {
}

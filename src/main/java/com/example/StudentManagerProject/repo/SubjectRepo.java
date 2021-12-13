package com.example.StudentManagerProject.repo;

import com.example.StudentManagerProject.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<SubjectEntity, Integer> {
}

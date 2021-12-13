package com.example.StudentManagerProject.repo;

import com.example.StudentManagerProject.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepo extends JpaRepository<ClassEntity, Integer>{

    @Query("select c from ClassEntity c where c.year=?1")
    ClassEntity findClassEntityByYear(Integer year);
}

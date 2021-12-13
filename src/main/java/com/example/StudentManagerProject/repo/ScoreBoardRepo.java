package com.example.StudentManagerProject.repo;

import com.example.StudentManagerProject.entity.ScoreBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreBoardRepo extends JpaRepository<ScoreBoardEntity, Integer> {

}

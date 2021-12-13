package com.example.StudentManagerProject.service;

import com.example.StudentManagerProject.entity.Role;
import com.example.StudentManagerProject.entity.Status;
import com.example.StudentManagerProject.entity.StudentEntity;
import com.example.StudentManagerProject.entity.TeacherEntity;
import com.example.StudentManagerProject.error.StudentError;
import com.example.StudentManagerProject.error.TeacherError;
import com.example.StudentManagerProject.exception.BusinessException;
import com.example.StudentManagerProject.repo.TeacherRepo;
import com.example.StudentManagerProject.validate.TeacherValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;


    /**
     * Create new teacher
     * @param teacher
     * @return
     */
    public ResponseEntity create(TeacherEntity teacher){

        TeacherValidator.validate(teacher);

        teacher.setStatus(Status.ACTIVE);
        teacher.setRoles(Role.TEACHER);

        return ResponseEntity.ok(teacherRepo.save(teacher));
    }

    /**
     * Get all teacher from db
     * @return
     */
    public ResponseEntity getAllTeachers(){

        if (teacherRepo.findAll().isEmpty()) throw new BusinessException(TeacherError.LIST_EMPTY);

        return ResponseEntity.ok(teacherRepo.findAll());
    }

    /**
     * Get teacher by id
     * @param id
     * @return
     */
    public ResponseEntity getTeacher(Integer id){

        if (!teacherRepo.existsById(id))
            throw new BusinessException(TeacherError.TEACHER_ID);

        return new ResponseEntity<>(teacherRepo.findById(id).get(), HttpStatus.OK);
    }

    /**
     * Update a teacher
     * @param id
     * @param teacher
     * @return
     */
    public ResponseEntity updateTeacher(Integer id, TeacherEntity teacher) {

        if (Objects.isNull(id)) throw new BusinessException(TeacherError.TEACHER_ID);

        TeacherEntity teacherEntity = teacherRepo.findById(id).get();
        if (Objects.isNull(teacherEntity)) throw new BusinessException(TeacherError.TEACHER_ID);

        teacherEntity.setFirstName(teacher.getFirstName());
        teacherEntity.setLastName(teacher.getLastName());
        teacherEntity.setUsername(teacher.getUsername());
        teacherEntity.setEmail(teacher.getEmail());
        teacherEntity.setPassword(teacher.getPassword());
        teacherEntity.setStatus(teacher.getStatus());
        teacherEntity.setDateOfBirth(teacher.getDateOfBirth());
        teacherEntity.setAddress(teacher.getAddress());
        teacherEntity.setPhoneNumber(teacher.getPhoneNumber());
        teacherEntity.setGender(teacher.getGender());
        teacherEntity.setIdCard(teacher.getIdCard());
        teacherEntity.setClassId(teacher.getClassId());
        teacherEntity.setSalary(teacher.getSalary());
        teacherEntity.setSubjectId(teacher.getSubjectId());

        return new ResponseEntity<>(teacherRepo.save(teacherEntity), HttpStatus.OK);
    }

    /**
     * Delete by id
     * @param id
     * @return
     */
    public ResponseEntity delete(Integer id) {

        if (Objects.isNull(id)) throw new BusinessException(TeacherError.TEACHER_ID);

        TeacherEntity teacherEntity = teacherRepo.findById(id).get();
        teacherEntity.setStatus(Status.INACTIVE);
        teacherRepo.save(teacherEntity);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}

package com.example.StudentManagerProject.service;

import com.example.StudentManagerProject.entity.Role;
import com.example.StudentManagerProject.entity.Status;
import com.example.StudentManagerProject.entity.StudentEntity;
import com.example.StudentManagerProject.error.StudentError;
import com.example.StudentManagerProject.exception.BusinessException;
import com.example.StudentManagerProject.repo.ScoreBoardRepo;
import com.example.StudentManagerProject.repo.StudentRepo;
import com.example.StudentManagerProject.validate.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    ScoreBoardRepo scoreBoardRepo;

    /**
     * Create new student
     * @param student
     * @return
     */
    public ResponseEntity create(StudentEntity student){

        StudentValidator.validate(student);

        student.setStatus(Status.ACTIVE);
        student.setRoles(Role.STUDENT);

        return ResponseEntity.ok(studentRepo.save(student));
    }

    /**
     * Get all student from db
     * @return
     */
    public ResponseEntity getAllStudents(){

        if (studentRepo.findAll().isEmpty()) throw new BusinessException(StudentError.LIST_EMPTY);

        return ResponseEntity.ok(studentRepo.findAll());
    }


    /**
     * Get student by id
     * @param id
     * @return
     */
    public ResponseEntity getStudent(Integer id){

        if (!studentRepo.existsById(id))
            throw new BusinessException(StudentError.STUDENT_ID);

        return ResponseEntity.ok(studentRepo.findById(id).get());
    }


    /**
     * Update a student
     * @param id
     * @param student
     * @return
     */
    public ResponseEntity updateStudent(Integer id, StudentEntity student) {

        if (Objects.isNull(id)) throw new BusinessException(StudentError.STUDENT_ID);

        StudentEntity studentEntity = studentRepo.findById(id).get();
        if (Objects.isNull(studentEntity)) throw new BusinessException(StudentError.STUDENT_ID);

        studentEntity.setLastName(student.getLastName());
        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setUsername(student.getUsername());
        studentEntity.setEmail(student.getEmail());
        studentEntity.setPassword(student.getPassword());
        studentEntity.setStatus(student.getStatus());
        studentEntity.setDateOfBirth(student.getDateOfBirth());
        studentEntity.setAddress(student.getAddress());
        studentEntity.setPhoneNumber(student.getPhoneNumber());
        studentEntity.setGender(student.getGender());
        studentEntity.setClassId(student.getClassId());
        studentEntity.setFees(student.getFees());
        studentEntity.setScoreBoardId(student.getScoreBoardId());

        return ResponseEntity.ok(studentRepo.save(studentEntity));
    }


    /**
     * Delete by id
     * @param id
     * @return
     */
    public ResponseEntity deleteById(Integer id) {

        if (Objects.isNull(id)) throw new BusinessException(StudentError.STUDENT_ID);

        StudentEntity studentEntity = studentRepo.findById(id).get();
        studentEntity.setStatus(Status.INACTIVE);
        studentRepo.save(studentEntity);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Get fee of student by id
     * @param studentId
     * @return
     */
    public ResponseEntity getFees(Integer studentId) {

        if (Objects.isNull(studentId)) throw new BusinessException(StudentError.STUDENT_ID);

        StudentEntity studentEntity = studentRepo.getById(studentId);
        if (Objects.isNull(studentEntity)) throw new BusinessException(StudentError.STUDENT);

        return new ResponseEntity<>(studentEntity.getFees(), HttpStatus.OK);
    }
    

}

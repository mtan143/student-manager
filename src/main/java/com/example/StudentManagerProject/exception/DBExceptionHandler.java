package com.example.StudentManagerProject.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NonUniqueResultException;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Optional;

@ControllerAdvice
@RestController
public class DBExceptionHandler {

    @ExceptionHandler({
            SQLException.class,
            DataAccessException.class,
            DataIntegrityViolationException.class,
            BadSqlGrammarException.class,
            NoSuchElementException.class,
            NonUniqueResultException.class
    })
    public ResponseEntity<?> handleSQLError(Exception e) {
        BusinessException exception = new BusinessException(Status.FAILED.name(), e.getMessage());
        e.setStackTrace(new StackTraceElement[]{});
        return ResponseEntity.of(Optional.of(exception));
    }
}

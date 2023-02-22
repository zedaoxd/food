package com.food.controller.exception;


import com.food.service.exception.DatabaseException;
import com.food.service.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<DefaultException> handleNotFoundException(NotFoundException e, HttpServletRequest request) {
        DefaultException err = new DefaultException();
        err.setTimestamp(new Date());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<DefaultException> handleNotFoundException(DatabaseException e, HttpServletRequest request) {
        DefaultException err = new DefaultException();
        err.setTimestamp(new Date());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Database integrity violation, foreign key reference, cannot delete");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.badRequest().body(err);
    }
}

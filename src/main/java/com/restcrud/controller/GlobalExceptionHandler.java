package com.restcrud.controller;

import com.restcrud.exception.StudentAlreadyExistException;
import com.restcrud.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = StudentNotFoundException.class)
    public ProblemDetail handleStudentNotFoundException(StudentNotFoundException e)
    {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("STUDENT NOT FOUND");
        return problemDetail;
    }

    @ExceptionHandler(value = StudentAlreadyExistException.class)
    public ProblemDetail handleStudentAlreadyExistException(StudentAlreadyExistException e)
    {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problemDetail.setTitle("STUDENT ALREADY EXIST");
        return problemDetail;
    }
}

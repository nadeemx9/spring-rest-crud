package com.restcrud.controller;

import com.restcrud.model.Student;
import com.restcrud.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class MyController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
        return new ResponseEntity<String>("Student Added Successfully!",HttpStatus.CREATED);
    }

    @GetMapping("{rollno}")
    public ResponseEntity<Student> getStudent(@PathVariable("rollno") Integer rollno)
    {
        return new ResponseEntity<>(studentService.getStudent(rollno), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents()
    {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.FOUND);
    }
    @PutMapping
    public ResponseEntity<String> updateStudent(@RequestBody Student student)
    {
        studentService.updateStudent(student);
        return new ResponseEntity<>("Student Detail Updated Successfully!", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{rollNo}")
    public ResponseEntity<String> deleteStudent(@PathVariable("rollNo") int rollNo)
    {
        studentService.deleteStudent(rollNo);
        return new ResponseEntity<>("Student Deleted Successfully!", HttpStatus.OK);
    }
}

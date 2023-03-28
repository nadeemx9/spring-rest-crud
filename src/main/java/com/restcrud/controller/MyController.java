package com.restcrud.controller;

import com.restcrud.model.Student;
import com.restcrud.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class MyController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping
    public String addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
        return "Student Added Successfully!";
    }

    @GetMapping("{rollno}")
    public Student getStudent(@PathVariable("rollno") Integer rollno)
    {
        return studentService.getStudent(rollno);
    }

    @GetMapping
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @PutMapping
    public String updateStudent(@RequestBody Student student)
    {
        studentService.updateStudent(student);
        return "Student Updated Successfully!";
    }

    @DeleteMapping("{rollNo}")
    public String deleteStudent(@PathVariable("rollNo") int rollNo)
    {
        studentService.deleteStudent(rollNo);
        return "Student Delete Successfully!";
    }

}

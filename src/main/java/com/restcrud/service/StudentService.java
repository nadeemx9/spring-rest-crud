package com.restcrud.service;

import com.restcrud.model.Student;

import java.util.List;

public interface StudentService {

    public Student addStudent(Student student);
    public Student getStudent(int id);
    public List<Student> getAllStudents();
    public String updateStudent(Student student);
    public String deleteStudent(int id);
}

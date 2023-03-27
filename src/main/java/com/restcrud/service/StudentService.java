package com.restcrud.service;

import com.restcrud.model.Student;
import com.restcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public Student getStudent(int id)
    {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    public String updateStudent(Student student)
    {
        studentRepository.save(student);
        return "Student Updated Successfully!";
    }

    public String deleteStudent(int id)
    {
        studentRepository.deleteById(id);
        return "Student Deleted Successfully!";
    }

}


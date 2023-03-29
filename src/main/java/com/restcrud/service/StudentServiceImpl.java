package com.restcrud.service;

import com.restcrud.exception.StudentAlreadyExistException;
import com.restcrud.exception.StudentNotFoundException;
import com.restcrud.model.Student;
import com.restcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student)
    {
        if(studentRepository.findById(student.getRollno()).isPresent())
            throw new StudentAlreadyExistException("Student with Rollno '"+student.getRollno()+"' Already Exist!");
        return studentRepository.save(student);
    }

    public Student getStudent(int id)
    {
        if(studentRepository.findById(id).isEmpty())
            throw new StudentNotFoundException("Student with Rollno : '"+id+"' not found!");
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
        if(studentRepository.findById(id).isEmpty())
            throw new StudentNotFoundException("Student with Rollno : '"+id+"' not found!");
        studentRepository.deleteById(id);
        return "Student Deleted Successfully!";
    }

}


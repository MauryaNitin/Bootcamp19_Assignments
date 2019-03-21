package com.ttn.springboot.service;


import com.ttn.springboot.repository.StudentRepository;
import com.ttn.springboot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public Student getStudent(int id){
        return studentRepository.getStudent(id);
    }

    public void updateStudent(int id, Student student){
        studentRepository.updateStudent(id, student);
    }

    public void deleteStudent(int id){
        studentRepository.deleteStudent(id);
    }
}

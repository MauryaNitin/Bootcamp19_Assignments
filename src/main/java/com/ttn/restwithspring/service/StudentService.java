package com.ttn.restwithspring.service;

import com.ttn.restwithspring.entity.Student;
import com.ttn.restwithspring.exceptions.UserNotFoundException;
import com.ttn.restwithspring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public Student getStudentById(Integer id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student = (optionalStudent.isPresent() ? optionalStudent.get() : null);
        if(student == null){
            throw new UserNotFoundException("No such user Exists!");
        }
        return student;
    }

    public List<Student> getAllStudents(){
        return (List<Student>) studentRepository.findAll();
    }

    public void updateStudent(Student student, Integer id){
        Student student1 =  getStudentById(id);
        student1 = student;
        studentRepository.save(student1);
    }

    public void deleteStudentById(Integer id){
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}

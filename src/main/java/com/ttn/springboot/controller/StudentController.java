package com.ttn.springboot.controller;

import com.ttn.springboot.entity.Student;
import com.ttn.springboot.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Ques 1: Create a Restful API using Spring Boot for Student.
 * Ques 6: Apply Logging wherever you feel is necessity
 */

@RestController
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @RequestMapping("/")
    public String welcome(){
        return "homepage";
    }

    @PostMapping("/student/register")
    public void addStudent(@ModelAttribute Student student){
        logger.info("adding a student", Student.class);
        studentService.addStudent(student);
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        logger.debug("getting student having id" + id);
        return studentService.getStudent(id);
    }

    @PutMapping("/student/{id}/edit")
    public void updateStudent(@PathVariable int id, Student student){
        logger.info("updating student having id " + id );
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("/student/{id}")
    public void removeStudent(@PathVariable int id){
        logger.warn("deleting student having id " + id);
        studentService.deleteStudent(id);
    }
}

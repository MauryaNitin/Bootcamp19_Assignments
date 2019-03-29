package com.ttn.restwithspring.controller;

import com.ttn.restwithspring.entity.Student;
import com.ttn.restwithspring.exceptions.UserNotFoundException;
import com.ttn.restwithspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    MessageSource messageSource;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/students/register")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student){
        studentService.createStudent(student);
        URI uri= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(student.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<String> updateStudent(@Valid @RequestBody Student student, @PathVariable Integer id){
        studentService.updateStudent(student, id);
        return ResponseEntity.ok("Student updated Successfully");
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student deleted successfully!");
    }


//  Ques 4: Perform Internationalization for a greeting message in your app.
    @GetMapping("/")
    String greet(@RequestHeader(name = "Accept-Language",required = false) Locale locale){
        System.out.println(locale.getLanguage());
        return messageSource.getMessage("good.morning.message",null,locale);
    }
}

package com.ttn.springboot.repository;

import com.ttn.springboot.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Ques 7: Bootstrap Data for Student Domain
 */

import java.util.Calendar;
import java.util.Random;

@Component
public class BootstrapStudent {
    Logger logger = LoggerFactory.getLogger(BootstrapStudent.class);

    @Autowired
    StudentRepository studentRepository;

    @EventListener(ApplicationStartedEvent.class)
    public void init(){
        if(studentRepository.getTotalRecords() > 1){
            logger.info("Inserting Dummy data in Student Table.");
            for(int i = 1; i <= 5; i++){
                Student student = new Student();
                student.setName("Student " + i);
                student.setAge(new Random().nextInt(25));
                student.setEmail("student" + i + "@gmail.com");
                studentRepository.addStudent(student);
            }
        }
    }

}

package com.ttn.springAOP.Q4_Q5_Q6;

/**
 * Ques 4: Create a logging aspect. Create a pointcut to log all methods Of services .
 *
 * Ques 5: Add a logging statement before and after the method ends
 *
 * Ques 6: Log all the methods which throw IOException
 *
 **/

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Q4_Q5_Q6_Logger {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        LoggerService logger = (LoggerService) context.getBean("loggerService");

        logger.method1();

        logger.method2();

        try {
            logger.method3();       // Q6
        } catch (IOException e) { }

        logger.method4();

        logger.method5();           // Q5

    }
}

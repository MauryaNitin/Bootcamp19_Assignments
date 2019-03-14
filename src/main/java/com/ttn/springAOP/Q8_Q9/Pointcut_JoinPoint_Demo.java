package com.ttn.springAOP.Q8_Q9;

/**
 * Ques 8:   Demonstrate the use of pointCut @Pointcut annotation and Reuse the expression created
 *
 * Ques 9: Access the properties of the JoinPoint in before advice. Print Signature of method being called and its arguments
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Pointcut_JoinPoint_Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Car car = context.getBean(Car.class);

        car.start();

        car.stop();

        car.drive("BMW");
    }
}

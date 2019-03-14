package com.ttn.springAOP.Q1_Q2;

/**
 * Ques 1: Invoke context events start(), stop() and close().
 *
 * Ques 2: Create listeners for spring events.
 */

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Q1_Q2_ContextEvents {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        context.start();
        context.stop();
        context.close();
    }
}

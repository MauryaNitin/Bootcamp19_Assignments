package com.ttn.springAOP.Q7;

/**
 *
 * Ques 7: Apply execution, within, args, this and bean expressions on the before and after advice of service bean.
 *
*/


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Q7_Main {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        EmailService mailer = context.getBean(EmailService.class);
        mailer.method1();
        mailer.method2();
        mailer.method3();
        mailer.method4();
        mailer.method5(55);
    }
}




package com.ttn.springAOP.Q7;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class EmailAspect {
    @Before("execution(public void method1())")
    public void executionDemo(){
        System.out.println("\nexecution Demo");
    }

    @After("within(com.ttn.springAOP.Q7.EmailService)")
    public void withinDemo(){
        System.out.println("within Demo\n");
    }

    @After("args(Integer)")
    public void argsDemo(){
        System.out.println("Args Demo");
    }

    @Before("this(com.ttn.springAOP.Q7.EmailService)")
    public void thisDemo(){
        System.out.println("This Demo");
    }

    @Before("bean(emailService)")
    public void beanDemo(){
        System.out.println("Bean Demo");
    }


}

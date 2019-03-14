package com.ttn.springAOP.Q7;

import org.springframework.stereotype.Component;


@Component
public class EmailService {
    public void method1(){
        System.out.println("> method 1");
    }

    public void method2(){
        System.out.println("> method 2");
    }

    public void method3(){
        System.out.println("> method 3");
    }

    public void method4(){
        System.out.println("> method 4");
    }

    public void method5(Integer num){
        System.out.println("> method 5  - Integer " + num);
    }
}

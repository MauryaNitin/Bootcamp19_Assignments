package com.ttn.springAOP.Q4_Q5_Q6;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggerService {
    public void method1(){
        System.out.println("> method 1\n");
    }

    public void method2(){
        System.out.println("> method 2\n");
    }

    public void method3() throws IOException{       // Q6
        System.out.println("> method 3");
        throw new IOException("IOException thrown from method 3\n");
    }

    public void method4(){
        System.out.println("> method 4\n");
    }

    public void method5(){
        System.out.println("> method 5\n");
    }
}

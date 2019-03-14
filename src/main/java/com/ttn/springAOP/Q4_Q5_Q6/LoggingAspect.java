package com.ttn.springAOP.Q4_Q5_Q6;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(* com.ttn.springAOP.Q4_Q5_Q6.LoggerService.*(..))")
    public void beforeMethodLogger(JoinPoint joinPoint){
        System.out.println("Info: " + joinPoint.getSignature());
    }

    @Around("execution(public void method5())")
    public void aroundMethodLogger(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("before method 5 log");
        joinPoint.proceed();
        System.out.println("after method 5 log");
    }

    @AfterThrowing(pointcut = "execution(* com.ttn.springAOP.Q4_Q5_Q6.LoggerService.*(..) )", throwing = "exception")
    public void afterThrowingException(IOException exception){
        System.out.println(exception.getMessage());
    }
}

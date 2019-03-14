package com.ttn.springAOP.Q8_Q9;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CarAspect {
    @Pointcut("execution(* com.ttn.springAOP.Q8_Q9.Car.start())")
    void carStartPointcut(){ }

    @Pointcut("execution(* com.ttn.springAOP.Q8_Q9.Car.stop())")
    void carStopPointcut(){ }

    @Before("carStartPointcut() || carStopPointcut()")
    void beforeAdvice() {
        System.out.println("\nReusing Pointcut");
    }

    @Before("execution(* com.ttn.springAOP.Q8_Q9.Car.drive(String))")
    void joinPointDemo(JoinPoint joinPoint){
        System.out.println("\nSignature: " + joinPoint.getSignature());
        Object[] args = joinPoint.getArgs();
        for(Object o : args){
            System.out.println("Arguments: " + o);
        }

    }

}

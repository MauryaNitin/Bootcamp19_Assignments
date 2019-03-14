package com.ttn.springAOP.Q8_Q9;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private String name;

    public void start(){
        System.out.println("Car Started.");
    }

    public void drive(String name){
        System.out.println("Driving " + name + " car.");
    }

    public void stop(){
        System.out.println("Car Stopped.");
    }
}

package com.ttn.springCore.AutowiringAnnotationDemo;

/**
 *  Ques 9:  Use @Autowired annotation to wire Tea with Restaurant class Using setter method, field and constructor.
 *
 *  Ques 10: Use @Component, @Controller, @Repository etc annotation to configure Tea and Restaurant in Spring Container.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


interface HotDrink {
    void prepareDrink();
}

//@Component("drink")       /*Ques 10*/
class Tea implements HotDrink{
    public void prepareDrink(){
        System.out.println("Preparing Tea...");
    }

    @Override
    public String toString() {
        return "Tea";
    }
}

//@Component("restaurant")  /*Ques 10*/
class Restaurant {
    @Autowired
    private HotDrink drink;

    public HotDrink getDrink() {
        return drink;
    }

    @Autowired
    public void setDrink(HotDrink drink) {
        System.out.println("Setter called.");
        this.drink = drink;
    }

    @Autowired
    Restaurant(HotDrink drink){
        System.out.println("Parameterized constructor called.");
        this.drink = drink;
    }

    Restaurant(){
        System.out.println("Default constructor called.");
    }
}

public class Q9_Q10_AutowiringAnnotationDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-autowiringAnnotationDemo.xml");
        Restaurant restaurant = (Restaurant) context.getBean("restaurant");
        System.out.println(restaurant.getDrink());
    }
}

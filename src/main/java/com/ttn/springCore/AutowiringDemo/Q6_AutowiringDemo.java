package com.ttn.springCore.AutowiringDemo;

/***
 *  Ques 6: Autowire hotDrink in Restaurant with tea bean byName, byType and constructor.
 */


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

interface HotDrink {
    void prepareDrink();
}

class Tea implements HotDrink{
    public void prepareDrink(){
        System.out.println("Preparing Tea...");
    }

    @Override
    public String toString() {
        return "Tea";
    }
}

class Restaurant {
    HotDrink drink;

    public HotDrink getDrink() {
        return drink;
    }

    public void setDrink(HotDrink drink) {
        System.out.println("Setter called.");
        this.drink = drink;
    }

    Restaurant(HotDrink drink){
        System.out.println("My constructor has been called.");
        this.drink = drink;
    }

    Restaurant(){
        System.out.println("My default constructor has been called.");
    }
}

public class Q6_AutowiringDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-autowiringDemo.xml");
        Restaurant restaurant = (Restaurant)context.getBean("restaurant");
        System.out.println(restaurant.getDrink());
    }
}


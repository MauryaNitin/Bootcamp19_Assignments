package com.ttn.ex_1;

/**
 *  Q7. Write a program to print your Firstname,LastName & age using static block,static method & static variable respectively
 */

public class ques7_static_example {
    private static String Firstname;
    private static String Lastname;
    private static int Age;
    static {
        Firstname = "Nitin";
        Lastname = "Maurya";
        Age = 22;
    }

    static void display(){
        System.out.println("Firstname: " + Firstname);
        System.out.println("Lastname: " + Lastname);
        System.out.println("Age: " + Age);
    }

    public static void main(String[] args) {
        display();
    }
}

package com.ttn.java.java8;

/**
 * 8.  Implement multiple inheritance with default method inside  interface.
 */

interface Parent1{
    default void display(){
        System.out.println("I am Father.");
    }
}

interface Parent2{
    default void display(){
        System.out.println("I am Mother.");
    }
}

class Child implements Parent1, Parent2{
    public void display(){
        Parent1.super.display();
//        System.out.println("I am Child.");
    }
}

public class Ques8_MultipleInheritanceWithDefaultMethod {
    public static void main(String[] args) {
        new Child().display();
    }
}

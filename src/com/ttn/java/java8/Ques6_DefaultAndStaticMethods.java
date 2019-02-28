package com.ttn.java.java8;


/**
 * 6.  Create and access default and static method of an interface.
 */

interface Animal{
    static void eat(){
        System.out.println("Animal eating..");
    }

    default void talk(){
        System.out.println("Animal makes sound..");
    }
}

class Dog implements Animal{
//    @Override
//    public void talk(){
//        System.out.println("Bark");
//    }
}

public class Ques6_DefaultAndStaticMethods {
    public static void main(String[] args) {
        Animal.eat();

        Dog dog = new Dog();
        dog.talk();

    }
}

package com.ttn.java.java8;

/**
 * 2. Create a functional interface whose method takes 2 integers and return one integer.
 */

@FunctionalInterface
interface Summation{
    int sum(int num1, int num2);
}

public class Ques2_FunctionalInterface_2 {
    public static void main(String[] args) {
        Summation summation = (a,b) -> a + b;
        System.out.println("Sum = " + summation.sum(5, 9));
    }
}

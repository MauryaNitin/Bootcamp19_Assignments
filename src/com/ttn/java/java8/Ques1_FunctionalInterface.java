package com.ttn.java.java8;

/**
 * 1. Write the following a functional interface and implement it using lambda:
 * (1) First number is greater than second number or not         Parameter (int ,int ) Return boolean
 * (2) Incrementer the number by 1 and return incremented value    Parameter (int) Return int
 * (3) Concatination of 2 string                                 Parameter (String , String ) Return (String)
 * (4) Convert a string to uppercase and return .                Parameter (String) Return (String)
 *
 */

@FunctionalInterface
interface Greater{
    boolean isGreater(int num1, int num2);
}

@FunctionalInterface
interface Incrementer {
    int incrementAndGet(int num1);
}

@FunctionalInterface
interface Concatenater{
    String concat(String str1, String str2);
}

@FunctionalInterface
interface UpperCaser{
    String toUpper(String string);
}


public class Ques1_FunctionalInterface {
    public static void main(String[] args) {
        Greater greater = (a,b) -> (a > b);
        System.out.println(greater.isGreater(15, 8));

        Incrementer increment = a -> a++;
        System.out.println(increment.incrementAndGet(5));

        Concatenater concatenate = (a,b) -> a+b;
        System.out.println(concatenate.concat("Nitin", "Maurya"));

        UpperCaser upperCase = a -> a.toUpperCase();
        System.out.println(upperCase.toUpper("tothenew"));
    }
}

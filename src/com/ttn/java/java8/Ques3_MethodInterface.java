package com.ttn.java.java8;

import java.util.function.BiFunction;

/**
 * 3. Using (instance) Method reference create and apply add and subtract method and using (Static) Method reference
 * create and apply multiplication method for the functional interface created.
 */

@FunctionalInterface
interface Adder{
    int add(int a, int b);
}

@FunctionalInterface
interface Subtractor{
    int subtract(int a, int b);
}

class Calculate implements Adder, Subtractor{
    public int add(int a, int b){
        return a + b;
    }
    public int subtract(int a, int b){
        return a - b;
    }
}

@FunctionalInterface
interface MultiplierInterface{
    int multiply(int a, int b);
}

class Multiplication{
    static int multiply(int a, int b){
        return (a*b);
    }
}

public class Ques3_MethodInterface {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();


        BiFunction<Integer, Integer, Integer> biFunction = calculate::add;
        System.out.println("Addition: " + biFunction.apply(5,8));

        Subtractor subtractor = calculate::subtract;
        System.out.println("Subtraction: " + subtractor.subtract(9, 6));


        MultiplierInterface multiplier = Multiplication::multiply;
        System.out.println("Multiplication: " + multiplier.multiply(5,9));

//        biFunction = Multiplier::multiply;
//        System.out.println("Multiplication: " + biFunction.apply(5,9));


    }
}

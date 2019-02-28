package com.ttn.java.java8;

/**
 * 10. Sum all the numbers greater than 5 in the integer list.
 */

import java.util.Random;
import java.util.stream.IntStream;

public class Ques10_SumOfNums {
    public static void main(String[] args) {
        IntStream stream = new Random().ints(50, 1,10);

//        stream.forEach(System.out::println);

        int result = stream.filter(a -> a > 5).reduce(0, (a ,b) -> (a + b));

        System.out.println("Result: " + result);
    }
}

package com.ttn.java.java8;

/**
 * 11. Find average of the number inside integer list after doubling it.
 */

import java.util.stream.IntStream;

public class Ques11_AverageOfNums {
    public static void main(String[] args) {
        IntStream stream = IntStream.rangeClosed(1,10).map(a -> a*a);
        double avg = stream.average().getAsDouble();
        System.out.println("Average: " + avg);
    }
}

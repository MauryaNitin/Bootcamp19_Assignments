package com.ttn.java.java8;

/**
 * 9.  Collect all the even numbers from an integer list.
 */

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ques9_CollectEvens {
    public static void main(String[] args) {
        IntStream is = IntStream.rangeClosed(1, 500).filter(a -> (a&1) == 0);
        is.forEach(System.out::println);

//        Stream s = Arrays.asList(1,2,3,3,2,21,2,5,13,423,423,4,23,4,23,4,2,342,42,34,2,34).stream().filter(a -> (a%2) == 0);
//        s.forEach(System.out::println);
    }
}

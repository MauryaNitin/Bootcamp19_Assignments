package com.ttn.java.java8;

import java.util.*;
import java.util.stream.Stream;

/**
 * 12.  Find the first even number in the integer list which is greater than 3.
 */

public class Ques12_FindFirst {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 7, 2, 8);
        Stream<Integer> stream = numbers.stream();
        Optional<Integer> result = stream.filter(a -> a>3 && (a%2 == 0)).findFirst();
        if(result.isPresent()){
            System.out.println(result.get());
        }else{
            System.out.println("No Value");
        }
    }
}

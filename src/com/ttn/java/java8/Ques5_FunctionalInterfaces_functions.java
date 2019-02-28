package com.ttn.java.java8;

import java.util.function.*;

/**
 * 5. Implement following functional interfaces from java.util.function using lambdas:
 *
 * (1) Consumer
 *
 * (2) Supplier
 *
 * (3) Predicate
 *
 * (4) Function
 */

class Employees{
    static private String companyName = "To The New";
    static String  getCompanyName(){
        return companyName;
    }
}

public class Ques5_FunctionalInterfaces_functions {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer.accept("Hello World!");

        Supplier<String> supplier = Employees::getCompanyName;
        System.out.println("Supplier -> " + supplier.get());

        Predicate<Integer> predicate = a -> a > 5;
        System.out.println("Predicate -> " + predicate.test(17));
        System.out.println("Predicate -> " + predicate.test(3));

        Function<String, String> function = String::toUpperCase;
        System.out.println("Function -> " + function.apply("intelligrape"));
    }
}

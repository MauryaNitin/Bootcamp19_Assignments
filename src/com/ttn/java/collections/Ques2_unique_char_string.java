package com.ttn.java.collections;

import java.util.*;

/**
 * 2. Write a method that takes a string and returns the number of unique characters in the string.
 */


public class Ques2_unique_char_string {
    private static int unique_chars(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str = scan.nextLine();
        System.out.println("No of unique Characters in " + str + " are: " + unique_chars(str));
    }
}
package com.ttn.java.collections;

/**
 * 3. Write a method that takes a string and print the number of occurrence of each character characters in the string.
 */

import java.util.*;

public class Ques3_chars_occurrences {
    private static Map<Character, Integer> chars_occurences(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str = scan.nextLine();
        System.out.println("Occurrences of characters in " + str + " : " + chars_occurences(str));

    }
}

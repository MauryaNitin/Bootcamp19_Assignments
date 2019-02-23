package com.ttn.java_session_2;

import java.util.Arrays;
import java.util.Scanner;

/***
 *  2. WAP to sorting string without using string Methods?.
 */

public class Ques2_Sort_string {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scan.nextLine();
        char[] str_arr = str.toCharArray();
        Arrays.sort(str_arr);
        String sorted = new String(str_arr);
        System.out.println("Sorted string: " + sorted);
    }
}

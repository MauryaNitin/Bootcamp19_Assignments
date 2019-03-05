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
        String str = scan.next();
        char[] str_arr = str.toCharArray();
        Arrays.sort(str_arr);
        String sorted = new String(str_arr);
        System.out.println("Sorted string: " + sorted);

//        StringBuilder str = new StringBuilder(scan.nextLine());
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = 0; j < str.length(); j++) {
//
//                if(str.charAt(j) > str.charAt(i)){
//                    char temp = str.charAt(i);
//                    str.setCharAt(i,str.charAt(j));
//                    str.setCharAt(j, temp);
//                }
//
//            }
//        }
//        System.out.println("Sorted string: " + str);
    }
}

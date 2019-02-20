package com.ttn.ex_1;

import java.util.Scanner;

/**
 *  Q3. Write a program to find the number of occurrences of a character in a string without using loop?
 */

public class ques3_count_character {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str = scan.nextLine();

        System.out.println("Enter a character: ");
        String ch = scan.nextLine();

        System.out.println("Occurrences of " + ch + " in " + str + " : " + (str.length() - str.replaceAll(ch, "").length()));

    }
}

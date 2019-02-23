package com.ttn.java_session_2;

import java.util.Scanner;

/**
 * 8. WAP to read words from the keyboard until the word done is entered. For each word except done, report whether its first character is equal   to  its last character. For the required loop, use a
 * a)while statement
 * b)do-while statement
 */

public class Ques8_loop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word;
        System.out.println("Executing While loop: ");
        while((word = scan.next()) != null){
            if(word.equals("done")){
                break;
            }
            else{
                System.out.println("first char equals last char for " + word + " : " + (word.charAt(0) == word.charAt(word.length()-1)));
            }
        }

        System.out.println("Executing do While loop: ");
        do{
            word = scan.next();
            System.out.println("first char equals last char for " + word + " : " + (word.charAt(0) == word.charAt(word.length()-1)));
        }while(!(word.equals("done")));
    }
}

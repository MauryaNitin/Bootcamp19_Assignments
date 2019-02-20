package com.ttn.ex_1;

import java.util.Scanner;

/**
 *  Q4. Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, Digits And Other Special Characters In A String
 */

public class ques4_letters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String s = scan.nextLine();
        int len = s.length();
        int lowerCase = 0;
        int upperCase  = 0;
        int digits = 0;
        int special = 0;
        char[] str = s.toCharArray();
        for (int i = 0 ; i < len; i++){
            if(Character.isLowerCase(str[i])){
                lowerCase++;
            }
            else if(Character.isUpperCase(str[i])){
                upperCase++;
            }
            else if(Character.isDigit(str[i])){
                digits++;
            }
            else {
                special++;
            }
        }
        System.out.println("The no of Lowercase letters are: " + lowerCase + " Percentage: " + (float)(lowerCase*100/len));
        System.out.println("The no of Uppercase letters are: " + upperCase + " Percentage: " + (float)(upperCase*100/len));
        System.out.println("The no of Digits are: " + digits + " Percentage: " + (float)(digits*100/len));
        System.out.println("The no of Special Characters are: " + special + " Percentage: " + (float)(special*100/len));
            
    }
}

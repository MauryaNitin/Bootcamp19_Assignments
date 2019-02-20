package com.ttn.ex_1;

import java.util.Scanner;

/**
 *   Q8. Write a program to reverse a string and remove character from index 4 to index 9 from the reversed string using String Buffer
 *
* */

public class ques8_reverse_string {

    private static StringBuffer reverse(StringBuffer s){
        int n = s.length();
        for(int i = 0 ; i < n/2; i++){
            char temp = s.charAt(i);
            s.setCharAt(i, s.charAt(n-i-1));
            s.setCharAt(n-i-1, temp);
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string: ");
        StringBuffer str = new StringBuffer(scan.nextLine());
        StringBuffer rev_str = reverse(str);
        System.out.println("Reverse :" + rev_str);
        rev_str.delete(4,9);
        System.out.println("After deleting 4-9 chars: " + rev_str);
    }
}

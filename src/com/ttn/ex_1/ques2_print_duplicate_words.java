package com.ttn.ex_1;

/***
 * Q2. Write a program to find the number of occurrences of the duplicate words in a string and print them ?
 *
 */

public class ques2_print_duplicate_words {
    public static void main(String[] args) {
        String str = "This is India. India is a great country.";

        String[] arr = str.trim().replaceAll("\\s{2,}", " ").replace(".", "").split(" ");

        for(int i = 0 ; i < arr.length; i++){
            int count  = 1;
            for(int j = i+1; j < arr.length; j++){
                if(arr[i].equals(arr[j])){
                    count++;
                    arr[j] = "";
                }
            }
            if(!(arr[i].equals(""))){
                System.out.println(arr[i] +" = "+ count);
            }
        }
    }
}

package com.ttn.ex_1;

/***
 *  Q1. Write a program to replace a substring inside a string with other string ?
 *
 * */

public class ques1_replace_substring {
    public static void main(String[] args){
        String str  = "Welcome to Delhi";

        System.out.println("Original String: " + str);

        System.out.println("Replaced String: " + str.replace(str.substring(11,15), "$To The New$"));
    }
}

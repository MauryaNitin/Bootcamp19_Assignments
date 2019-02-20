package com.ttn.ex_1;

import java.util.Scanner;

/**
 *  Q6. There is an array with every element repeated twice except one. Find that element
 */


public class ques6_unique_element {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter elements in array: ");
        for(int i = 1 ; i < arr.length; i++){
            arr[i] = scan.nextInt();
        }
        int res = arr[0];
        for(int i = 1 ; i < arr.length; i++){
            res  = res ^ arr[i];
        }
        System.out.println("The element appearing only once is : " + res);
    }

}

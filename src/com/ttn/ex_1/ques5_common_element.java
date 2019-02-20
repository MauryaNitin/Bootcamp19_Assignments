package com.ttn.ex_1;

import java.util.Scanner;

/**
 *  Q5. Find common elements between two arrays.
 */

public class ques5_common_element {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of array1: ");
        int size1 = scan.nextInt();
        System.out.println("Enter elements in Array 1: ");
        int[] array1 = new int[size1];
        for(int i = 0 ; i < size1; i++){
            array1[i] = scan.nextInt();
        }
        System.out.println("Enter size of Array 2: ");
        int size2 = scan.nextInt();
        System.out.println("Enter elements in Array 2: ");
        int[] array2 = new int[size2];
        for (int i = 0 ; i < size2; i++){
            array2[i] = scan.nextInt();
        }
        System.out.println("The Common Elements are: ");
        for(int i = 0 ; i < array1.length; i++){
            for(int j=0; j < array2.length; j++){
                if(i < array1.length && array1[i] == array2[j]){
                    System.out.println(array1[i]);
                    i++;
                }
            }
        }

    }
}

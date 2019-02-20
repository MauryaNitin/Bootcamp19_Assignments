package com.ttn.ex_1;

/**
* Q10.Write a single program for following operation using overloading
  A) Adding 2 integer number
  B) Adding 2 double
  C) multiplying 2 float
  D) multiplying 2 int
  E) concate 2 string
  F) Concate 3 String
*
* */

public class ques10_overloading {
    private int add(int num1,int num2){
        return num1+num2;
    }

    private double add(double num1, double num2){
        return num1+num2;
    }

    private float multiply(float num1, float num2){
        return num1*num2;
    }

    private int multiply(int num1, int num2){
        return num1*num2;
    }

    private String concat(String s1, String s2){
        return s1+s2;
    }

    private String concat(String s1, String s2, String s3){
        return s1+s2+s3;
    }
    public static void main(String[] args) {
        ques10_overloading q = new ques10_overloading();
        System.out.println("Adding two integers 8 + 6: " + q.add(8,6));
        System.out.println("Adding two doubles 5.004 + 6.324: " + q.add(5.004, 6.324));
        System.out.println("Multiplying two floats 9.0202 * 7.1245: " + q.multiply(9.0202f, 7.1245f));
        System.out.println("Multiplying two floats 5 * 7: " + q.multiply(5,7));
        System.out.println("Concatenate two strings 'hello' 'world': " + q.concat("Hello", "World"));
        System.out.println("Concatenate three strings 'To' 'The' 'New': " + q.concat("To", "The", "New"));

    }
}

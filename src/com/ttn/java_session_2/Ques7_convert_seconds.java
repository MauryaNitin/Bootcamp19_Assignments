package com.ttn.java_session_2;

import java.util.Scanner;

/**
 * 7. WAP to convert seconds into days, hours, minutes and seconds.
 */


public class Ques7_convert_seconds {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Seconds: ");
        long seconds = scan.nextLong();
        long secs = seconds;
        int days = (int) (secs / (60*60*24));
        secs = secs%86400;
        int hrs = (int) (secs / (60*60));
        secs = secs%3600;
        int mins = (int) (secs / 60);
        secs = secs%60;
        System.out.println(days + " days " + hrs + " hrs " + mins + " mins " + secs + " secs.");
    }
}

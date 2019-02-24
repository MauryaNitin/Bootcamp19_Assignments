package com.ttn.java.collections;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 9. Write a program to display times in different country format.
 */

public class Ques9_Display_time{
    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();


        Locale american = new Locale("en", "US");
        Locale german = new Locale("de", "DE");
        Locale portugese = new Locale("pt", "PT");
        Locale french = new Locale("fr", "FR");
        Locale italian = new Locale("it", "IT");
        Locale indian = new Locale("hi", "IN");

        System.out.println("Dates in Different Country Formats: \n");

        DateFormat Usa = DateFormat.getDateInstance(DateFormat.FULL, american);
        System.out.println("USA: " + Usa.format(today));

        DateFormat Germany = DateFormat.getDateInstance(DateFormat.FULL, german);
        System.out.println("Germany: " + Germany.format(today));

        DateFormat Portugal = DateFormat.getDateInstance(DateFormat.FULL, portugese);
        System.out.println("Portugal: " + Portugal.format(today));

        DateFormat France = DateFormat.getDateInstance(DateFormat.FULL, french);
        System.out.println("France: " + France.format(today));

        DateFormat Italy = DateFormat.getDateInstance(DateFormat.FULL, italian);
        System.out.println("Italy: " + Italy.format(today));

        DateFormat India = DateFormat.getDateInstance(DateFormat.FULL, indian);
        System.out.println("India: " + India.format(today));

    }
}

package com.ttn.java.collections;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ques8_FormatDate {
    public static void main(String[] args) {
        SimpleDateFormat formatter  = new SimpleDateFormat("dd-MMMM-YYYY");
        System.out.println("Today Date: " + formatter.format(new Date()));
    }
}

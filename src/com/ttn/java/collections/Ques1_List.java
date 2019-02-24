package com.ttn.java.collections;

/**
 * 1. Write Java code to define List . Insert 5 floating point numbers in List, and using an iterator, find the sum of the numbers in List.
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Ques1_List {
    public static void main(String[] args) {
        List<Float> l= new ArrayList<>();
        l.add(5.324f);
        l.add(9.156f);
        l.add(4.238f);
        l.add(7.198f);
        l.add(2.148f);

        System.out.println("List: " + l);
//        Iterator<Float> itr = l.iterator();
        ListIterator<Float> itr = l.listIterator();
        float sum = 0;
        while(itr.hasNext()){
            sum = sum + itr.next();
        }
        System.out.println("Sum of List : " + sum);

    }
}

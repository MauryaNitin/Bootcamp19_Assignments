package com.ttn.java.designpatterns;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. Implement Singleton Design Pattern on a dummy class.
 */

class Task{
    private int id;
    private String name;

    public Task(String name){
        this.id++;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Printer {
    private static Printer printer;

    private static Queue<Task> q = new LinkedList<>();

    private Printer(){}



    public static Printer getPrinter(){
//        if(instance != null){
//            synchronized (Singleton.class){
//                if(instance != null){
//                    return instance;
//                }
//            }
//        }
        if(printer == null){
            synchronized (Printer.class){
                if(printer == null){
                    printer = new Printer();
                }
            }
        }
        return printer;
    }

    public void addTask(Task k){
        q.add(k);
    }

    @Override
    public String toString() {
        return q.toString();
    }
}

public class Ques1_Singleton {
    public static void main(String[] args) {
        Printer printer1 = Printer.getPrinter();
        Printer printer2 = Printer.getPrinter();

        System.out.println(printer1 == printer2);
        System.out.println(printer1.equals(printer2));

        printer1.addTask(new Task("doc1"));
        printer2.addTask(new Task("doc2"));

        System.out.println(printer1);
        System.out.println(printer2);

    }
}

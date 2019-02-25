package com.ttn.java.multithreading;

/**
 * 1. Create and Run a Thread using Runnable Interface and Thread class.
 */

class MyThread implements Runnable{
    public void run(){
        System.out.println("Thread " + Thread.currentThread().getName() + " is running by implementing Runnable interface.");
    }
}

class OtherThread extends Thread{
    public void run(){
        System.out.println("Thread " + Thread.currentThread().getName() + " is running by extending Thread Class.");
    }
}

public class Ques1_CreateThread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread());
        thread1.start();

        OtherThread thread2 = new OtherThread();
        thread2.start();
    }
}

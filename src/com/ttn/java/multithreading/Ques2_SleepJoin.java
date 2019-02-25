package com.ttn.java.multithreading;

/**
 * 2. Use sleep and join methods with thread.
 */

public class Ques2_SleepJoin {
    public static void main(String[] args) throws InterruptedException{

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000L);
                    System.out.println(Thread.currentThread().getName() + " is running....");
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000L);
                    System.out.println(Thread.currentThread().getName() + " is running....");
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        System.out.println("First Thread started.");
        thread1.start();
        System.out.println("First Thread Joined.");
        thread1.join();
        System.out.println("First Thread finished.");



        System.out.println("Second Thread started.");
        thread2.start();
        System.out.println("Second Thread Joined.");
        thread2.join();
        System.out.println("Second Thread finished.");


        System.out.println("Main Finished.");
    }
}

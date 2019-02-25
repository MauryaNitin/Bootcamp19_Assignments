package com.ttn.java.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 12. Use Atomic Classes instead of Synchronize method and blocks.
 */

public class Ques12_AtomicClasses {
    private static AtomicInteger count = new AtomicInteger();

    private  void increment(){
        count.incrementAndGet();
    }

    public void worker1(){
        for (int i = 0; i <= 1000; i++) {
            increment();
        }
    }

    public void worker2(){
        for (int i = 0; i <= 1000; i++) {
            increment();
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Ques12_AtomicClasses atomic = new Ques12_AtomicClasses();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomic.worker1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomic.worker2();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Total Count: " + count);
    }
}

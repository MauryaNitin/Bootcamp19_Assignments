package com.ttn.java.multithreading;

/**
 * 10. Use Synchronize block to enable synchronization between multiple threads trying to access method at same time.
 */


public class Ques11_SynchronizedBlock {

    private int count;

    private  void increment(){
        synchronized(this){
            count++;
        }
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

    public static void main(String[] args) throws InterruptedException {
        Ques11_SynchronizedBlock s = new Ques11_SynchronizedBlock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                s.worker1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                s.worker2();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Total Count: " + s.count);
    }
}

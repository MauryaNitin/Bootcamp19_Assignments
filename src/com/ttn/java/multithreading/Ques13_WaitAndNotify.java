package com.ttn.java.multithreading;

/**
 * 13. Coordinate 2 threads using wait() and notify().
 */

class MyWorker {
    private int count;

    private  void increment(){
        count++;
    }

    public void worker1(){
        System.out.println("Worker 1 started.");
        synchronized (this){
            try {
                wait();
                System.out.println("Worker 1 is incrementing...");
                increment();
            } catch (InterruptedException e) {
                System.out.println("Worker 1 waiting....");
            }
        }
        System.out.println("Worker 1 finished.");
    }

    public void worker2(){
        System.out.println("Worker 2 started.");
        synchronized (this){
            System.out.println("Worker 2 is incrementing...");
            increment();
            notify();
        }
        System.out.println("Worker 2 finished.");
    }
}

public class Ques13_WaitAndNotify {
    public static void main(String[] args) {
        MyWorker w = new MyWorker();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running Thread 1...");
                w.worker1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running Thread 2....");
                w.worker2();
            }
        });

        t1.start();
        t2.start();
    }
}

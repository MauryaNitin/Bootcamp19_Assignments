package com.ttn.java.multithreading;

/**
 * 14. Coordinate mulitple threads using wait() and notifyAll()
 */
class WorkerClass {
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
            try {
                wait();
                System.out.println("Worker 2 is incrementing...");
                increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Worker 2 finished.");
    }

    public void worker3(){
        System.out.println("Worker 3 started.");
        synchronized (this){
            System.out.println("Worker 3 is incrementing...");
            increment();
            notifyAll();
        }
        System.out.println("Worker 3 finished.");
    }

    public void worker4(){
        System.out.println("Worker 4 started.");
        synchronized (this){
            try {
                wait();
                System.out.println("Worker 4 is incrementing...");
                increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Worker 4 finished.");
    }
}


public class Ques14_WaitAndNotifyAll {
    public static void main(String[] args) {
        WorkerClass w = new WorkerClass ();
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

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running Thread 3....");
                w.worker3();
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running Thread 4....");
                w.worker4();
            }
        });


        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

package com.ttn.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 9. Increase concurrency with Thread pools using newCachedThreadPool() and newFixedThreadPool().
 */

class Process implements Runnable{
    int id;

    public Process(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread name:: "+Thread.currentThread().getName()+" -> Start :"+id);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread name:: "+Thread.currentThread().getName()+" -> End :"+id);
    }
}

public class Ques9_ThreadPools {
    public static void main(String[] args) {
        ExecutorService cachedThreadExecutor = Executors.newCachedThreadPool();
        ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(3);

        try{
            for (int i = 0; i < 10; i++) {
                cachedThreadExecutor.submit(new Process(i));
            }
        }
        finally {
            cachedThreadExecutor.shutdown();
        }

        try{
            for (int i = 20; i < 30; i++) {
                fixedThreadExecutor.submit(new Process(i));
            }
        }
        finally {
            fixedThreadExecutor.shutdown();
        }
    }
}

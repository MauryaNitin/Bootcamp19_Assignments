package com.ttn.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ques5_isShutdownAndisTerminated {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try{
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Running " + Thread.currentThread().getName() + " on single thread executor...");
                    System.out.println("Task 1");
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        System.out.println("Task1 sleep interrupted.");
                    }
                }
            });

            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Running " + Thread.currentThread().getName() + " on single thread executor...");
                    System.out.println("Task 2");
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        System.out.println("Task2 sleep interrupted.");
                    }
                }
            });

            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Running " + Thread.currentThread().getName() + " on single thread executor...");
                    System.out.println("Task 3");
                    try {
                        Thread.sleep(4000L);
                    } catch (InterruptedException e) {
                        System.out.println("Task3 sleep interrupted.");
                    }
                }
            });
        }
        finally{
            executor.shutdownNow();
        }
        System.out.println("Is Executor has been shutdown? : " + executor.isShutdown());
        System.out.println("Is Executor has been terminated? : " + executor.isTerminated());

        while(true){
            if(executor.isTerminated()){
                System.out.println("All Tasks has been completed.");
                break;
            }
        }

        System.out.println("Main Finished");
    }
}

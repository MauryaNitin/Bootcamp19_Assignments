package com.ttn.java.multithreading;

import java.util.concurrent.*;

/**
 * 8. Schedule task using schedule(), scheduleAtFixedRate() and scheduleAtFixedDelay()
 */

public class Ques8_ScheduleTask {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

        try{
            scheduledExecutor.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Schedule Task 1 is running..");
                }
            }, 2000L, TimeUnit.MILLISECONDS);

            scheduledExecutor.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Schedule Task 2  is running..");
                }
            }, 1000L, TimeUnit.MILLISECONDS);

            scheduledExecutor.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Schedule Task 3 is running..");
                }
            }, 4000L, TimeUnit.MILLISECONDS);

            scheduledExecutor.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Schedule Task 4 is running..");
                }
            }, 1500L, TimeUnit.MILLISECONDS);

            scheduledExecutor.scheduleAtFixedRate(new Runnable() {
                int count = 0;
                @Override
                public void run() {
                    System.out.println("\nRunning schedule at fixed rate..");
                    System.out.println("Time: " + count++);
                }
            }, 1, 2, TimeUnit.SECONDS);

            scheduledExecutor.scheduleWithFixedDelay(new Runnable() {
                int count = 0;
                @Override
                public void run() {
                    System.out.println("\nRunning schedule with fixed delay..");
                    System.out.println("Delayed Time: " + count++);
                }
            }, 1, 1, TimeUnit.SECONDS);


        }
        finally {
//            scheduledExecutor.shutdown();
        }
    }
}

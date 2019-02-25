package com.ttn.java.multithreading;

import java.util.concurrent.*;

/**
 * 6. Return a Future from ExecutorService by using callable and use get(), isDone(), isCancelled() with the Future
 *    object to know the status of task submitted.
 *
 */

public class Ques6_Future {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future;
        try{
             future = executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception{
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 10;
                }
            });
        }
        finally {
            executor.shutdown();
        }

        while(true){
            if(future.isDone()){
                try {
                    System.out.println("Returned value by future reference : " + future.get());
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("Not Done Yet.");
            }

            if(future.isCancelled()){
                System.out.println("Your Tasks has been Cancelled.");
            }else{
                System.out.println("Your Tasks are running.");
            }
        }

        System.out.println("Main Finished.");
    }
}

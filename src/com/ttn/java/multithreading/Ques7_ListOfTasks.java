package com.ttn.java.multithreading;

/**
 * 7. Submit List of tasks to ExecutorService and wait for the completion of all the tasks.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Ques7_ListOfTasks {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<Callable<String>> listOfTasks = new ArrayList<>();

        listOfTasks.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000L);
                return "Task 1";
            }
        });

        listOfTasks.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1500L);
                return "Task 2";
            }
        });

        listOfTasks.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2100L);
//                throw new Exception("Terminating Task 3");
                return "Task 3";
            }
        });

        listOfTasks.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(800L);
                return "Task 4";
            }
        });

        List<Future<String>> futureList;
        try{
            futureList = executor.invokeAll(listOfTasks);
        }
        finally{
            executor.shutdown();
        }

        executor.awaitTermination(2000L, TimeUnit.MILLISECONDS);

        for(Future<String> futureTask : futureList){
            System.out.println("Task: " + futureTask);
            if(futureTask.isCancelled()){
                System.out.println("Task " + futureTask + " has been Cancelled.");
            }
            if(futureTask.isDone()){
                try {
                    System.out.println(futureTask.get() + "\n");
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } catch (ExecutionException e1) {
                    e1.printStackTrace();
                }
            }
        }

        if(executor.isTerminated()){
            System.out.println("All Tasks Completed.");
        }else{
            System.out.println("One or more Tasks is still running..");
        }
    }
}

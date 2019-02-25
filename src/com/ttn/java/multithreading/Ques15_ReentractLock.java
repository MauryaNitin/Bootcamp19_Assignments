package com.ttn.java.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 15. Use Reentract lock for coordinating 2 threads with signal(), signalAll() and wait().
 */

class ReentractClass {
    Lock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();

    public void worker1() {
        System.out.println("Worker 1 started.");
        try {
            lock.lock();
            System.out.println("Worker 1 is incrementing...");
            condition.await();
        } catch (InterruptedException e) {
            System.out.println("Worker 1 waiting....");
        }finally {
            lock.unlock();
        }
        System.out.println("Worker 1 finished.");
    }

    public void worker2() {
        System.out.println("Worker 2 started.");
        try {
            lock.lock();
            System.out.println("Worker 2 is incrementing...");
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }

        System.out.println("Worker 2 finished.");
    }

    public void worker3() {
        System.out.println("Worker 3 started.");
        try {
            lock.lock();
            System.out.println("Worker 3 is incrementing...");
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
        System.out.println("Worker 3 finished.");
    }

    public void worker4() {
        System.out.println("Worker 4 started.");
        try{
            lock.lock();
            System.out.println("Worker 4 is incrementing...");
//            condition.signal();
          condition.signalAll();
        }
        finally {
            lock.unlock();
        }
        System.out.println("Worker 4 finished.");
    }
}

public class Ques15_ReentractLock {
    public static void main(String[] args) throws InterruptedException {
        ReentractClass reentractLock = new ReentractClass();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentractLock.worker1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentractLock.worker2();
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentractLock.worker3();
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentractLock.worker4();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println("Main Finished.");
    }
}

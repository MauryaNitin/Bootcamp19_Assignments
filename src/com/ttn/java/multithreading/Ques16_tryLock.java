package com.ttn.java.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 16. Create a deadlock and Resolve it using tryLock().
 */

class tryingDeadlock{
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    public void acquireLock(Lock lock1, Lock lock2){

        boolean acquireLock1 = lock1.tryLock();
        boolean acquireLock2 = lock2.tryLock();

        if(acquireLock1 && acquireLock2){
            return;
        }

        if(acquireLock1){
            lock1.unlock();
        }

        if(acquireLock2){
            lock2.unlock();
        }

    }

    // Uncomment for producing deadlock

//    public void worker1(){
//        lock1.lock();
//        System.out.println("worker 1 lock 1");
//        lock2.lock();
//        System.out.println("worker 1 lock 2");
//        lock2.unlock();
//        lock1.unlock();
//    }
//
//    public void worker2(){
//        lock2.lock();
//        System.out.println("worker 2 lock 2");
//        lock1.lock();
//        System.out.println("worker 2 lock 1");
//        lock1.unlock();
//        lock2.unlock();
//    }



    public void worker1(){
        acquireLock(lock1, lock2);
        System.out.println("worker 1 lock 1");
        System.out.println("worker 1 lock 2");
        lock2.unlock();
        lock1.unlock();
    }

    public void worker2(){
        acquireLock(lock2, lock1);
        System.out.println("worker 2 lock 2");
        System.out.println("worker 2 lock 1");
        lock1.unlock();
        lock2.unlock();
    }

}

public class Ques16_tryLock {
    public static void main(String[] args) throws InterruptedException {
        tryingDeadlock td = new tryingDeadlock();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                td.worker1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                td.worker2();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

    }
}

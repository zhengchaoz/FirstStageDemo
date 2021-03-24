package com.thread;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author
 * @date 2021-03-22-14:24
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        SaleTicketsV3 target = new SaleTicketsV3();
        Thread t1 = new Thread(target);
        Thread t2 = new Thread(target);
        Thread t3 = new Thread(target);
        Thread t4 = new Thread(target);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}

class SaleTicketsV3 implements Runnable {

    static int i = 100;

    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);

    @Override
    public void run() {
        while (true) {
            reentrantReadWriteLock.writeLock().lock();

            try {
                if (i > 0) {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "==" + i--);
                }
                if (i <= 0) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantReadWriteLock.writeLock().unlock();
            }
        }
    }

}

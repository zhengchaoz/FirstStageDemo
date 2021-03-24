package com.thread;

/**
 * @author
 * @date 2021-03-19-15:39
 */
public class RunnableDemo {

    public static void main(String[] args) {
//        Demo3 d1 = new Demo3();
//        Demo3 d2 = new Demo3();

        Thread thread = new Thread(() ->
                System.out.println(Thread.currentThread().getName() + "：我来啦。。。"));
        thread.setName("d1");

        Thread thread1 = new Thread(() ->
                System.out.println(Thread.currentThread().getName() + "：我来啦。。。"), "");
        thread1.setName("d2");

        thread.start();
        thread1.start();
    }

}

class Demo3 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：我来啦。。。");
    }

    public int add(int a, int b) {
        return a + b;
    }

}
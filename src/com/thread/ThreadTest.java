package com.thread;

/**
 * @author
 * @date 2021-03-19-14:36
 */
public class ThreadTest {

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        Demo1 demo1 = new Demo1(demo2);

        demo2.setName("demo2");
        demo1.setName("demo1");

        demo2.start();
        demo1.start();

//        Thread previousThread = Thread.currentThread();
//        for (int i = 0; i < 10; i++) {
//            JoinDemo joinDemo = new JoinDemo(previousThread, i);
//            joinDemo.start();
//            previousThread = joinDemo;
//        }
    }

}

class Demo1 extends Thread {

    Demo2 demo2;

    public Demo1(Demo2 demo2) {
        this.demo2 = demo2;
    }

    @Override
    public void run() {
        try {
            System.out.println(demo2.getName());
            demo2.join();
            System.out.println("1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(currentThread().getName() + "：我来啦。。。");
    }

}

class Demo2 extends Thread {

    @Override
    public void run() {

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(currentThread().getName() + "：我走啦。。。");
    }
}

class JoinDemo extends Thread {
    int i;
    Thread previousThread; //上一个线程

    public JoinDemo(Thread previousThread, int i) {
        this.previousThread = previousThread;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            //调用上一个线程的join方法，大家可以自己演示的时候可以把这行代码注释掉
            previousThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num:" + i);
    }
}
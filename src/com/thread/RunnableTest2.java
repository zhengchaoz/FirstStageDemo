package com.thread;

/**
 * @author
 * @date 2021-03-22-11:31
 */
public class RunnableTest2 {

    public static void main(String[] args) {
        Test test = new Test();

        Thread thread1 = new Thread(test);
        Thread thread2 = new Thread(test);

        thread1.setName("test1");
        thread2.setName("test2");

        thread1.start();
        thread2.start();
    }

}


class Test implements Runnable {

    @Override
    public void run() {
        synchronized (Test.class) {
            System.out.println(Thread.currentThread().getName() + "哈哈哈");
        }
    }

}
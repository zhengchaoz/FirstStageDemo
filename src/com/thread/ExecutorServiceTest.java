package com.thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author
 * @date 2021-03-22-11:48
 */
public class ExecutorServiceTest {

    public static void main(String[] args) {
        Test test = new Test();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            service.execute(test);
            service.submit(test);
        }
    }

    @org.junit.Test
    public void service() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        TaskRunnable task = new TaskRunnable();
//        executorService.submit(task);
//        System.out.println("----------------");
//        executorService.submit(task);

        executorService.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("自定义线程" + Thread.currentThread().getName() + ": " + i);
            }
        });

//        executorService.submit(System.out::println);
        executorService.submit(() -> System.out.println("自定义线程"));
        executorService.shutdown();
    }

    @org.junit.Test
    public void CallService() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        MyCallable callable = new MyCallable(100, 200);
        MyCallable myCallable = new MyCallable(10, 20);

        Future<Integer> future = service.submit(callable);
        Integer sum = future.get();
        System.out.println(sum);

        future = service.submit(myCallable);
        sum = future.get();
        System.out.println(sum);

        service.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                return 1 + 1;
            }
        });

        service.submit(() -> 1 + 1);

//        service.submit(System.out::println(1+1));
    }

    @org.junit.Test
    public void completableFuture() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
    }

}

class TaskRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("自定义线程" + Thread.currentThread().getName() + ": " + i);
        }
    }
}

class MyCallable implements Callable<Integer> {

    int x = 5;
    int y = 3;

    public MyCallable() {

    }

    public MyCallable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {
        return x + y;
    }
}

class RunnableImpl implements Runnable {

    private int ticket = 100;

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();

            if (ticket > 0) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "：正在买票" + ticket--);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                }
            }

            lock.unlock();
        }
    }
}

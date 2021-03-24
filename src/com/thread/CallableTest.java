package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author
 * @date 2021-03-19-16:17
 */
public class CallableTest {

    public static void main(String[] args) {
        Demo4 d1 = new Demo4();
        FutureTask<String> futureTask = new FutureTask<>(d1);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        new Thread(new FutureTask<>(() -> "")).start();
    }

}

class Demo4 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "我来啦";
    }
}

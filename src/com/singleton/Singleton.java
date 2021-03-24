package com.singleton;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author
 * @date 2021-03-22-15:11
 */
public class Singleton {

    public static void main(String[] args) {
        //饿汉式
//        EagerSingleton eager = EagerSingleton.getSingleton();
//        EagerSingleton eager1 = EagerSingleton.getSingleton();
//        System.out.println(eager == eager1);
        //懒汉式
//        LazySingleton lazy = LazySingleton.getSingleton();
//        LazySingleton lazy1 = LazySingleton.getSingleton();
//        System.out.println(lazy == lazy1);
        //多线程懒汉式
        GetLockSingleton lock = new GetLockSingleton();
        //有返回值的线程Callable
        FutureTask<LockSingleton> futureTask = new FutureTask<>(lock);
        Thread thread = new Thread(futureTask);

        FutureTask<LockSingleton> futureTask1 = new FutureTask<>(lock);
        Thread thread1 = new Thread(futureTask1);

        thread.setName("0001");
        thread1.setName("0002");

        thread.start();
        thread1.start();

        try {
            System.out.println(futureTask.get() == futureTask1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        System.out.println(EnumSingleton.singleton == EnumSingleton.singleton1);
    }

}

class EagerSingleton {

    private static EagerSingleton singleton = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getSingleton() {
        return singleton;
    }

}

class LazySingleton {

    private static LazySingleton singleton;

    private LazySingleton() {
    }

    public static LazySingleton getSingleton() {
        if (singleton == null)
            singleton = new LazySingleton();

        return singleton;
    }

}

class LockSingleton {

    private static LockSingleton singleton;

    private LockSingleton() {
    }

    public static LockSingleton getSingleton() {
        if (singleton != null) {
//            synchronized (singleton) {
            synchronized (LockSingleton.class) {
                if (singleton == null)
                    singleton = new LockSingleton();
            }
        }

        return singleton;
    }

}

class GetLockSingleton implements Callable<LockSingleton> {


    @Override
    public LockSingleton call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "：我得到啦！");
        return LockSingleton.getSingleton();
    }

}

enum EnumSingleton {

    singleton,
    singleton1

}

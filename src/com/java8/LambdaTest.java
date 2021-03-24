package com.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author
 * @date 2021-03-21-15:20
 */
public class LambdaTest {

    public static void main(String[] args) {
        //lambda写法：->
        Runnable runnable = () -> System.out.println("啦啦啦");
        runnable.run();
        //方法引用写法： ::
        Comparator<Integer> comparator = Integer::compareTo;
        System.out.println(comparator.compare(33, 10));
    }

    //无参数无返回值
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("1111");
            }
        };

        Runnable r = () -> {
            System.out.println("1111");
        };
    }

    //一个参数无返回值
    @Test
    public void test2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("sad");
            }
        };

        Consumer<String> c = (String s) -> {
            System.out.println("sadasd");
        };
    }

    //省略参数类型(泛型)，称作“类型推断”
    @Test
    public void test3() {
        Consumer<String> c = (s) -> {
            System.out.println("sadasd");
        };
        ArrayList<String> list = new ArrayList<>();
        int[] i = {1, 2, 3};
    }

    //一个参数时省略括号
    @Test
    public void test4() {
        Consumer<String> c = s -> {
            System.out.println("sadasd");
        };
    }

    //多个参数，多条执行语句，有返回值
    @Test
    public void test5() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };

        Comparator<Integer> c = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
    }

    //一条执行语句，括号&return可以省略
    @Test
    public void test6() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        Comparator<Integer> c = (o1, o2) -> o1.compareTo(o2);
    }

}

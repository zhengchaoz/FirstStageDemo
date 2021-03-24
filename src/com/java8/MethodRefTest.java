package com.java8;

import com.reflect.entity.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用
 *
 * 对象 :: 非静态
 * 类  ::  静态
 *
 * 特殊：类  ::  非静态
 *
 *
 * @author
 * @date 2021-03-21-17:08
 */
public class MethodRefTest {

    @Test
    public void test1() {
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("郑超");

        Consumer<String> stringConsumer = System.out::println;
    }

    @Test
    public void test2() {
        Person person = new Person();
        person.setName("郑超");
        Supplier<String> supplier = () -> person.getName();

        Supplier<String> stringSupplier = person::getName;
        System.out.println(stringSupplier.get());
    }

    @Test
    public void test3() {
        Comparator<Integer> comparator = (o1, o2) -> o1.compareTo(o2);

        Comparator<Integer> c = Integer::compare;
        Comparator<Integer> cp = Integer::compareTo;
    }

    @Test
    public void test4() {
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);

        Comparator<String> stringComparator = String::compareTo;
    }

}

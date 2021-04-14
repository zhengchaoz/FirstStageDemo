package com.java8.stream;

import com.serializable.demo.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @user 郑超
 * @date 2021/4/13
 */
public class StreamInitTest {

    private final List<String> strings = new ArrayList<>();

    @Before
    public void testData() {
        strings.add("aaa");
        strings.add("bbb");
        strings.add("ccc");
        strings.add("sss");
        strings.add("ggg");
        strings.add("hhh");
    }

    @Test
    public void testCollectionInit() {
        Stream<String> stream = strings.stream();// 顺序流
        Stream<String> parallelStream = strings.parallelStream();// 并行流
    }

    @Test
    public void testArraysInit() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(array);

        Student[] sstudent = new Student[]{new Student(), new Student()};
        Stream<Student> stream1 = Arrays.stream(sstudent);
    }

    @Test
    public void testOf() {
        Stream<Integer> stream = Stream.of(12, 34, 45, 56);
    }

    @Test
    public void test() {
        // 迭代：输出10个偶数，limit限定个数，forEach输出
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        // 生成：输出10个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}

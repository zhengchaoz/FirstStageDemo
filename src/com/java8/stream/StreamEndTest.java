package com.java8.stream;

import com.serializable.demo.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @user 郑超
 * @date 2021/4/13
 */
public class StreamEndTest {

    private final List<Student> students = new ArrayList<>();

    @Before
    public void testData() {
        students.add(new Student("郑超", 12, 0));
        students.add(new Student("张三丰", 620, 0));
        students.add(new Student("李清照", 16, 1));
        students.add(new Student("大古", 20, 0));
    }

    // 匹配和查找
    @Test
    public void test1(){
        // allMatch：所有元素都匹配条件时才返回true
//        boolean allMatch = students.stream().allMatch(s -> s.getAge() > 18);
        // anyMatch：只要有一个元素匹配条件就返回true
//        boolean anyMatch = students.stream().anyMatch(s -> s.getSex() == 1);
        // noneMatch：都不匹配才返回true
//        System.out.println(students.stream().noneMatch(s -> s.getName().contains("会")));
        // findFirst：返回第一个元素
//        System.out.println(students.stream().findFirst());
        // findAny：返回任意元素，配合parallelStream使用（并行流） （stream：顺序流，会记录元素的顺序）
//        System.out.println(students.parallelStream().findAny());
        // count：返回总数
//        System.out.println(students.stream().filter(s -> s.getSex() == 0).count());
        // max：返回最大值
//        System.out.println(students.stream().max(Comparator.comparingInt(Student::getAge)));
        // min：返回最小值
        System.out.println(students.stream().min(Comparator.comparingInt(Student::getAge)));
        // stream().forEach() 内部迭代 collection forEach() 外部迭代
    }

    // 归约
    @Test
    public void test2(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // reduce：可以将流中的元素反复结合起来，例如计算1-10的自然数之和（0是初始值）
//        System.out.println(integers.stream().reduce(0, Integer::sum));

        System.out.println(students.stream().map(Student::getAge).reduce(Integer::sum));
    }

    // 收集
    @Test
    public void test3(){
        // collect：将流转换为其他形式，接受一个Collector接口的实现
        System.out.println(students.stream().filter(s -> s.getSex() == 0).collect(Collectors.toList()));
        System.out.println(students.stream().filter(s -> s.getSex() == 0).collect(Collectors.toSet()));
    }

}

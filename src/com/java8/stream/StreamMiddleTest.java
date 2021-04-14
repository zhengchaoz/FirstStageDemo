package com.java8.stream;

import com.serializable.demo.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @user 郑超
 * @date 2021/4/13
 */
public class StreamMiddleTest {

    private final List<String> strings = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();

    @Before
    public void testData() {
        strings.add("ccc");
        strings.add("sss");
        strings.add("sss");
        strings.add("bbb");
        strings.add("sss");
        strings.add("aaa");

        students.add(new Student("郑超", 24, 0));
        students.add(new Student("张三丰", 620, 0));
        students.add(new Student("李清照", 1026, 1));
        students.add(new Student("大古", 20, 0));
    }

    // 筛选与切片
    @Test
    public void test1() {
        // filter：接收条件，按条件筛选数据
//        strings.stream().filter(s -> !s.equals("sss")).forEach(System.out::println);
        // limit：截断流，使元素不超过指定个数
//        strings.stream().limit(4).forEach(System.out::println);
        // skip：跳过指定元素个数
//        strings.stream().skip(2).forEach(System.out::println);
        // distinct：自动去重，通过元素的hashCode()和equals()方法
        strings.stream().distinct().forEach(System.out::println);
    }

    // 映射
    @Test
    public void test2() {
        // map：可以对每个元素做相应的操作，然后返回一个新的。
//        strings.stream().map(String::toUpperCase).forEach(System.out::println);
        // 获取名称长度大于3的姓名
//        students.stream().map(Student::getName).filter(str -> str.length() > 2).forEach(System.out::println);
        // flatMap
//        Stream<Stream<Character>> streamStream = strings.stream().map(StreamMiddleTest::getChars);
//        streamStream.forEach(s -> {
//            s.forEach(System.out::println);
//        });

        strings.stream().flatMap(StreamMiddleTest::getChars).forEach(System.out::println);

        // 区别：map()相当于add()，传入元素是Stream时将它当成一个元素
        // flatMap()相当于addAll()，传入元素是Stream时将它当成一个流，和现有流合并
    }

    private static Stream<Character> getChars(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }

        return list.stream();
    }

    //排序
    @Test
    public void testSort() {
        // 自然排序
//        strings.stream().sorted().forEach(System.out::println);
        // 定制排序
        strings.stream().sorted((s1, s2) -> -s1.compareTo(s2)).forEach(System.out::println);
    }

}

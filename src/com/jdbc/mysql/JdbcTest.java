package com.jdbc.mysql;

import com.serializable.demo.Student;
import org.junit.Test;

import java.util.*;

/**
 * @author
 * @date 2021-03-13-15:52
 */
public class JdbcTest {

    @Test
    public void testIterator() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        // hasNext():判断是否还有下一个元素
        while (iterator.hasNext()) {
//            iterator.remove();不能在还未调用next()之前使用
            // next():①指针下移 ②将移以后集合位置上的元素返回
            Integer integer = iterator.next();
            System.out.println(integer);
            iterator.remove();
//            iterator.remove();不能在调用next()之后重复使用
        }

        System.out.println(list.size());// list长度为 0
    }

    @Test
    public void testForeach() {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        for (Integer integer : list) {
//            System.out.println(integer);//输出：1 / 2 / 3
//            integer = 10;
//        }
//
//        System.out.println(Arrays.toString(list.toArray()));//输出：1 / 2 / 3


        List<Student> list = new ArrayList<>();
        list.add(new Student("a", 12, 0));
        list.add(new Student("a", 23, 1));
        list.add(new Student("a", 56, 0));

        for (Student s : list) {
            System.out.println(s.getAge());//输出：12 / 23 / 56
            s.setAge(100);
        }

        for (Student s : list) {
            System.out.println(s.getAge());//输出：100 / 100 / 100
        }
    }

    @Test
    public void testListIterator() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        // 从指定索引位置（list.size()）开始遍历
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {// 判断上一个元素是否存在
            Integer integer = listIterator.previous();// 指针上移，获取上一个元素
            System.out.println(integer);
            if (integer == 1) {
                listIterator.add(50);// 添加元素
            } else {
                listIterator.set(10);// 修改元素的值
            }
        }

        System.out.println(Arrays.toString(list.toArray()));//输出：[10, 1, 10, 10, 10, 10]
    }

    @Test
    public void testTreeMap() {
        TreeMap<Student, Integer> treeMap = new TreeMap<>();
        treeMap.put(new Student("a", 34, 0), 1);
        treeMap.put(new Student("a", 24, 1), 2);
        treeMap.put(new Student("a", 56, 0), 3);

        for (Student student : treeMap.keySet()) {
            System.out.println(student.toString());
        }
//        Student{name='a', age=24, sex=1}
//        Student{name='a', age=34, sex=0}
//        Student{name='a', age=56, sex=0}

        TreeMap<Student, Integer> treeMap1 = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        treeMap1.put(new Student("a", 34, 0), 1);
        treeMap1.put(new Student("a", 24, 1), 2);
        treeMap1.put(new Student("a", 56, 0), 3);

        for (Student student : treeMap1.keySet()) {
            System.out.println(student.toString());
        }
//        Student{name='a', age=56, sex=0}
//        Student{name='a', age=34, sex=0}
//        Student{name='a', age=24, sex=1}
    }

}

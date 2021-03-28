package com.collection.list;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author
 * @date 2021-03-18-14:14
 */
public class SetDemo {

    @Test
    public void test() {
        Set<String> set = new HashSet();
        set.add("发发发");
        set.add("但事实上");
        set.add("但事实上");
        set.add("但事实上");
        set.add("呃呃呃");
        set.add("胜多负少");
        set.add("胜多负少");
        set.add(null);
        set.add("null");
        System.out.println(set);

//        set.clear();
//        System.out.println(set);

        System.out.println(set.contains("发发发"));
        System.out.println(set.equals("ee"));
        System.out.println(set.hashCode());
        System.out.println(set.isEmpty());
        System.out.println(set.toArray());
    }

    @Test
    public void test2() {
        Set<String> set = new HashSet();
        set.add("发发发");
        set.add("但事实上");
        set.add("但事实上");
        set.add("但事实上");
        set.add("呃呃呃");

        Set<String> strings = new HashSet<>();
        strings.add("嘻嘻嘻");
        strings.add("嘻敖德萨多嘻嘻");
        strings.add("嘻嘻嘻sad");
        strings.add("嘻分隔符嘻嘻");
        strings.add("嘻二恶烷若无嘻嘻");
        strings.addAll(set);
//        System.out.println(strings.containsAll(set));
//        System.out.println(strings.removeAll(set));
//        System.out.println(strings.retainAll(set));
//        System.out.println(strings);

        Iterator iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3() {
//        Set<Student<Integer>> students = new HashSet<>();
    }

}

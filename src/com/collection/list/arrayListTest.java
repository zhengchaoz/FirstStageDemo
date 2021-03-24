package com.collection.list;

import org.junit.Test;

import java.util.*;

/**
 * @Author
 * @date 2021-03-17-14:10
 */
public class arrayListTest {

    @Test
    public void test() {
        ArrayList list = new ArrayList();

        EnumerationIterator ei = (EnumerationIterator) list.iterator();

        Map map = new Hashtable();

        Collection collection = new ArrayList();
        collection.add(1212);

        System.out.println(collection.hashCode());
        System.out.println(collection.isEmpty());

        Collections.sort(list);


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for (Object o : list) {
            System.out.println(o);
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(o);
            iterator.remove();//不能在next()之前，不能连续调用两次
        }
        ListIterator li = list.listIterator();
        while (li.hasNext()) {
            Object o = li.next();
            System.out.println(o);
            li.nextIndex();
            li.add(new Object());
            li.hasPrevious();
            li.previous();
            li.previousIndex();
            li.set(new Object());
        }
    }

    @Test
    public void test2() {
        int m = 5;
        int n = 2;
//        n = m^n^n;
//        m = n^m^m;
        m = n^m;
        n = n^m;
        m = n^m;
        System.out.println(m);
        System.out.println(n);
    }

}

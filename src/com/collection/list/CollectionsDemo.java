package com.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author
 * @date 2021-03-18-10:10
 */
public class CollectionsDemo {

    @Test
    public void test() {

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(12);
        list3.add(12);
        list3.add(45);
        list3.add(45);

        LinkedList list = new LinkedList();
        list.get(0);
        list.element();
        list.peek();
        list.peekFirst();
        list.peekLast();
        list.add("");
        list.offer("");


//        list3.remove(Integer.valueOf(12));
//        System.out.println(list3);
//        list3.set(0, 56);

//        Collections.swap(list3, 0, 1);
//        System.out.println(list3);

//        System.out.println(Collections.max(list3));

        System.out.println(Collections.frequency(list3, 45));
    }

}

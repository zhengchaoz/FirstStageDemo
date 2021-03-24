package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author
 * @date 2021-03-16-8:59
 */
public class test {

    public static void main(String[] args) {
        List<? super Father> list = new LinkedList<Human>();
//        list.add(new Son());
    }

//    public <T> i(List<? super T> list) {
//        List<? super T> list1 = new ArrayList<>();
//        return t;
//    }

}

class Human{
}
class Father extends Human{
}
class Son extends Father{
}
class LeiFeng extends Father {
}

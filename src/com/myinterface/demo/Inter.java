package com.myinterface.demo;

import com.demo.day01.HelloWorld;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 接口测试
 *
 * @author
 * @date 2021-03-11-10:15
 */
public class Inter extends abDemo implements InterDemo {

    public static void main(String[] args) {
        ConcurrentHashMap hashMap = new ConcurrentHashMap();

        String s = "";
        Long sl = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s += i;
        }
        Long sl2 = System.currentTimeMillis();
        System.out.println(sl2 - sl);

        StringBuffer sbf = new StringBuffer();
        Long sbfl = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sbf.append(i);
        }
        Long sbfl2 = System.currentTimeMillis();
        System.out.println(sbfl2 - sbfl);

        StringBuilder sbd = new StringBuilder();
        Long sbdl = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sbd.append(i);
        }
        Long sbdl2 = System.currentTimeMillis();
        System.out.println(sbdl2 - sbdl);

//        InterDemo ab = new Inter();
//        ab.getI();
//        ab.getStr();
//
//        InterDemo.overStatic();
//        new InterDemo() {
//
//            @Override
//            public void getStr() {
//
//            }
//
//            @Override
//            public void getI() {
//
//            }
//        }.getStr();
//
//        String s = ab.str;
    }

    @Override
    public void getStr() {
        abDemo abDemo = new Inter();
        System.out.println(abDemo.str);
    }

    @Override
    public void getI() {
//        InterDemo.super.overDefault();
        System.out.println(InterDemo.i);
    }
}

interface InterDemo /*extends List, Map*/ {

    public static final String str = "a";
    public static final int i = 1;

    public abstract void getStr();

    public abstract void getI();

    public static void overStatic() {
        System.out.println("接口静态方法");
    }

    public default void overDefault() {
        System.out.println("接口默认方法");
    }

}

abstract class abDemo implements InterDemo {

    String str = "g";
    int i = 10;

    public abstract void getStr();

    public abstract void getI();

    public static void overStatic() {
        System.out.println("抽象类静态方法");
    }

    public void overDefault() {
        System.out.println("抽象类默认方法");
    }

}



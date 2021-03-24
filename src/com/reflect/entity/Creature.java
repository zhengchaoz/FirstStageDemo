package com.reflect.entity;

import java.io.Serializable;

/**
 * @author
 * @date 2021-03-20-21:04
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double weight;

    private void breath() {
        System.out.println("呼吸");
    }

    public void eat() {
        System.out.println("吃");
    }

}

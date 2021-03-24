package com.java8;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author
 * @date 2021-03-21-19:20
 */
public class ArrayRefTest {

    @Test
    public void test1() {
        Function<Integer, String[]> function = length -> new String[length];
        Function<Integer, String[]> function1 = String[]::new;
    }

}

package com.demo.day01;

public class HelloWorld {

    public static void main(String[] args) {
//        System.out.println("你好！");

        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > 0; j--) {
                if (j > i) {
                    System.out.print("*");
                }
            }
            for (int j = 5; j > 0; j--) {
                if (j < i) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

}

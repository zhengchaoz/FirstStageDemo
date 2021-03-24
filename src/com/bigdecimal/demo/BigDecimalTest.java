package com.bigdecimal.demo;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author
 * @date 2021-03-15-10:53
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入double：");
        Double d = scanner.nextDouble();
        BigDecimal bd = new BigDecimal(String.valueOf(d));
        System.out.println(bd);
        scanner.close();
        //add()加法、subtract()减法、multiply()乘法、divide()除法

//        double  d =  301353.0499999999883584678173065185546875d;
//        System.out.println(String.valueOf(d));
//        System.out.println( new  java.math.BigDecimal(d));
    }

}

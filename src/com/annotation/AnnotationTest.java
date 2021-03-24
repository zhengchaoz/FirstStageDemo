package com.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.METHOD;

/**
 * @author
 * @date 2021-03-23-10:33
 */
public class AnnotationTest {

    @test(age = 16, value = "狗子")
    public static void main(String[] args) {
        System.out.println("有吗");
    }

}

@Target({TYPE, METHOD, FIELD, CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@interface test {

    int age() default 24;

    String value() default "哈哈";

}

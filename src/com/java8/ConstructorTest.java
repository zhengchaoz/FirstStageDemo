package com.java8;

import com.reflect.entity.Person;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用
 *
 * @author
 * @date 2021-03-21-19:09
 */
public class ConstructorTest {

    @Test
    public void test1() {
        Supplier<String> supplier = () -> new String();
        Supplier<String> stringSupplier = String::new;
    }

    @Test
    public void test2(){
        Function<String, Person> function = (str) -> new Person(str);
        Function<String, Person> function1 = Person::new;
    }

}

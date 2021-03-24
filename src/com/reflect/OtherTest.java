package com.reflect;

import com.reflect.entity.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author
 * @date 2021-03-21-9:44
 */
public class OtherTest {

    @Test
    public void getConstructors() {
        Class<Person> personClass = Person.class;
        Constructor[] constructor = personClass.getConstructors();
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();
    }

    @Test
    public void superClass() {
        Class<Person> aClass = Person.class;
        Class<? super Person> superclass = aClass.getSuperclass();
        System.out.println(superclass);

        Type genericSuperclass = aClass.getGenericSuperclass();
        System.out.println(genericSuperclass);

        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());
    }

    @Test
    public void getInterface() {
        Class<Person> personClass = Person.class;
        Class<?>[] interfaces = personClass.getInterfaces();
        Class<?>[] interfaces1 = personClass.getSuperclass().getInterfaces();
    }

    @Test
    public void getPackage() {
        Class<Person> personClass = Person.class;
        Package aPackage = personClass.getPackage();
    }

    @Test
    public void getAnnotations() {
        Class<Person> personClass = Person.class;
        Annotation[] annotations = personClass.getAnnotations();
    }

}

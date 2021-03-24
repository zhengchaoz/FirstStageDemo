package com.reflect;

import com.serializable.demo.Student;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class ReflectDemo {

    @Test
    public void getConstructor() {
        Class<?> clazz = Student.class;
        Constructor<?>[] con = clazz.getConstructors();
        for (Constructor c : con) {
            System.out.println(c.getName());
            Class[] parameters = c.getParameterTypes();
            System.out.println(Arrays.toString(parameters));
        }
    }

    @Test
    public void getFunction() throws ClassNotFoundException {
        Class<?> name = Class.forName("com.serializable.demo.Student");
        System.out.println(name);

        Method[] methods = name.getMethods();
        for (Method m : methods) {
            System.out.print(m.getName());
            Class[] parameters = m.getParameterTypes();
            System.out.println("\t" + Arrays.toString(parameters) + "\n");
        }
    }

    @Test
    public void getFields() {
        Class<? extends Student> aClass = new Student().getClass();
        Field[] field = aClass.getDeclaredFields();
        for (Field f : field) {
            f.setAccessible(true);
            System.out.print(f.getName() + "\t");
            System.out.println(f.getType().getName());
        }
    }

    @Test
    public void createObj() throws Exception {
        Class<Student> aClass = Student.class;

        Student student = aClass.newInstance();
        System.out.println(student);

        Constructor<Student> constructor = aClass.getConstructor(String.class, int.class, int.class);
        Student instance = constructor.newInstance("张三", 34, 1);
        System.out.println(instance);

        Field age = aClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(student, 12);

        System.out.println(age.getInt(student));
    }

}

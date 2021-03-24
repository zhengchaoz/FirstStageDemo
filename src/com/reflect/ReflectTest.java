package com.reflect;

import com.serializable.demo.Student;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * @author
 * @date 2021-03-20-16:47
 */
public class ReflectTest {

    @Test
    public void reflect() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class sClass = Student.class;
        Constructor constructor = sClass.getConstructor(String.class, int.class, int.class);
        Object o = constructor.newInstance("张三", 17, 0);
        Student student = (Student) o;
        System.out.println(student.toString());

    }

    @Test
    public void init() throws ClassNotFoundException {
//        Class clazz = String.class;
//        System.out.println(clazz);
//        Class clazz1 = new String().getClass();
//        System.out.println(clazz1);
        Class clazz2 = Class.forName("java.lang.String");
        System.out.println(clazz2);
//        ClassLoader cl = ReflectTest.class.getClassLoader();
//        Class aClass = cl.loadClass("java.lang.String");
//        System.out.println(aClass);
    }

    @Test
    public void loader() {
        ClassLoader cl = ReflectTest.class.getClassLoader();//系统类加载器(自定义类)
        System.out.println(cl);
        ClassLoader classLoader = cl.getParent();//扩展类加载器
        System.out.println(classLoader);
        ClassLoader classLoader1 = classLoader.getParent();//引导类加载器(不能用)
        System.out.println(classLoader1);

        System.out.println(Integer.class.getClassLoader());
    }

    @Test
    public void properties() throws IOException {
        Properties properties = new Properties();
//        FileInputStream fos = new FileInputStream("jdbc.properties");
//        properties.load(fos);
        //类加载器默认地址在src下
        ClassLoader cl = ReflectTest.class.getClassLoader();
        InputStream is = cl.getResourceAsStream("jdbc1.properties");
        properties.load(is);

        System.out.println(properties.getProperty("user"));
        System.out.println(properties.getProperty("age"));
//        fos.close();
    }

}

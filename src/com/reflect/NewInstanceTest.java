package com.reflect;

import com.serializable.demo.Student;
import org.junit.Test;

/**
 * @author
 * @date 2021-03-20-20:19
 */
public class NewInstanceTest {

    @Test
    public void newInstance() throws IllegalAccessException, InstantiationException {
        Class<Student> clazz = Student.class;
        /**
         * 使用newInstance()方法有两点要求：
         * 1.提供无参构造器 --> InstantiationException
         * 2.无参构造器的权限要足够，通常为public --> IllegalAccessException
         */
        Student student = clazz.newInstance();
        System.out.println(student);
    }

    //反射的动态性
    public Object getInstance(String path) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class aClass = Class.forName(path);
        return aClass.newInstance();
    }

}

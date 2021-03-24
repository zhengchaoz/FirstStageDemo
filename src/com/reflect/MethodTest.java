package com.reflect;

import com.reflect.entity.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author
 * @date 2021-03-21-9:06
 */
public class MethodTest {

    @Test
    public void getMethods() {
        Class<Person> aClass = Person.class;
        //运行时类+父类 public方法
        Method[] methods = aClass.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        //运行时类所有方法
        Method[] methods1 = aClass.getDeclaredMethods();
        for (Method m : methods1) {
            System.out.println(m);
        }
    }


    @Test
    public void getMethodInfo() {
        Class<Person> aClass = Person.class;
        Method[] methods = aClass.getMethods();
        for (Method m : methods) {
            Annotation[] annotations = m.getAnnotations();//所有注解
            Modifier.toString(m.getModifiers());//访问修饰符
            Class<?> returnType = m.getReturnType();//返回值类型
            Class<?>[] parameterTypes = m.getParameterTypes();//所有形参
            Class<?>[] exceptionTypes = m.getExceptionTypes();//所有异常
        }
    }

    @Test
    public void getMethod() throws Exception {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();

        Method method = personClass.getDeclaredMethod("", String.class);
        method.setAccessible(true);
        Object o = method.invoke(person, "");

        Object invoke = method.invoke(Person.class, "");
        Object invoke1 = method.invoke(null, "");
    }

}

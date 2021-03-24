package com.reflect;

import com.reflect.entity.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author
 * @date 2021-03-20-21:18
 */
public class FieldTest {

    @Test
    public void getFields() {
        Class<Person> clazz = Person.class;
        //运行时类+父类的public变量
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        //运行时类的所有变量
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field f : fields1) {
            System.out.println(f);
        }
    }

    @Test
    public void getFieldInfo() {
        Class<Person> clazz = Person.class;
        Field[] field = clazz.getFields();
        for (Field f : field) {
            int modifier = f.getModifiers();//修饰符
            System.out.print(Modifier.toString(modifier));
            Class c = f.getType();//类型
            System.out.print(c.getName());
            String str = f.getName();//变量名
            System.out.println(str);
        }
    }

    @Test
    public void getField() throws Exception {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();

        Field id = personClass.getField("id");
        id.set(person, 12);
        id.get(person);

        Field id1 = personClass.getDeclaredField("id");
        id1.setAccessible(true);
        id1.set(person, 10);
        id1.get(person);
    }

}

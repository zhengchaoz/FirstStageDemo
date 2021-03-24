package com.serializable.demo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author
 * @date 2021-03-17-9:38
 */
public class Student<T> implements Serializable {

    private static final long serialVersionUID = 1517969386166628546L;
    private String name;
    private int age;
    private int sex;
    private T score;


    public Student() {
    }

    public Student(Student<T> t) {
    }

    public T demo(T t) {
        return t;
    }

    public <E> E demo2(E e) {
        return e;
    }

    public <E> Student<E> demo1(Student<E> e) {
        return e;
    }

    public Student(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && sex == student.sex && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}

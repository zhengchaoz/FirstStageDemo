package com.serializable.demo;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author
 * @date 2021-03-17-9:48
 */
public class SerializableTest {

    @Test
    public void test1() {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            File fileIn = new File("e:\\test.txt");
            File fileOut = new File("e:\\test.txt");
            ois = new ObjectInputStream(new FileInputStream(fileIn));
            oos = new ObjectOutputStream(new FileOutputStream(fileOut));
            oos.writeObject(new Student("赵钱孙李", 22, 0));
            Student stu = (Student) ois.readObject();
            System.out.println(stu);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2() {

    }

}

package com.io.objectStream;

import org.junit.Test;

import java.io.*;

/**
 * 对象流
 *
 * @author
 * @date 2021-03-18-20:02
 */
public class ObjectInputOutputStreamTest {

    @Test
    public void test() {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));
            oos.writeObject("你好，郑超！");
            oos.flush();

            ois = new ObjectInputStream(new FileInputStream("Object.dat"));
            Object o = ois.readObject();
            System.out.println(String.valueOf(o));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

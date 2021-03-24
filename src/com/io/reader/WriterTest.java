package com.io.reader;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author
 * @date 2021-03-16-14:31
 */
public class WriterTest {

    @Test
    public void fileWriter() {
        Writer writer = null;
        try {
            // append为true输出内容从文件末未开始追加
            writer = new FileWriter(("e:" + File.separator + "test2.txt"), true);
            // 默认为false，输出内容从文件开头写入，会覆盖
//            writer = new FileWriter(("e:" + File.separator + "test2.txt"));
            writer.write("郑超啦啦啦");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void bufferedWriter() {
        Writer writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(("e:" + File.separator + "test2.txt"), true));
//            writer = new BufferedWriter(new FileWriter(("e:" + File.separator + "test2.txt")));
            writer.write("追加啊啊啊啊啊啊啊啊啊");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

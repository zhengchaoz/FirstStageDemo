package com.io.stream;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author
 * @date 2021-03-15-16:44
 */
public class StreamTest {

    /**
     * 字节流读取 FileInputStream
     */
    @Test
    public void fileInputStream() {
        InputStream fis = null;
        try {
            fis = new FileInputStream(("e:\\test.txt"));
//            int read = fis.read();
            int i = 0;
            while ((i = fis.read()) != -1) {
                System.out.println(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 字节流读取（缓存） BufferedInputStream
     */
    @Test
    public void bufferedInputStream() {
        InputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(("e:" + File.separator + "test.txt")));
            int result = 0;
            while ((result = bis.read()) != -1) {
                System.out.print((char) result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 自定义Java.io装饰模式中的装饰者，LowerCaseInputStream：将大写转换成小写
     */
    @Test
    public void lowerCaseInputStream() {
        InputStream inputStream = null;
        try {
            inputStream = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(("e:" + File.separator + "test.txt"))));
            int result = 0;
            while ((result = inputStream.read()) != -1) {
                System.out.print((char) result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void outputStream() {
        OutputStream outputStream = null;
        try {
            // append为true输出内容从文件末未开始追加
            outputStream = new FileOutputStream("e:" + File.separator + "test2.txt", true);
            // 默认为false，输出内容从文件开头写入，会覆盖
//            outputStream = new FileOutputStream("e:" + File.separator + "test2.txt");
            outputStream.write("郑超".getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 此输出是覆盖模式，即每次输出都会覆盖文件原来内容
     * 还有追加模式，即每次输出都是在文件原来内容的后面
     */
    @Test
    public void bufferedOutputStream() {
        OutputStream o = null;
        try {
            o = new BufferedOutputStream(new FileOutputStream(("e:" + File.separator + "test2.txt")));
            o.write("郑超哈哈".getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (o != null) {
                try {
                    o.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    * 字节流：inputStream outputStream
    * 字符流：reader writer
    * 文件字节输出：FileOutputStream
    * 文件字节输入：FileInputStream
    * 文件字符输出：FileWriter
    * 文件字符输入：FileReader
    * 缓存字节输入：BufferedInputStream
    * 缓存字节输出：BufferedOutputStream
    * 缓存字符输入：BufferedReader
    * 缓存字符输出：BufferedWriter
    * */

}

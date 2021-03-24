package com.io.reader;

import org.junit.Test;

import java.io.*;

/**
 * @author
 * @date 2021-03-16-9:34
 */
public class ReaderTest {

    @Test
    public void fileReader() {
        Reader reader = null;
        try {
            reader = new FileReader(("e:" + File.separator + "test.txt"));
            //每次从文件取出一个char字符存入内存
//            int read = 0;//存着具体字符的编码值
//            while ((read = reader.read()) != -1) {
//                System.out.println((char)read);
//            }
            //每次从文件中取出char[]个字符存入内存
            char[] reads = new char[5];//存着具体字符的编码值数组
            int read;//表示一次取出字符的个数
            while ((read = reader.read(reads)) != -1) {
                for (int i = 0; i < read; i++) {
                    System.out.println(reads[i]);
                }
                System.out.println(new String(reads, 0, read));
                //错误方式：每次向char[]填充5个字符，若最后一次读取不足5个，就只会修改数组中相应的读取个数
//                for (int i = 0; i < reads.length; i++) {
//                    System.out.println(reads[i]);
//                }
//                System.out.println(new String(reads));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void bufferedReader(){
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(("e:" + File.separator + "test.txt")));
            writer = new BufferedWriter(new FileWriter(("e:" + File.separator + "test.txt")));
//            int read = 0;
//            while((read = reader.read()) != -1) {
//                System.out.println(read);
//            }
            String str = "";
            while (reader.readLine() != null) {//一次读取一行数据
                writer.write(str);//不包含换行符 + "\n"
                writer.newLine();//或者直接调方法加上换行符
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}

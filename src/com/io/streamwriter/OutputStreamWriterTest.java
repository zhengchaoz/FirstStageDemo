package com.io.streamwriter;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author
 * @date 2021-03-17-11:31
 */
public class OutputStreamWriterTest {

    @Test
    public void test() {
        OutputStreamWriter osw = null;
        try {
            File file = new File("e:\\test.txt");
            osw = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            osw.write("啦啦啦啦啦啦啦啦啦啦啦");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (osw != null) {
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while(true) {
                System.out.println("请输入：");
                String result = br.readLine();

                if ("e".equalsIgnoreCase(result) || "exit".equalsIgnoreCase(result)) {
                    System.out.println("已退出。");
                    break;
                }

                System.out.println(result.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

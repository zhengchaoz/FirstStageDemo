package com.io.filecopy;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * @author
 * @date 2021-03-16-15:26
 */
public class FileCopyTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件地址：");
        String url1 = scanner.nextLine();

        System.out.println("请输入文件地址：");
        String url2 = scanner.nextLine();

        File file1 = new File(url1);
        File file2 = new File(url2);
        InputStream is = null;
        OutputStream os = null;
//        if (file1.exists() & file1.isFile() & file2.exists() & file2.isFile()) {
            try {
                is = new FileInputStream(file1);
                os =new FileOutputStream(file2);
                int result = 0;//记录每次读取到的bytes的数据个数
                byte[] bytes = new byte[4];
                while ((result = is.read(bytes)) != -1) {
                    os.write(bytes, 0, result);// 写出byte[]，个数是result个
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
//        }

        scanner.close();
    }

    private static String replace(String path) {
        if (path == null || "".equals(path.trim())) throw new RuntimeException("路径不能为空！");
        return path.replaceAll("\\\\", File.separator);
    }

}

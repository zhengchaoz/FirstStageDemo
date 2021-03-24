package com.io.file;

import com.sun.istack.internal.NotNull;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author
 * @date 2021-03-15-14:14
 */
public class FileTest {

    /**
     * 获取指定文件的字节量
     */
    @Test
    public void fileLength() {
        File file = new File("E:" + File.separator + "test.txt");
        System.out.println(file.length());
    }

    /**
     * 判断指定文件是否存在
     */
    @Test
    public void fileExists() {
        File file = new File("e:\\test.txt");
        System.out.println(file.exists());
    }

    /**
     * 判断指定内容是否为文件
     */
    @Test
    public void isFile() {
        File file = new File("e:\\test.txt");
        System.out.println(file.isFile());
    }

    /**
     * 判断指定内容是否为文件夹
     */
    @Test
    public void isDirectory() {
        File file = new File("e:\\test");
        System.out.println(file.isDirectory());
    }

    /**
     * 获取指定内容的名字
     */
    @Test
    public void fileName() {
        File file = new File("e:\\test.txt");
        System.out.println(file.getName());
    }

    /**
     * 获取指定内容的上级
     */
    @Test
    public void fileParent() {
        File file = new File("e:\\test.txt");
        System.out.println(file.getParent());
    }

    /**
     * 获取指定内容的绝对路径，带盘符
     */
    @Test
    public void fileAbsolutePath() {
        File file = new File("e:\\test.txt");
        System.out.println(file.getAbsolutePath());
    }

    /**
     * 在windows中创建不存在的文件
     */
    @Test
    public void createNewFile() {
        File file = new File("e:\\test2.txt");
        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /**
     * 创建不存在的单级文件夹
     */
    @Test
    public void fileMkdir() {
        File file = new File("e:\\test2");
        System.out.println(file.mkdir());
    }

    /**
     * 创建不存在的多级文件夹，除非所创建的多级文件全部存在，返回false，否则只要有某一级文件不存在，返回true
     */
    @Test
    public void fileMkdirs() {
        File file = new File("e:\\test3\\a\\s\\d");
        System.out.println(file.mkdirs());
    }

    /**
     * 删除文件或者删除空的文件夹，由于a目录里还有目录,不为空,所以删除不了a目录
     */
    @Test
    public void fileDelete() {
        File file = new File("e:\\test3\\a");
        System.out.println(file.delete());
    }

    /**
     * 查看文件夹中的所有文件的名称
     */
    @Test
    public void fileArray() {
        File file = new File("e:\\test3");
        System.out.println(Arrays.toString(file.list()));
    }

    /**
     * 列出文件夹中所有的文件夹和文件对象,返回值是File[],每个数组元素都是file对象
     */
    @Test
    public void fileListFiles() {
        File file = new File("e:\\test3");
        System.out.println(file.listFiles().length);
    }

    @Test
    public void recursionFileLength() {
        File file = new File("e:\\test3");
        System.out.println(recursion(file));
    }

    private int recursion(@NotNull File file) {
        File[] files = file.listFiles();
        int length = 0;

        for (File f : files) {
            if (f.isFile())
                length += f.length();
            else
                length += recursion(f);
        }

        return length;
    }

}

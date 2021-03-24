package com.io.filecopy;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author
 * @date 2021-03-16-20:58
 */
public class FileReaderWriter {

    @Test
    public void fileReaderWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File fileRead = new File("");
            File fileWrite = new File("");

            fr = new FileReader(fileRead);
            fw = new FileWriter(fileWrite);

            char[] chars = new char[5];
            int len;
            while((len = fr.read(chars)) != -1) {
                fw.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

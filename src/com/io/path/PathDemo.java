package com.io.path;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author
 * @date 2021-03-18-21:08
 */
public class PathDemo {

    @Test
    public void Test() {
        Path path = Paths.get("");
        File file = path.toFile();
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package com.url;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author
 * @date 2021-03-20-15:47
 */
public class URLTest {

    @Test
    public void test() {
        HttpURLConnection httpURLConnection = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            URL url = new URL("http://localhost:8080/examples/img.jpg");
            httpURLConnection = (HttpURLConnection) url.openConnection();

            is = httpURLConnection.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream(("img1.jpg")));

            byte[] bytes = new byte[1024];
            int result;
            while((result = is.read(bytes)) != -1) {
                bos.write(bytes, 0, result);
            }
            System.out.println("下载好咯");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpURLConnection.disconnect();
        }
    }

}

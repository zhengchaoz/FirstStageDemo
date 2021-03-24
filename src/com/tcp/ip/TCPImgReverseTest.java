package com.tcp.ip;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author
 * @date 2021-03-20-14:36
 */
public class TCPImgReverseTest {

    @Test
    public void client() {
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        OutputStream os = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 9292);

            is = socket.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream(("img3.jpg")));

            byte[] bytes = new byte[1024];
            int result;
            while((result = is.read(bytes)) != -1) {
                bos.write(bytes, 0, result);
            }
            System.out.println("接收到了");

            os = socket.getOutputStream();
            os.write("接收到咯".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            ss = new ServerSocket(9292);
            socket = ss.accept();

            os = socket.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(("img.jpg")));
            byte[] bytes = new byte[1024];
            int result;
            while((result = bis.read(bytes)) != -1) {
                os.write(bytes, 0, result);
            }
            System.out.println("发给你了");

            socket.shutdownOutput();

            is = socket.getInputStream();
            bos = new ByteArrayOutputStream();
            byte[] bytes1 = new byte[1024];
            int result1;
            while((result1 = is.read(bytes1)) != -1) {
                bos.write(bytes1, 0, result1);
            }
            System.out.println(bos.toString());
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
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ss != null) {
                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

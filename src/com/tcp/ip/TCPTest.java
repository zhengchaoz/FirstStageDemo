package com.tcp.ip;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author
 * @date 2021-03-20-10:47
 */
public class TCPTest {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8899);

            os = socket.getOutputStream();
            os.write("我来啦。。。".getBytes());
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
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //服务端
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            ss = new ServerSocket(8899);
            socket = ss.accept();//接受客户端的socket

            is = socket.getInputStream();
            //不适用，可能会乱码
//            byte[] bytes = new byte[5];
//            int result;
//            while ((result = is.read()) != null) {
//                System.out.println(new String(bytes, 0, result));
//            }

            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[5];
            int result;
            while ((result = is.read(bytes)) != -1) {
                baos.write(bytes, 0, result);
            }
            System.out.println(baos.toString());
            System.out.println("收到了来自：" + socket.getInetAddress().getHostAddress() + "的通信。");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
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

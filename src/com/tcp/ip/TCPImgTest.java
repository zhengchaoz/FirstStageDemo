package com.tcp.ip;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author
 * @date 2021-03-20-13:56
 */
public class TCPImgTest {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 9191);

            os = socket.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("img.jpg")));

            byte[] bytes = new byte[1024];
            int result;
            while((result = bis.read(bytes)) != -1) {
                os.write(bytes, 0, result);
            }
            //重点注意：关闭输出流，否则服务器端无法判断文件是否传输完毕，会一直在while里死循环
            socket.shutdownOutput();

            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bytes1 = new byte[1024];
            int result1;
            while((result1 = is.read(bytes1)) != -1) {
                baos.write(bytes1, 0, result1);
            }
            System.out.println(baos.toString());
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
        }
    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(9191);
            socket = ss.accept();

            is = socket.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream(new File("img2.jpg")));

            byte[] bytes = new byte[1024];
            int result;
            while((result = is.read(bytes)) != -1) {
                bos.write(bytes, 0, result);
            }
            System.out.println("我收到啦");
            //服务器端返回响应
            os = socket.getOutputStream();
            os.write("小老弟".getBytes());
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

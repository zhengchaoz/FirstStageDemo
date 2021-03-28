package com.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @user Administrator
 * @date 2021/3/25
 */
public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        BufferedOutputStream bos = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        Scanner scanner = new Scanner(System.in);
        try {
            InetAddress inetAddress = InetAddress.getByName("176.55.9.212");
            socket = new Socket(inetAddress, 9292);

            while (true) {
                System.out.print("客户端输入：");
                outputStream = socket.getOutputStream();
                bos = new BufferedOutputStream(outputStream);
                String str = scanner.nextLine();
                bos.write((str + "0").getBytes(StandardCharsets.UTF_8));
                bos.flush();

//                socket.shutdownOutput();

                inputStream = socket.getInputStream();
                baos = new ByteArrayOutputStream();

                byte[] bytes = new byte[1024];
                int result;
                while ((result = inputStream.read(bytes)) != -1) {
                    baos.write(bytes, 0, result);
//                    if (useLoop(bytes, (byte) 48)) break;
                }
                System.out.println("服务端返回：" + baos.toString("UTF-8").replace('0', ' '));
            }
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
                if (inputStream != null) {
                    inputStream.close();
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
                if (outputStream != null) {
                    outputStream.close();
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

    public static boolean useLoop(byte[] arr, byte targetValue) {
        for (byte s : arr) {
            if (s == targetValue) {
                return true;
            }
        }
        return false;
    }

}

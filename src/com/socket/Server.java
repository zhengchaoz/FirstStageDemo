package com.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @user Administrator
 * @date 2021/3/25
 */
public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        Scanner scanner = new Scanner(System.in);
        try {
            serverSocket = new ServerSocket(9292);
            accept = serverSocket.accept();

            while (true) {
                inputStream = accept.getInputStream();
                baos = new ByteArrayOutputStream();

                byte[] bytes = new byte[1024];
                int result;
                while ((result = inputStream.read(bytes)) != -1) {
                    baos.write(bytes, 0, result);
                    if (useLoop(bytes, (byte) 48)) break;
                }
                System.out.println("客户端返回：" + baos.toString("UTF-8").replace('0', ' '));

                System.out.print("服务端输入：");
                OutputStream outputStream = accept.getOutputStream();
                String str = scanner.nextLine();
                outputStream.write((str + "0").getBytes(StandardCharsets.UTF_8));

//                accept.shutdownOutput();
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
                if (accept != null) {
                    accept.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null) {
                    serverSocket.close();
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

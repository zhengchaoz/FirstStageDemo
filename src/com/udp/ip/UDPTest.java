package com.udp.ip;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author
 * @date 2021-03-20-15:16
 */
public class UDPTest {

    @Test
    public void sender() {
        String str = "发给你";

        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(str.getBytes(), 0, str.getBytes().length, InetAddress.getLocalHost(), 9090);

            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ds != null) {
                    ds.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void receiver() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(9090);
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length);

            ds.receive(dp);
            System.out.println(new String(dp.getData(), 0, dp.getData().length));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ds != null) {
                    ds.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

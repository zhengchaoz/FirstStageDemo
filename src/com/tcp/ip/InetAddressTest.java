package com.tcp.ip;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author
 * @date 2021-03-18-21:29
 */
public class InetAddressTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 100);

        map.put("a", map.get("a") + 100);

        HashSet set = new HashSet();
    }

    @Test
    public void instantiation() {
        try {
            System.out.println(InetAddress.getByName("196.235.0.1"));
            System.out.println(InetAddress.getByName("www.baidu.com"));
            System.out.println(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getHostNameOrAddress() {
        try {
//            System.out.println(InetAddress.getByName("www.baidu.com").getHostName());
            System.out.println(InetAddress.getLocalHost().getHostName());
//            System.out.println(InetAddress.getByName("www.baidu.com").getHostAddress());
            System.out.println(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}

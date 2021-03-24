package com.collection.list;

import org.junit.Test;

import java.util.*;

/**
 * @author
 * @date 2021-03-18-16:29
 */
public class MapDemo {

    @Test
    public void test() {
        Map<String, Object> map = new HashMap<>();
        map.put("雷公助我", 213123);
        map.put("hdh", true);
        map.put("we", 'c');
        map.put("yj", 56.2);

        System.out.println(map.containsKey("yj"));
        System.out.println(map.containsValue(true));

//        Set<String> set = map.keySet();
//        Collection<Object> collection = map.values();
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        for (Map.Entry<String, Object> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    }

}

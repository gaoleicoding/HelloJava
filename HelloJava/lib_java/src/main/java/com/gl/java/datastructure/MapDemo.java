package com.gl.java.datastructure;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

class MapDemo {

    public static void main(String[] args) {
        Integer count =1000000;
        Random random =new Random();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            map.put(i+"", i+"");
        }
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            map.get((random.nextInt(count)+1)+"");
        }
        long time2 = System.currentTimeMillis();
        System.out.println("HashMap time:" + (time2 - time1));

        Map<String, String> linkedMap = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            linkedMap.put(i+"", i+"");
        }

        time1 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            linkedMap.get((random.nextInt(count)+1)+"");
        }
        time2 = System.currentTimeMillis();
        System.out.println("LinkedHashMap time:" + (time2 - time1));

        Map<String, String> treeMap = new TreeMap<>();
        for (int i = 0; i < count; i++) {
            treeMap.put(i+"", i+"");
        }

        time1 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            treeMap.get((random.nextInt(count)+1)+"");
        }
        time2 = System.currentTimeMillis();
        System.out.println("TreeMap time:" + (time2 - time1));

    }
}

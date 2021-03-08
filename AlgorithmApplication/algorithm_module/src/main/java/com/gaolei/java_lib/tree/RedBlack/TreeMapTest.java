package com.gaolei.java_lib.tree.RedBlack;

import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {

        TreeMap<String, Double> map = new TreeMap<>();
        map.put("ccc", 99.0);
        map.put("aaa", 83.0);
        map.put("zzz", 80.0);
        map.put("bbb", 89.0);
        System.out.println(map);
    }
}
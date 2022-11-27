package com.gl.algorithm.binarytree.RedBlack;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {

        HashMap<String, Double> map = new HashMap<>();
        map.put("ccc", 99.0);
        map.put("aaa", 83.0);
        map.put("zzz", 80.0);
        map.put("bbb", 89.0);

        HashMap<Integer, Double> map2 = new HashMap<>();
        map2.put(1, 80.0);
        map2.put(2, 89.0);
        System.out.println(map);
        System.out.println(map2);
    }
}
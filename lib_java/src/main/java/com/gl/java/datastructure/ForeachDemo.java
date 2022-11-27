package com.gl.java.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ForeachDemo {

    public static void main(String[] args) {
//        foreach();
        foreachAfterCompile();
    }

    public static void foreach() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println("list: " + Arrays.asList(list).toString());
    }

    public static void foreachAfterCompile() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator var10 = list.iterator();
        Integer var11;
        while (var10.hasNext()) {
            var11 = (Integer) var10.next();
            if (var11 == 4) {
                var10.remove();
            }

            System.out.println(var11);
        }
        System.out.println("list: " + Arrays.asList(list).toString());

    }
}

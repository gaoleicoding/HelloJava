package com.gl.java.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> map1 = new TreeMap<Integer,Integer>();  //默认的TreeMap升序排列
        TreeMap<Integer,Integer> map2= new TreeMap<Integer,Integer>(new Comparator<Integer>(){
             /* 
             * int compare(Object o1, Object o2) 返回一个基本类型的整型， 
             * 返回负数表示：o1 小于o2， 
             * 返回0 表示：o1和o2相等， 
             * 返回正数表示：o1大于o2。 
             */  
            public int compare(Integer a,Integer b){
                return b-a;            
            }
            });

        map1.put(1,2);
        map1.put(2,4);
        map1.put(7, 1);
        map1.put(5,2);
        System.out.println("map1="+map1);

        map2.put(1,2);
        map2.put(2,4);
        map2.put(7, 1);
        map2.put(5,2);
        System.out.println("Map2="+map2);  
        

    }

    public static void sortByValue() {
        Map<String,String> map = new TreeMap<String,String>();
        map.put("a", "dddd");
        map.put("d", "aaaa");
        map.put("b", "cccc");
        map.put("c", "bbbb");

        List<Entry<String, String>> list = new ArrayList<Entry<String, String>>(map.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Entry<String, String> o1, Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Entry<String, String> e: list) {
            System.out.println(e.getKey()+":"+e.getValue());
        }
    }
}
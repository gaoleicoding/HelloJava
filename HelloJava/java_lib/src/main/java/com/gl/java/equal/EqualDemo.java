package com.gl.java.equal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EqualDemo {
    private final static Map<Integer, String> lastMessageCache = new ConcurrentHashMap<>();

    public static void main(String args[]) {
        List<Book> bookList = new ArrayList<>();
        Book bookAndroid = new Book(1, "Android", "android");
        bookList.add(bookAndroid);
        Book bookAndroid2 = new Book(1, "Android", "android");
        Book bookIOS = new Book(2, "IOS", "ios");
        bookList.add(bookIOS);
        Book h5IOS = new Book(3, "H5", "h5");
        bookList.add(h5IOS);
        boolean isEqual = bookAndroid.equals(bookAndroid2);
        boolean isContain = bookList.contains(bookAndroid2);

        System.out.println("isEqual:" + isEqual);
        System.out.println("isContain:" + isContain);

        String content3 = "一二三四五六七八九十{0} 1234567890{2}，你被盟主升级到等级{1}";
        putValue();
    }

    public static void putValue() {
        lastMessageCache.put(1, "1");
        System.out.println("lastMessageCache: "+lastMessageCache.toString());
    }
}

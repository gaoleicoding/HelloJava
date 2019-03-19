package com.gaolei.java_lib.string_reverse;

import java.util.regex.Pattern;

public class StringReverse {
    public static void main(String[] args) {

        String abc = "a765003000";
        String reverseStr = reverse5(abc);
        System.out.println("reverseStr：" + reverseStr);
    }

    public static String reverse5(String orig) {
        char[] s = orig.toCharArray();
        int n = s.length - 1;
        int halfLength = n / 2;
        for (int i = 0; i <= halfLength; i++) {
            char temp = s[i];
            s[i] = s[n - i];
            s[n - i] = temp;
        }
        return new String(s);
    }
}

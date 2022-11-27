package com.gl.algorithm.string;

/**
 * Description：把*移动到字符串最前面
 */
public class StringMoveChar {

    public static void main(String args[]) {
        String str = "sf*bv*yy*l";

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        move(str, sb, sb2);
        System.out.println("length: " + sb.length());
        System.out.println("result: " + sb.toString() + sb2.toString());
    }

    private static void move(String str, StringBuilder sb, StringBuilder sb2) {
        char asterisk = '*';
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char letter = str.charAt(i);
            if (asterisk == letter) {
                sb.append(letter);
            } else {
                sb2.append(letter);
            }
        }
    }

}

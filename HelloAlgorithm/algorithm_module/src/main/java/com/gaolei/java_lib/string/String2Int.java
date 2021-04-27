package com.gaolei.java_lib.string;

import java.util.regex.Pattern;

/**
 * Description：字符串转整数
 */
public class String2Int {
    public static void main(String[] args) {

        String abc = "765b00a3000";

        stringToInt(abc);
    }

    public static int stringToInt(String str) {
        if (str == null || str.length() == 0) {
            System.out.println("此字符串为空");
            return -1;
        }
        int length = str.length();
        int sum = 0, sum1 = 0;
        if (isInteger(str)) {
            for (int i = 0; i < length; i++) {
                sum1 += (str.charAt(i) - '0') * Math.pow(10, length - i - 1);
                if (sum1 < Integer.MAX_VALUE) {
                    sum = sum1;
                    System.out.println("sum：" + sum);
                } else {
                    System.out.println("此字符串转化成整数，产生了溢出");
                    return -1;
                }
            }
            System.out.println("此整数为：" + sum);
        } else {
            System.out.println("此字符串不能转化为整数");
        }
        return 0;
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("[0-9]");
        return pattern.matcher(str).matches();
    }
}

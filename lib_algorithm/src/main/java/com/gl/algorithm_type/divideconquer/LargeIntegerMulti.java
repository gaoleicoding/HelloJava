package com.gl.algorithm_type.divideconquer;

public class LargeIntegerMulti {

    public static void main(String[] args) {
        String num1 = "123456";
        String num2 = "78910";
        System.out.println(multi(num1, num2));
    }

    //分治法
    public static Long multi(String num1, String num2) {
        String num1FirstHalf = num1.substring(0, num1.length() / 2);
        String num1SecondHalf = num1.substring(num1.length() / 2);
        String num2FirstHalf = num2.substring(0, num2.length() / 2);
        String num2SecondHalf = num2.substring(num2.length() / 2);
        int num1SecondHalfLen = num1SecondHalf.length();
        int num2SecondHalfLen = num2SecondHalf.length();
        if (num1.length() <= 4 && num2.length() <= 4) {
            return ((long) Integer.parseInt(num1) * Integer.parseInt(num2));
        }
        if (num1.length() > 4 && num2.length() <= 4) {
            return (long) (multi(num1FirstHalf, num2) * Math.pow(10, num1SecondHalfLen) + multi(num1SecondHalf, num2));
        }
        if (num1.length() <= 4) {
            return (long) (multi(num2FirstHalf, num1) * Math.pow(10, num2SecondHalfLen) + multi(num2SecondHalf, num1));
        } else {
            return (long) (multi(num1FirstHalf, num2FirstHalf) * Math.pow(10, num1SecondHalfLen + num2SecondHalfLen) + multi(num1FirstHalf, num2SecondHalf) * Math.pow(10, num1SecondHalfLen) + multi(num1SecondHalf, num2FirstHalf) * Math.pow(10, num2SecondHalfLen) + multi(num1SecondHalf, num2SecondHalf));
        }
    }
}
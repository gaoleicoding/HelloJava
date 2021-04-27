package com.gaolei.java_lib.array;

import java.util.ArrayList;

/**
 * Description：两个有序数组合并为一个有序数组
 */
public class ArrayMerge {

    public ArrayMerge() {

    }

    public static ArrayList<Integer> mergeArrays(int[] arrayOne, int[] arrayTwo) {
        int arrayOneLen = arrayOne.length;
        int arrayTwoLen = arrayTwo.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0, j = 0;

        while (i < arrayOneLen || j < arrayTwoLen) {
            if (i == arrayOneLen) {
                list.add(arrayTwo[j]);
                j++;
            } else if (i < arrayOneLen && j == arrayTwoLen) {
                list.add(arrayOne[i]);
                i++;
            } else {
                if (arrayOne[i] <= arrayTwo[j]) {
                    list.add(arrayOne[i]);
                    i++;
                } else if (arrayOne[i] > arrayTwo[j]) {
                    list.add(arrayTwo[j]);
                    j++;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arrA = {1, 3, 5, 7, 8, 9, 11, 12};
        int[] arrB = {2, 4, 6, 8, 10, 12, 13};

        ArrayList<Integer> arrList = mergeArrays(arrA, arrB);

        for (Integer intItem : arrList) {
            System.out.println(intItem);
        }
    }
}
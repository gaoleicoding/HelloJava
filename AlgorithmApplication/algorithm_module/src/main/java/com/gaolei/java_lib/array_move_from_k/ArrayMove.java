package com.gaolei.java_lib.array_move_from_k;

import java.util.Arrays;

/**
 * Description：将一个长度为n的数组A的元素循环右移k位 比如数组 1, 2, 3, 4, 5 循环右移3位之后变成 3, 4, 5, 1, 2
 */

public class ArrayMove {

    private static void trans(int[] a, int n, int k) {
        for (int i = n - 1; i >= k; i--) {
            swap(a, i, i - k);
        }
        if ((n - k) % k == 0) {
        }
        else
            trans(a, k, k - (n - k) % k);
    }

    public static void swap(int[] a, Integer i, Integer k) {
        Integer temp;
        temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }

    /*
     *方法一：
     *首先考虑k。如果k能被数组长度len整除，那么数组顺序不变，可以直接输出数组。如果不能整除，得到k=k%len。
     *将数组右移k次，每次都把数组最后一位保存，然后从下标为len-2到0的数都往右移动一位，最后把原来最后一位放到数组开头。
     */
    public static void CircleRightK(int[] A, int k) {
        int len = A.length;
        k = k % len;
        if (k == 0) return;
        while (k > 0) {
            int temp = A[len - 1];   //每次保存最后一位
            for (int i = len - 1; i > 0; i--) {
                A[i] = A[i - 1];
            }
            A[0] = temp;
            k--;
        }
    }

    /*
     *方法二
     *考虑将数组逆序，然后把数组分为两部分，前半部分为前k个数，后半部分为剩下的数，再分别对他们进行逆序。
     */
    public static void CircleRightK2(int[] A, int k) {
        int len = A.length;
        k = k % len;
        if (k == 0) return;
        reverse(A, 0, len - 1);  //逆置数组
        reverse(A, 0, k - 1);
        reverse(A, k, len - 1);

    }

    public static void reverse(int[] A, int i, int j) {
        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        CircleRightK2(array, 2);
        System.out.print(Arrays.toString(array));
    }

}

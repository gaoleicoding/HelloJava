package com.gaolei.java_lib.array_move_from_k;

import java.util.Arrays;


/**
 * Created by gaolei on 2018/6/27.
 */

public class ArrayMove {
    private static void trans(int[] a, int n, int k) {
        for (int i = n - 1; i >= k; i--) {
            swap(a, i, i - k);
        }
        if ((n - k) % k == 0)
            return;
        else
            trans(a, k, k - (n - k) % k);
    }

    public static void swap(int[] a, Integer i, Integer k) {
        Integer temp;
        temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }
    //设数组大小为n,先保存a[n-k+i],然后将不用移动的n-k个元素后移：
    public static void move1(int[] a, int n, int k) {

        for (int i = 0; i < k; i++) {
            int t = a[n - k + i];
            System.out.println("t:" + t);
            for (int j = 0; j < n - k; j++) {
                System.out.println("j:" + j);
                a[n - k + i - j] = a[n - k + i - j - 1];
                System.out.println("n - k + i - j:" + (n - k + i - j));
            }

            a[i] = t;
        }

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5,6};
//        trans(array,9,3);
        move1(array, array.length, 2);
        System.out.print(Arrays.toString(array));
    }

}

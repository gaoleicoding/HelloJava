package com.gaolei.java_lib.array;

/**
 * Description：求连续子数组的最大和
 */
public class ArrayContinuousSubarray {
    public static void main(String[] args) {

        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        Long begintime = System.nanoTime();
        int result = FindGreatestSumOfSubArray(array);
        Long endtime = System.nanoTime();
        System.out.println("连续子数组的最大和为：" + result + ",运行时间：" + (endtime - begintime) + "ns");

    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        int currentsum = array[0];
        int greatsetsum = array[0];
        System.out.println("第1步：累加子数组和：" + currentsum + "，最大子数组和：" + greatsetsum);
        for (int i = 1; i < array.length; i++) {
            if (currentsum > 0) {
                currentsum += array[i];
            } else {
                currentsum = array[i];
            }
            if (currentsum > greatsetsum) {
                greatsetsum = currentsum;
            }
            System.out.println("第" + (i + 1) + "步：累加子数组和：" + currentsum + "，最大子数组和：" + greatsetsum);
        }
        return greatsetsum;
    }
}

package com.gl.algorithm.array;

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
        int currentSum = array[0];
        int greatestSum = array[0];
        System.out.println("第1步：累加子数组和：" + currentSum + "，最大子数组和：" + greatestSum);
        for (int i = 1; i < array.length; i++) {
            if (currentSum > 0) {
                currentSum += array[i];
            } else {
                currentSum = array[i];
            }
            if (currentSum > greatestSum) {
                greatestSum = currentSum;
            }
            System.out.println("第" + (i + 1) + "步：累加子数组和：" + currentSum + "，最大子数组和：" + greatestSum);
        }
        return greatestSum;
    }
}

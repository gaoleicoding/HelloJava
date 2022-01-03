package com.gl.algorithm_type.divideconquer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class QuickSort {


    public static void main(String[] args) {
        Random random = new Random();
        //产生 10000个随机数
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            int s = random.nextInt(10000) + 1;
            list.add(s);
        }
        Integer[] aar = list.toArray(new Integer[list.size()]);
        quickSort(aar);

    }

    //二、快速排序
    public static void quickSort(Integer[] a2) {
        long currentTime = System.currentTimeMillis();
        if (a2.length > 0) {
            //查看数组是否为空
            quickSort(a2, 0, a2.length - 1);
        }
        long nowTime = System.currentTimeMillis();
        System.out.println("quickSort-----------cost time:" + (nowTime - currentTime));
    }

    public static void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);
            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    private static int getIndex(Integer[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }
}

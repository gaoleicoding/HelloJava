package com.gaolei.java_lib.array_order;

import java.util.Arrays;

public class Order {

    public static void main(String[] args) {
        int [] a = {8,13,21,0,1,2,3,5,34};
        quick(a);
        System.out.println(Arrays.toString( a));
    }

    //冒泡排序
    public static void bubbleSort(Integer ar[]) {
        Integer a[] = ar.clone();
        long currentTime = System.currentTimeMillis();
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        long nowTime = System.currentTimeMillis();
        System.out.println("BubbleSort-----------cost time:" + (nowTime - currentTime));
//	System.out.println(Arrays.toString( a));
    }

    //快速排序
    public static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {

                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }
    public static void _quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            _quickSort(list, low, middle - 1);        //对低字表进行递归排序
            _quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }
    public static void quick(int[] a2) {
        if (a2.length > 0) {    //查看数组是否为空
            _quickSort(a2, 0, a2.length - 1);
        }
    }


    //堆排序
    public static void heapSort(Integer[] a) {
        int arrayLength = a.length;
        //循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            //建堆
            buildMaxHeap(a, arrayLength - 1 - i);
            //交换堆顶和最后一个元素
            swap(a, 0, arrayLength - 1 - i);

        }
    }

    private static void swap(Integer[] data, int i, int j) {
        // TODO Auto-generated method stub
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    //对data数组从0到lastIndex建大顶堆
    private static void buildMaxHeap(Integer[] data, int lastIndex) {
        // TODO Auto-generated method stub
        //从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //k保存正在判断的节点
            int k = i;
            //如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                //k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    //若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    //交换他们
                    swap(data, k, biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    //插入排序，对于很小的数组（N<=20）,快速排序不如插入排序好。
    public static void insertSort(Integer ar[]) {
        Integer a[] = ar.clone();
        long currentTime = System.currentTimeMillis();
        int temp = 0;
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            temp = a[i];
            for (; j >= 0 && temp < a[j]; j--) {
                a[j + 1] = a[j];                       //将大于temp的值整体后移一个单位
            }
            a[j + 1] = temp;
        }
        long nowTime = System.currentTimeMillis();
        System.out.println("InsertSort-----------cost time:" + (nowTime - currentTime));
//	System.out.println(Arrays.toString( a));
    }
}

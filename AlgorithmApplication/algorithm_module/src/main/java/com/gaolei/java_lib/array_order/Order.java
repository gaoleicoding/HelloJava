package com.gaolei.java_lib.array_order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
 *系统排序Arrays.sort（）
 *Java Arrays中提供了对所有类型的排序。其中主要分为Primitive（8种基本类型）和Object两大类。
 *基本类型：采用调优的快速排序;
 *对象类型：采用改进的归并排序。
 *
 * 源码中的快速排序，主要做了以下几个方面的优化：
 *1、当待排序的数组中的元素个数较少时，源码中的阀值为7，采用的是插入排序。尽管插入排序的时间复杂度为0（n ^ 2），但是当数组元素较少时，插入排序优于快速排序，因为这时快速排序的递归操作影响性能
 *2、较好的选择了划分元（基准元素） 。能够将数组分成大致两个相等的部分，避免出现最坏的情况。例如当数组有序的的情况下，选择第一个元素作为划分元，将使得算法的时间复杂度达到为O（n ^ 2）。
 *源码中选择划分元的方法：
 *当数组大小为size = 7时，取数组中间元素作为划分元.int n = m >> 1;（此方法值得借鉴）
 *当数组大小7 <size <= 40时，取首，中，末三个元素中间大小的元素作为划分元。
 *当数组大小> 40时，从待排数组中较均匀的选择9个元素，选出一个中中做做为分分元。
 * */
public class Order {

    public static void main(String[] args) {
        Random random = new Random();
        //产生 10000个随机数
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            int s = random.nextInt(10000) + 1;
            list.add(s);
        }
        Integer[] aar = list.toArray(new Integer[list.size()]);

        bubbleSort(aar);
        quickSort(aar);
        mergeSort(aar, 0, aar.length);
        insertSort(aar);
//      System.out.println(Arrays.toString(a));
    }

    //一、冒泡排序
    public static void bubbleSort(Integer data[]) {
        Integer aar[] = data.clone();
        long currentTime = System.currentTimeMillis();
        int len = aar.length;
        int temp;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (aar[j] > aar[j + 1]) {
                    temp = aar[j];
                    aar[j] = aar[j + 1];
                    aar[j + 1] = temp;
                }
            }
        }

        long nowTime = System.currentTimeMillis();
        System.out.println("BubbleSort-----------cost time:" + (nowTime - currentTime));
    }

    //二、快速排序
    public static void quickSort(Integer[] a2) {
        long currentTime = System.currentTimeMillis();
        if (a2.length > 0) {    //查看数组是否为空
            _quick(a2, 0, a2.length - 1);
        }
        long nowTime = System.currentTimeMillis();
        System.out.println("quickSort-----------cost time:" + (nowTime - currentTime));
    }

    public static void _quick(Integer[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            _quick(list, low, middle - 1);        //对低字表进行递归排序
            _quick(list, middle + 1, high);       //对高字表进行递归排序
        }
    }

    public static int getMiddle(Integer[] data, int low, int high) {
        int tmp = data[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && data[high] >= tmp) {
                high--;
            }
            data[low] = data[high];   //比中轴小的记录移到低端
            while (low < high && data[low] <= tmp) {
                low++;
            }
            data[high] = data[low];   //比中轴大的记录移到高端
        }
        data[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }

    //三、归并排序
    public static void mergeSort(Integer[] aar, int start, int end) {
        if (start < end) {//当子序列中只有一个元素时结束递归
            int mid = (start + end) / 2;//划分子序列
            mergeSort(aar, start, mid);//对左侧子序列进行递归排序
            mergeSort(aar, mid + 1, end);//对右侧子序列进行递归排序
            merge(aar, start, mid, end);//合并
        }
    }

    public static void merge(Integer[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];//辅助数组
        int p1 = left, p2 = mid + 1, k = left;//p1、p2是检测指针，k是存放指针

        while (p1 <= mid && p2 <= right) {
            if (a[p1] <= a[p2])
                tmp[k++] = a[p1++];
            else
                tmp[k++] = a[p2++];
        }

        while (p1 <= mid) tmp[k++] = a[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p2 <= right) tmp[k++] = a[p2++];//同上

        //复制回原素组
        for (int i = left; i <= right; i++)
            a[i] = tmp[i];
    }

    //四、插入排序
    //对于很小的数组（N<=20）,快速排序不如插入排序好。
    public static void insertSort(Integer data[]) {
        Integer aar[] = data.clone();
        long currentTime = System.currentTimeMillis();
        int temp = 0;
        for (int i = 1; i < aar.length; i++) {
            int j = i - 1;
            temp = aar[i];
            for (; j >= 0 && temp < aar[j]; j--) {
                aar[j + 1] = aar[j];                       //将大于temp的值整体后移一个单位
            }
            aar[j + 1] = temp;
        }
        long nowTime = System.currentTimeMillis();
        System.out.println("InsertSort-----------cost time:" + (nowTime - currentTime));
//	System.out.println(Arrays.toString( a));
    }


    //五、堆排序
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
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    //对data数组从0到lastIndex建大顶堆
    private static void buildMaxHeap(Integer[] data, int lastIndex) {
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

    //六、基排序
    public static void radixSort(Integer data[]) {
        Integer aar[] = data.clone();
        long currentTime = System.currentTimeMillis();
        radix(aar);
        long nowTime = System.currentTimeMillis();
        System.out.println("RadixSort-----------cost time:" + (nowTime - currentTime));
//	System.out.println(Arrays.toString( a));
    }

    public static void radix(Integer[] data) {

        //首先确定排序的趟数;
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }

        int time = 0;
        //判断位数;
        while (max > 0) {
            max /= 10;
            time++;
        }

        //建立10个队列;
        List<List> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<Integer>();
            queue.add(queue1);
        }

        //进行time次分配和收集;
        for (int i = 0; i < time; i++) {

            //分配数组元素;
            for (Integer datum : data) {
                //得到数字的第time+1位数;
                int x = datum % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = (ArrayList<Integer>) queue.get(x);
                queue2.add(datum);
                queue.set(x, queue2);
            }
            int count = 0;//元素计数器;
            //收集队列元素;
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> queue3 = (ArrayList<Integer>) queue.get(k);
                    data[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
    }

    //七、选择排序
    public static void selectSort(Integer data[]) {
        Integer aar[] = data.clone();
        long currentTime = System.currentTimeMillis();
        int position = 0;
        for (int i = 0; i < aar.length; i++) {

            int j = i + 1;
            position = i;
            int temp = aar[i];
            for (; j < aar.length; j++) {
                if (aar[j] < temp) {
                    temp = aar[j];
                    position = j;
                }
            }
            aar[position] = aar[i];
            aar[i] = temp;
        }
        long nowTime = System.currentTimeMillis();
        System.out.println("SelectSort-----------cost time:" + (nowTime - currentTime));
//		System.out.println(Arrays.toString( a));
    }

    //八、希尔排序
    public static void shellSort(Integer data[]) {
        Integer aar[] = data.clone();
        long currentTime = System.currentTimeMillis();
        double d1 = aar.length;
        int temp = 0;
        while (true) {
            d1 = Math.ceil(d1 / 2);
            int d = (int) d1;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < aar.length; i += d) {
                    int j = i - d;
                    temp = aar[i];
                    for (; j >= 0 && temp < aar[j]; j -= d) {
                        aar[j + d] = aar[j];
                    }
                    aar[j + d] = temp;
                }
            }
            if (d == 1)
                break;
        }
        long nowTime = System.currentTimeMillis();
        System.out.println("ShellSort-----------cost time:" + (nowTime - currentTime));
//	System.out.println(Arrays.toString( a));
    }

}

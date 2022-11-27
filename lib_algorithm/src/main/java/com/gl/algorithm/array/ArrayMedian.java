package com.gl.algorithm.array;

import java.util.PriorityQueue;
/**
 * Description：无序数组的中位数（最小堆）
 */
public class ArrayMedian {
    public static double median(int[] array) {
        int heapSize = array.length / 2 + 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(heapSize);
        for (int i = 0; i < heapSize; i++) {
            heap.add(array[i]);
        }
        for (int i = heapSize; i < array.length; i++) {
            if (heap.peek() < array[i]) {
                heap.poll();
                heap.add(array[i]);
            }
        }
        if (array.length % 2 == 1) {
            return (double) heap.peek();
        } else {
            return (double) (heap.poll() + heap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{12, 34, 1, 209, 17, 18,900, -10};
        System.out.println(median(array));
    }
}

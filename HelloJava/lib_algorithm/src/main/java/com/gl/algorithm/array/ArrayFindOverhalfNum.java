package com.gl.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description：找出出现次数超过一半的数
 */
public class ArrayFindOverhalfNum {


    public static void main(String[] args) {

        int arr[] = {1, 2, 4, 4, 4, 3, 8, 4};
        int len = arr.length;
        int data = findOverHalfDataBM(arr);
        System.out.println("出现次数超过一半的数是 :" + data);

    }

    // 如果已经确定有出现次数超过一半的数；
    public static int findOverHalfData(int arr[]) {
        int findNum = 0;
        int count = 0; // 只要最终count > 0，那么对应的findNum就是出现次数超过一半的数；
        int len = arr.length;
        // 循环过程中，i每增加一次，就相当于把i之前的所有元素（除了满足“findNum == arr[i]”条件的arr[i]，这些对应元素用“count++”来标记）都抛弃了，
        // 但是之后每当执行一次“ count-- ”时，又会从前面这些已保留的且等于findNum的元素中删除一项，直到count == 0，再重选findNum；
        for (int i = 0; i < len; i++) {
            if (count == 0) // count为0时，表示当前的findNum需要重选；
            {
                findNum = arr[i];
                count = 1;
            } else {
                if (findNum == arr[i])
                    count++;
                else
                    count--;
            }
        }

        return findNum;
    }
    // 3. 使用摩尔投票法
    public static int findOverHalfDataBM(int[] array) {

        int votes = 0;
        int x = 0;
        for (int num : array) {
            if (votes == 0) {
                x = num;
            }
            votes += (num == x) ? 1 : -1;
        }

        int count = 0;
        System.out.println("x  : " + x);
        for (int num : array) {
            if (x == num) count++;
        }

        return (count > array.length / 2) ? x : -1;
    }


    public static int findAppearMoreThanHalf(int[] arr) {
        int num = 0;
        //存储出现次数超过一半的数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (!map.containsKey(i)) {//不包含该数，第一次出现
                map.put(i, 1);
            } else {
                int n = map.get(i);
                n++;//出现过了的就取出+1，再放回去
                map.put(i, n);
                if (n > (arr.length / 2)) {//出现次数超过一半的话
                    num = i;
                    return num;
                }
            }
        }
        return -1;
    }

}

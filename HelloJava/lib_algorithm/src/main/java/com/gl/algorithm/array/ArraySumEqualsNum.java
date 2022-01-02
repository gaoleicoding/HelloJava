package com.gl.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description：求数组中是否存在两个数的和等于某个值
 */
public class ArraySumEqualsNum {
    public static void main(String[] args) {

        int array[] = {3, 0, 6, 1, 8, 2};
        int[] indexs = twoSum(array, 1);
        System.out.println("inidexs：" + indexs);
    }

    // 找到这两个数的下标并返回(以长度为2的数组的形式返回)
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            if (mp.containsKey(k) && i != mp.get(k)) {
                ans[0] = i;
                ans[1] = mp.get(k);
                break;
            }
        }
        return ans;
    }
}

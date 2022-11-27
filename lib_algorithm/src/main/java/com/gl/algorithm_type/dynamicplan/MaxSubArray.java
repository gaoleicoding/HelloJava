package com.gl.algorithm_type.dynamicplan;

/**
 * 连续子数组的最大和
 */
class MaxSubArray {

    public static void main(String[] args) {
        int[] array = {-6,1, -2, 3, 5, 10, -4, 7, 2, -5};
        int result = maxSubArray(array);
        System.out.println("result: " + result);
    }

    /**
     * 复杂度分析：
     * 时间复杂度 O(N)：线性遍历数组 nums即可获得结果，使用 O(N)时间。
     * 空间复杂度 O(1)：使用常数大小的额外空间。
     */
    public static int maxSubArray(int[] nums) {

        int max = nums[0];
        //用于记录dp[i-1]的值，对于dp[0]而言，其前面的dp[-1]=0
        int former = 0;
        //用于记录dp[i]的值
        int cur;
        for (int num : nums) {
            cur = num;
            if (former > 0) {
                cur += former;
            }
            if (cur > max) {
                max = cur;
            }
            System.out.println("cur:" + cur);
            System.out.println("max:" + max);
            former = cur;
        }
        return max;
    }
}
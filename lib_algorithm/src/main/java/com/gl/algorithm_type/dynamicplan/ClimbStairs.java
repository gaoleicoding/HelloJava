package com.gl.algorithm_type.dynamicplan;


public class ClimbStairs {

    public static void main(String[] args) {
        int result = climbTwoStairs(5);
        System.out.println("result: " + result);
    }

    /**
     * LeetCode #70 : 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到n楼呢？
     * f(n)表示到达第n级台阶共有多少种方法 状态转移方程：f(n) = f(n-1) + f(n-2)
     * 复杂度分析：
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     */
    public static int climbTwoStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * LeetCode 面试题 08.01. 三步问题 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
     * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
     * 提示:n范围在[1, 1000000]之间
     * 算法时间复杂度O(n),空间复杂度O(1)
     */
    long climbThreeStairs(int n) {
        if (n <= 2) {
            return n;
        }

        long MOD = 1000000007;
        long dp1 = 1;
        long dp2 = 2;
        long dp3 = 4;

        for (int i = 4; i <= n; i++) {
            long temp = (dp1 + dp2 + dp3) % MOD;
            dp1 = dp2;
            dp2 = dp3;
            dp3 = temp;
        }
        return (int) (dp3 % MOD);
    }
}

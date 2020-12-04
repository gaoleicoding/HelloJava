package com.gaolei.java_lib.fibonacci;

/**
 * Description：求菲波那契数列的和
 */
public class FibonacciDemo {
    public static void main(String[] args) {

        int n = 20;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo(i) + "\t");
            sum += fibo(i);
        }
        System.out.println("\n菲波那契数列的前20项和为:" + sum);
    }

    //第n项值
    private static int fibo(int n) {
        if (n <= 3) {
            return n;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }
}
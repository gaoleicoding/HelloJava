package com.gl.algorithm.num;

/**
 * Description：求菲波那契数列的和
 * 指的是这样一个数列：1、1、2、3、5、8、13、21、34、……在数学上，斐波纳契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)(n>=3，n∈N*)
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
        if (n < 3) {
            return n;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }
}
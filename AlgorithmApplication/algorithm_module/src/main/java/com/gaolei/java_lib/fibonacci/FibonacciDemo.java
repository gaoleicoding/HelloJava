package com.gaolei.java_lib.fibonacci;

public class FibonacciDemo {
    public static void main(String[] args) {
 
        int n = 20;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo(i) + "\t");
            sum +=fibo(i);
        }
        System.out.println("\n菲波那契数列的前20项和为:"+sum);
    }
 
    private static int fibo(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        return fibo(n - 1) + fibo(n - 2);
    }
}
package com.gaolei.java_lib.array_GCD_LCM;

/**
 * Description：求最小公倍数和最大公约数
 */
public class GCDLCM {
    public static void main(String[] args) {
        int m = 16, n = 24;
//		Scanner in = new Scanner(System.in);
//		System.out.println("请输入两个正整数:");
//		System.out.print("第一个数为:");
//		m= in.nextInt();
//		System.out.print("第二个数为:");
//		n = in.nextInt();

        MaxDivisorMinMultiple mdmm = new MaxDivisorMinMultiple(m, n);

        System.out.println("最大公约数为: " + mdmm.getMaxDivsior());
        System.out.println("最小公倍数为: " + mdmm.getMinMultiple());
    }
}

class MaxDivisorMinMultiple {
    private int m, n;
    private int MaxDivsior, MinMultiple;

    //构造函数
    public MaxDivisorMinMultiple(int m, int n) {
        if (m > n)//输入的两个数中, 大数赋值给m, 小数赋值给n,
        {
            this.m = m;
            this.n = n;
        } else {
            this.m = n;
            this.n = m;
        }

    }

    public int getMaxDivsior() {
        for (int i = n; i >= 1; i--) {
            // 小n的数中第一个能被m和n整除的
            if (n % i == 0 && m % i == 0) {
                MaxDivsior = i;
                break;
            }
        }
        return MaxDivsior;
    }

    public int getMinMultiple() {
        int i = 1;
        while (true) {
            //n最小的倍数可以把m整除
            if ((n * i) % m == 0) {
                MinMultiple = n * i;
                break;
            }
            i++;
        }
        return MinMultiple;
    }
}
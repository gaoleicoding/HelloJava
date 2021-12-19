package com.gaolei.java_lib.num;

public class PrimeNum {
    public static void main(String[] args) {
        test4();
    }

    public static void test4() {
        boolean bool;
        for (int i = 3; i < 100; i += 2) {
            bool = true;
            for (int j = 3; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    bool = false;

                    break;
                }
            }
            if (bool)
                System.out.print(i + " ");
        }
    }
}

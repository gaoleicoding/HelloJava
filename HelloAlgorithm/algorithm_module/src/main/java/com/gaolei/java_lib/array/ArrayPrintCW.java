package com.gaolei.java_lib.array;

public class ArrayPrintCW {
    /**
     * Description：二维数组（N*N），顺时针从外向里打印数组
     */
    public static void main(String[] args) {

        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        /* 打印结果：
            1,2,3,
            6,9,
            8,7,
            4,5
                */
        printMatrixInCircle(a);
    }

    public static void printMatrixInCircle(int[][] array) {
        if (array == null)
            return;
        int start = 0;
        while (array[0].length > start * 2 && array.length > start * 2) {
            printOneCircle(array, start);
            start++;
        }
    }

    private static void printOneCircle(int[][] array, int start) {

        int cloumLength = array[0].length;
        int rowLength = array.length;
        int colunmIndex = cloumLength - 1 - start;
        int rowIndex = rowLength - 1 - start;
        //从左到右打印一行
        for (int i = start; i <= colunmIndex; i++) {
            int number = array[start][i];
            System.out.print(number + ",");
        }
        System.out.println("");
        //从上到下打印一列
        if (start < rowIndex) {
            for (int i = start + 1; i <= rowIndex; i++) {
                int number = array[i][colunmIndex];
                System.out.print(number + ",");
            }
        }
        System.out.println("");
        //从右到左打印一行
        if (start < colunmIndex && start < rowIndex) {
            for (int i = colunmIndex - 1; i >= start; i--) {
                int number = array[rowIndex][i];
                System.out.print(number + ",");
            }
        }
        System.out.println("");
        //从下到上打印一列
        if (start < rowIndex && start < rowIndex - 1) {
            for (int i = rowIndex - 1; i >= start + 1; i--) {
                int number = array[i][start];
                System.out.print(number + ",");
            }
        }
    }
}

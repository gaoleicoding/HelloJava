package com.gaolei.java_lib.array_print_cw;

public class ArrayPrintCW {
    /**
     * Description:二维数组（N*N），沿对角线方向，从右上角打印到左下角
     *
     * @param args
     * @author liuwei  DateTime 2014-5-27 下午4:13:56
     */
    public static void main(String[] args) {


//        int[][] a = {{1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}};
        int[][] a = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
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
        int columns = array[0].length;
        int rows = array.length;
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        //从左到右打印一行
        for (int i = start; i <= endX; i++) {
            int number = array[start][i];
            System.out.print(number + ",");
        }
        //从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                int number = array[i][endX];
                System.out.print(number + ",");
            }
        }
        //从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                int number = array[endY][i];
                System.out.print(number + ",");
            }
        }
        //从下到上打印一列
        if (start < endY && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                int number = array[i][start];
                System.out.print(number + ",");
            }
        }
    }
}

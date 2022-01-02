package com.gl.algorithm.array;

public class ArraySearch {

    //顺序查找
    int SequenceSearch(int a[], int value, int n)
    {
        int i;
        for(i=0; i<n; i++)
            if(a[i]==value)
                return i;
        return -1;
    }

    //二分查找（折半查找），版本1
    int BinarySearch1(int a[], int value, int n)
    {
        int low, high, mid;
        low = 0;
        high = n-1;
        while(low<=high)
        {
            mid = (low+high)/2;
            if(a[mid]==value)
                return mid;
            if(a[mid]>value)
                high = mid-1;
            if(a[mid]<value)
                low = mid+1;
        }
        return -1;
    }
    //插值查找
    int InsertionSearch(int a[], int value, int low, int high)
    {
        int mid = low+(value-a[low])/(a[high]-a[low])*(high-low);
        if(a[mid]==value)
            return mid;
        if(a[mid]>value)
            return InsertionSearch(a, value, low, mid-1);
        if(a[mid]<value)
            return InsertionSearch(a, value, mid+1, high);
        return -1;
    }

    /* 斐波那契排序 */
    /* 输出：9 */
    static int FibonacciSearch(int [] a, int n, int key){
        int [] F = {0,1,1,2,3,5,8,13,21,34};
        int low, high, mid, i, k;
        low = 1;
        high = n;
        k = 0;
        while (n > F[k]-1) /* 计算n位于斐波那契数列的位置 */
            k++;

        while (low <= high) {
            mid = low + F[k-1] -1;
            if (key < a[mid]){
                high = mid - 1;
                k = k - 1;
            }
            else if (key > a[mid]){
                low = mid + 1;
                k = k - 2;
            }
            else {
                if (mid <= n)
                    return mid;
                else
                    return n;
            }
        }
        return -1;
    }


}

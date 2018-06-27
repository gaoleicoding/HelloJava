package com.gaolei.java_lib.arraymovefromk;

import java.util.Arrays;


/**
 * Created by gaolei on 2018/6/27.
 */

public class ArrayMove {
    private static void trans(int []a,int n,int k){
        for(int i=n-1;i>=k;i--)
            swap(a,i,i-k);
        if((n-k)%k==0)
            return ;
        else
            trans(a,k,k-(n-k)%k);
    }
        public static void swap(int []a,Integer i, Integer k) {
        Integer temp;
        temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }
public static void move1(int []a,int n,int k){

    for(int i=0;i<k;i++){
        int t=a[n-k+i];
        for(int j=0;j<n-k;j++){
            a[n-k+i-j]=a[n-k+i-j-1];
        }
        a[i]=t;
    }
}
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
//        trans(array,9,3);
        move1(array,9,3);
        System.out.print(Arrays.toString(array));
    }

}

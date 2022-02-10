package com.gyan.demo.algo.array;

public class SwapSort {

    public static void solve(int[] arr,int n){

        int i=0;
        while (i<n){
            if(arr[i] != arr[arr[i]-1])
                swap(arr,i,arr[i]-1);
            else
                i++;
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

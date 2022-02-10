package com.gyan.demo.algo.array;

public class KadaneAlgorithm {

    //maximum sum subarray problem
    public static int solve1(int[] arr){
        int n = arr.length;
        int maxSoFar = Integer.MIN_VALUE;
        int currentMax = 0;

        for (int i = 0; i <n ; i++) {
            if(arr[i]+currentMax > arr[i]){
                currentMax+=arr[i];
            }else
                currentMax = arr[i];

            if(currentMax > maxSoFar){
                maxSoFar =currentMax ;
            }
        }
        return maxSoFar;
    }

    //optimized way of kadane algorithm
    public static int solve2(int[] arr){
        int currentMax=0;
        int maxSoFar = Integer.MIN_VALUE;
        for (int i:arr) {
            currentMax +=i;
            maxSoFar = currentMax>maxSoFar?currentMax:maxSoFar;
            if(currentMax<0)
                currentMax=0;
        }
        return maxSoFar;
    }
}

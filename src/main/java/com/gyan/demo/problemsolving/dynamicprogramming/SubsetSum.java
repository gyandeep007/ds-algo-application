package com.gyan.demo.problemsolving.dynamicprogramming;

import com.gyan.demo.util.Utility;

public class SubsetSum {

    // program to check whether an array have subset whose sum is equal to given sum
    //recursive approach
    public static boolean solve1(int[] arr ,int n,int sum) {
        if(n==0 && sum != 0)
            return false;
        if(n >= 0 && sum == 0)
            return true;

        if(arr[n-1] <= sum)
            return solve1(arr,n-1,sum-arr[n-1]) || solve1(arr,n-1,sum);
        else
            return solve1(arr,n-1,sum);
    }

        public static boolean solve2(int[] arr ,int n,int sum){
        boolean[][] t = new boolean[n+1][sum+1];
        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <sum+1 ; j++) {
                if(i==0)
                    t[i][j] = false;
                if(j==0)
                    t[i][j] = true;
            }
        }

        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <sum+1 ; j++) {
                if(arr[i-1] <= j)
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
            }
        }
        Utility.print2DArray(t,"item","sum");
        return t[n][sum];
    }

    //Equal sum partition
    public static boolean solve3(int[] arr,int n){
        int total = 0;
        for (int i = 0; i <arr.length ; i++) {
            total+=arr[i];
        }
        if(total % 2 != 0)
            return false;
        return solve2(arr,n,total/2);
    }

    //count subset sum recursive
    public static int solve4(int[] arr,int n,int sum,String output){
        if(sum == 0) {
            System.out.println(output);
            return 1;
        }
        if(n==0 && sum > 0)
            return 0;

        if(arr[n-1] <= sum)
            return solve4(arr,n-1,sum-arr[n-1],output+arr[n-1])+solve4(arr,n-1,sum,output);
        else
            return solve4(arr,n-1,sum,output);

    }

    // count subset sum memoization
    public static int solve5(int[] arr,int n,int sum,String output,int[][] t){
        if(sum == 0) {
            System.out.println("t["+n+"]["+sum+"] have sum zero");
            System.out.println(output);
            return 1;
        }
        if(n==0 && sum > 0)
            return 0;
        if(t[n][sum] != -1) {
            System.out.println("t["+n+"]["+sum+"] already calculated");
            if(sum == 0)
                System.out.println(output);
            return t[n][sum];
        }

        if(arr[n-1] <= sum)
            return t[n][sum] = solve5(arr,n-1,sum-arr[n-1],output+arr[n-1],t)+solve5(arr,n-1,sum,output,t);
        else
            return t[n][sum]=solve5(arr,n-1,sum,output,t);

    }

    //count subset sum tabular
    public static int solve6(int[] arr,int n,int sum){
        int[][] t = new int[n+1][sum+1];
        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <sum+1 ; j++) {
                if(i==0)
                    t[i][j] = 0;
                if(j==0)
                    t[i][j] = 1;
            }
        }

        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <sum+1 ; j++) {
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]]+t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }

    //minimum subset sum difference
    public static int solve7(int[] arr,int n){
        int sum = 0;
        for (int i:arr) {
            sum+=i;
        }
        boolean[][] t = new boolean[n+1][sum+1];
        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <sum+1 ; j++) {
                if(i==0)
                    t[i][j] = false;
                if(j==0)
                    t[i][j] = true;
            }
        }



        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <sum+1 ; j++) {
                if(arr[i-1] <= j)
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
            }
        }


        for (int i = sum/2; i>=0 ; i--) {
            if(t[n][i]){
                return Math.abs(2*i-sum);
            }
        }
        return sum;
    }

    //count of number of subset with given difference
    public static int solve8(int[] arr,int n,int k){
        int sum =0;
        for (int i:arr) {
           sum+=i;
        }
        int[][] t = new int[n+1][sum+1];

        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <sum+1 ; j++) {
                if(i==0)
                    t[i][j] = 0;
                if(j==0)
                    t[i][j] = 1;
            }
        }

        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <sum+1 ; j++) {
               if(arr[i-1] <= j)
                   t[i][j] = t[i-1][j-arr[i-1]]+t[i-1][j];
               else
                   t[i][j] = t[i-1][j];
            }
        }
        Utility.print2DArray(t,"item","sum");
        int totalCount =0;
        for (int i = (sum+k)/2; i-k >=0  ; i--) {
            totalCount+=i;
        }
        return totalCount;
    }
}

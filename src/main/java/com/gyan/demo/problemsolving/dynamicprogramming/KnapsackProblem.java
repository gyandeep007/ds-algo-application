package com.gyan.demo.problemsolving.dynamicprogramming;

import com.gyan.demo.util.Utility;

public class KnapsackProblem {
    static int[][] t;

    public static void initialize(int row,int col){
        t = new int[row+1][col+1];

        for (int i = 0; i <t.length ; i++) {
            for (int j = 0; j <t[i].length ; j++) {
                t[i][j] = -1;
            }
        }
    }

    public static int knapsack(int[] weight,int[] value,int W,int n){
        if(n==0 || W==0)
            return 0;


        if(weight[n-1] <= W) {
            return  Math.max(value[n - 1] +knapsack(weight, value, W - weight[n - 1], n - 1),
                                           knapsack(weight, value, W, n - 1)
                                          );
        }else {
            return knapsack(weight, value, W, n - 1);
        }
    }


    public static int knapsackMemoized(int[] weight,int[] value,int W,int n){
        if(n==0 || W==0)
            return 0;

        if(t[n][W] != -1) {
            System.out.println("value for item "+n+" for capacity W "+W+" already calculate");
            return t[n][W];
        }

        if(weight[n-1] <= W) {
            System.out.println("Item "+n+" can include or exclude because weight is "+weight[n-1]+" and capacity "+W);
            t[n][W-weight[n-1]] =value[n-1]+knapsackMemoized(weight,value,W-weight[n-1],n-1);
            t[n][W] = knapsackMemoized(weight, value, W, n - 1);
            return Math.max(t[n][W-weight[n-1]],t[n][W]);
//            return t[n][W] = Math.max(value[n - 1] +knapsackMemoized(weight, value, W - weight[n - 1], n - 1),
//                    knapsackMemoized(weight, value, W, n - 1)
//            );
        }else {
            System.out.println("Item "+n+" excluded because weight is "+weight[n-1]+" and capacity "+W);
            return t[n][W] = knapsack(weight, value, W, n - 1);
        }
    }

    public static int knapsackTabular(int[] weight,int[] value,int W,int n){
        int[][] t1 = new int[n+1][W+1];
        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <W+1 ; j++) {
                if(i==0 || j == 0)
                    t1[i][j] = 0;
            }
        }

        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <W+1 ; j++) {
                if(weight[i-1] <= j){
                    t1[i][j] = Math.max(value[i-1]+t1[i-1][j-weight[i-1]],t1[i-1][j]);
                }else{
                    t1[i][j] = t1[i-1][j];
                }
            }
        }
        Utility.print2DArray(t1,"item","weight");
        return  t1[n][W];
    }

}

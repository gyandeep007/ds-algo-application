package com.gyan.demo.problemsolving.dynamicprogramming;

import com.gyan.demo.util.Utility;

public class UnboundedKnapsack {
    static int[][] t ;

    public static void initialize(int row,int col,int val){
        t = new int[row+1][col+1];
        Utility.fill2DArray(t,-1);
    }
    //rod cutting problem way1
    public static int solve1(int[] price,int n,int L){
        if(n==0 || L == 0)
            return 0;

        if(n <= L)
            return Math.max(price[n-1]+solve1(price,n,L-n),solve1(price,n-1,L) );
        else
            return solve1(price,n-1,L);
    }

    //rod cutting problem way2
    public static int solve2(int[] price,int L){
        if(L == 0)
            return 0;

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <=L ; i++) {
            int cost = price[i-1]+solve2(price,L-i);
            max = Math.max(max,cost);
        }
        return max;
    }

    //rod cutting problem dp bottom up
    public static int solve3(int[] length,int[] price,int n,int L){
        int[][] t = new int[n+1][L+1];
        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <L+1 ; j++) {
                if(i==0 || j==0)
                    t[i][j] = 0;
            }
        }

        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <L+1 ; j++) {
                if(length[i-1] <= j)
                    t[i][j] = Math.max(price[i-1]+ t[i][j-length[i-1]],t[i-1][j]);
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[n][L];
    }

    //coin exchange simple recursion
    //Given an unlimited supply of coins of given denominations,
    // find the total number of distinct ways to get the desired change.
    public static int solve4(int[] coins,int n,int target){
        if(target == 0)
            return 1;
        if(n == 0 && target > 0)
            return 0;

        if(coins[n-1] <= target)
            return solve4(coins,n,target-coins[n-1])+ solve4(coins,n-1,target);
        else
            return solve4(coins,n-1,target);
    }

    //coin exchange problem dp top down
    //Given an unlimited supply of coins of given denominations,
    // find the total number of distinct ways to get the desired change.
    public static int solve5(int[] coins,int n,int target){
        if(target == 0)
            return 1;
        if(n == 0 && target > 0)
            return 0;

        if(t[n][target] != -1) {
            System.out.println("value for "+n+" and "+target+" already calculated");
            return t[n][target];
        }

        if(coins[n-1] <= target)
            return t[n][target] = solve5(coins,n,target-coins[n-1])+ solve5(coins,n-1,target);
        else
            return t[n][target] =solve5(coins,n-1,target);

    }
    //coin exchange problem dp bottom up
    //Given an unlimited supply of coins of given denominations,
    // find the total number of distinct ways to get the desired change.

    public static int solve6(int[] coins,int n,int target){
        int[][] t = new int[n+1][target+1];
        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <target+1 ; j++) {
                if(i == 0)
                    t[i][j] = 0;
                if(j == 0)
                    t[i][j] = 1;
            }
        }

        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <target+1 ; j++) {
                if(coins[i-1] <= j)
                    t[i][j]  = t[i][j-coins[i-1]]+t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
            }
        }

        return t[n][target];
    }

    //Coin change-making problem
    //Given an unlimited supply of coins of given denominations,
    // find the minimum number of coins required to get the desired change.

    public static int solve7(int[] coins,int n,int target){
        int[][] t = new int[n+1][target+1];
        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <target+1 ; j++) {
                 if(i==0)
                     t[i][j] = Integer.MAX_VALUE-1;
                 if(i!=0 && j==0)
                     t[i][j] = 0;
            }
        }


        for (int j = 1; j <target+1 ; j++) {
            if(j % coins[0] == 0)
                t[1][j] = j/coins[0];
            else
                t[1][j] = Integer.MAX_VALUE-1;
        }
        Utility.print2DArray(t,"coins","target");
        for (int i = 2; i <n+1 ; i++) {
            for (int j = 1; j <target+1 ; j++) {
                 if(coins[i-1] <= j)
                     t[i][j] = Math.min(1+t[i][j-coins[i-1]],t[i-1][j]);
                 else
                     t[i][j] = t[i-1][j];
            }
        }
        Utility.print2DArray(t,"coins","target");
        return t[n][target];

    }
}

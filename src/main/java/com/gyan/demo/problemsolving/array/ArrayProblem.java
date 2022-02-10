package com.gyan.demo.problemsolving.array;

import java.util.*;

public class ArrayProblem {

    //generate all the subarray of given array
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int ans = 0;
        int mn = prices[0];
        for(int i=0;i<n;i++)
        {
            if (prices[i] < mn)
                mn = prices[i];
            if(prices[i] > mn + fee)
            {
                ans += prices[i] - fee - mn;
                mn = prices[i] -fee ;
            }

        }
        return ans;

    }

    //print 2D matrix in spiral way
    public static void solve1(int[][] arr,int row,int col){
        int k=0;
        int l=0;

        while (k<row && l < col){
            for (int i = l; i <col ; i++) {
                System.out.print(arr[k][i]+"\t");
            }
            k++;
            for (int i = k; i <row ; i++) {
                System.out.print(arr[i][col-1]+"\t");
            }
            col--;
           if(k < row) {
               for (int i = col - 1; i >= l; i--) {
                   System.out.print(arr[row - 1][i]+"\t");
               }
               row--;
           }

          if(l < col) {
              for (int i = row - 1; i >= k; i--) {
                  System.out.print(arr[i][l]+"\t");
              }
              l++;
          }
        }
    }


    public static List<Integer> solve2(int k,List<Integer> amount){
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <amount.size() ; i++) {
            queue.add(i+1);
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            int person = queue.poll();
            if(amount.get(person-1) <= k){
                result.add(person);
            }else{
                amount.set(person-1,amount.get(person-1)-k);
                queue.add(person);
            }
        }

        return result;
    }

}

package com.gyan.demo.problemsolving.dynamicprogramming;

import com.gyan.demo.util.Utility;

public class LongestCommonSubsequence {
      static int[][] t ;

      public static void init(int m,int n){
          t = new int[m+1][n+1];
          Utility.fill2DArray(t,-1);
      }
    //Longest Common Subsequence Problem
    //The Longest Common Subsequence (LCS) problem is finding the longest subsequence
    // present in given two sequences in the same order,
    // i.e., find the longest sequence which can be obtained from the first original
    // sequence by deleting some items and from the second original sequence by deleting other items.

    public static int solve1(String str1,int m,String str2,int n){
        if(m == 0 || n == 0)
            return 0;



        if(str1.charAt(m-1) == str2.charAt(n-1))
            return 1 + solve1(str1,m-1,str2,n-1);
        else
            return  Math.max(solve1(str1,m,str2,n-1),solve1(str1,m-1,str2,n));
    }


    // adding top down approach to LCS
    public static int solve2(String str1,int m,String str2,int n){
        if(m == 0 || n == 0)
            return 0;

        if (t[m][n] != -1 ) {
            System.out.println("value already calculated");
            return t[m][n];
        }

        if(str1.charAt(m-1) == str2.charAt(n-1))
            return t[m][n] =1 + solve2(str1,m-1,str2,n-1);
        else
            return t[m][n] = Math.max(solve2(str1,m,str2,n-1),solve2(str1,m-1,str2,n));
    }

    //adding bottom up dp
    public static int solve3(String str1,String str2,int m,int n){
          int[][] t = new int[m+1][n+1];
        for (int i = 0; i <m+1 ; i++) {
            for (int j = 0; j <n+1 ; j++) {
                if(i==0 || j == 0)
                    t[i][j] = 0;
            }
        }

        for (int i = 1; i <m+1 ; i++) {
            for (int j = 1; j <n+1 ; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
            }
        }
        int i = m;
        int j = n;
        String output = "";
         while (i>0 && j >0){
             int max  = Math.max(t[i-1][j],t[i][j-1]);
             if(t[i][j] > max){
                 output=output+str2.charAt(j-1);
                 i = i-1;
                 j=j-1;

             }else{
                 if(t[i-1][j]>=t[i][j-1])
                   i=i-1;
                 else
                   j=j-1;
             }


         }
        System.out.println("Longest common subsequence "+output);
        Utility.print2DArray(t,"first String","Second String");
        return t[m][n];
    }


    //longest common substring
    public static int solve4(String s1,String s2,int m,int n,int count){
          if(m==0 || n==0)
              return 0;


        if(s1.charAt(m-1) == s2.charAt(n-1)) {

            count= solve4(s1,s2,m-1,n-1,count+1);
          }


           return Math.max(count,Math.max( solve4(s1, s2, m - 1, n ,0),solve4(s1,s2,m,n-1,0)));

    }
}

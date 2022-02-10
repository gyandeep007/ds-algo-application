package com.gyan.demo.problemsolving.dynamicprogramming;

import com.gyan.demo.util.Utility;

import java.util.HashMap;
import java.util.Map;

public class MatrixChainMultiplication {

    //creating matrix for top down dp
   static int[][] t = new int[4][4];

    static int[][] t1 ;

   static Map<String,Boolean> map = new HashMap<>();

    static {
        Utility.fill2DArray(t,-1);

    }

    public static void init(int k,int n){
        t1 = new int[k+1][n+1];
        Utility.fill2DArray(t1,-1);
    }
    //Matrix chain multiplication problem:
    //Determine the optimal parenthesizing of a product of n matrices.

    public static int solve1(int[] arr,int i,int j){
        if(i >= j)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i; k <j ; k++) {
            int cost = solve1(arr,i,k)+solve1(arr,k+1,j)+(arr[i-1]*arr[k]*arr[j]);

            if(cost < min)
                min = cost;

        }
       return min;
    }


    // applying top down dp to matrix chain multiplication
    public static int solve2(int[] arr,int i,int j){
        if(i >= j)
            return 0;

        if(t[i][j] != -1) {
            System.out.println(" value already calculated for "+i+","+j );
            return t[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k <j ; k++) {
            int cost = solve2(arr,i,k)+solve2(arr,k+1,j)+(arr[i-1]*arr[k]*arr[j]);

            if(cost < min)
                min = cost;

        }
        return t[i][j] =min;
    }


    //scrambled string
    public static boolean solve3(String input1,String input2){

        if(input1.length() != input2.length())
            return false;
        if(input1.equals(input2))
            return true;

        if(input1.length() <= 1 || input2.length() <= 1)
            return false;

        int n = input1.length();
        boolean isScrambled = false;
        for (int i = 1; i <n ; i++) {
            if(
                    (solve3(input1.substring(0,i),input2.substring(n-i,n))
                            &&
                     solve3(input1.substring(i,n),input2.substring(0,n-i))
                    )
                    ||
                   (
                    solve3(input1.substring(0,i),input2.substring(0,i))
                    &&
                    solve3(input1.substring(i,n-i),input2.substring(i,n-i))
                    )
            ){
                isScrambled = true;
                break;
            }
        }

        return isScrambled;

    }


    //scrambled string adding top down dp
    public static boolean solve4(String input1,String input2){

        if(input1.length() != input2.length())
            return false;
        if(input1.equals(input2))
            return true;

        if(input1.length() <= 1 || input2.length() <= 1)
            return false;

        String key = input1+"_"+input2;

        if(map.containsKey(key)) {
            System.out.println("Value returned frm cache for the key "+key);
            return map.get(key);
        }

        int n = input1.length();
        boolean isScrambled = false;
        for (int i = 1; i <n ; i++) {
            if(
                    (solve4(input1.substring(0,i),input2.substring(n-i,n))
                            &&
                            solve4(input1.substring(i,n),input2.substring(0,n-i))
                    )
                            ||
                            (
                                    solve4(input1.substring(0,i),input2.substring(0,i))
                                            &&
                                            solve4(input1.substring(i,n-i),input2.substring(i,n-i))
                            )
            ){
                isScrambled = true;
                break;
            }
        }
        map.put(key,isScrambled);
        return  isScrambled;

    }

    //egg drop problem
    //k number of eggs, n number of floors
    public static int solve5(int k,int n){

        if(n == 0 || n ==1)
            return n;

        if(k==1)
            return n;



        int min = Integer.MAX_VALUE;
        for(int i =1;i<=n;i++){
            int breaks = solve5(k-1,i-1);
            int unbreak = solve5(k,n-i);
            int temp = 1+Math.max(breaks,unbreak);

            min = Math.min(min,temp);
        }

        return min;
    }

    //egg drop problem adding top down dp
    //k number of eggs, n number of floors
    public static int solve6(int k,int n){

        if(n == 0 || n ==1)
            return n;

        if(k==1)
            return n;

       if(t1[k][n] != -1) {
           System.out.println("value already calculated");
           return t1[k][n];
       }

        int min = Integer.MAX_VALUE;
        for(int i =1;i<=n;i++){
            int breaks = solve6(k-1,i-1);
            int unbreak = solve6(k,n-i);
            int temp = 1+Math.max(breaks,unbreak);

            min = Math.min(min,temp);
        }

        return t1[k][n] =min;
    }
}

package com.gyan.demo.problemsolving.dynamicprogramming;

import com.gyan.demo.util.Utility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubsetSumTest {

    @Test
    void solve1() {
        int[] arr = {2,3,7,8,10};
        int sum = 11;
        System.out.println(SubsetSum.solve1(arr,5,sum));
    }

    @Test
    void testSolve1() {
        int[] arr = {2,3,7,8,10};
        int sum = 11;
        System.out.println(SubsetSum.solve2(arr,5,sum));
    }

    @Test
    void solve3() {
        int[] arr = {1,5,13,5};
        int n = 4;
        System.out.println(SubsetSum.solve3(arr,4));
    }

    @Test
    void solve4() {
        int[] arr ={3, 1, 1, 2, 2, 1};
        int sum = 5;
        int n = arr.length;
        System.out.println(SubsetSum.solve4(arr,n,sum,""));
    }

    @Test
    void solve4V1() {
        int[] arr ={2,3,5,6,8,10};
        int sum = 10;
        int n = arr.length;
        System.out.println(SubsetSum.solve4(arr,n,sum,""));
    }

    @Test
    void solve5() {
        int[] arr ={3, 1, 1, 2, 2, 1};
        int sum = 5;
        int n = arr.length;
        int[][] t = new int[n+1][sum+1];
        Utility.fill2DArray(t,-1);
        System.out.println(SubsetSum.solve5(arr,n,sum,"",t));
    }

    @Test
    void solve5V1() {
        int[] arr ={2,3,5,6,8,10};
        int sum = 10;
        int n = arr.length;
        int[][] t = new int[n+1][sum+1];
        Utility.fill2DArray(t,-1);
        System.out.println(SubsetSum.solve5(arr,n,sum,"",t));
    }

    @Test
    void solve6V1() {
        int[] arr ={2,3,5,6,8,10};
        int sum = 10;
        int n = arr.length;
        System.out.println(SubsetSum.solve6(arr,n,sum));
    }

    @Test
    void solve6V2() {
        int[] arr ={3, 1, 1, 2, 2, 1};
        int sum = 5;
        int n = arr.length;
        System.out.println(SubsetSum.solve6(arr,n,sum));
    }

    @Test
    void solve7V1() {
        int[] arr ={1,6,11,5};
        int n = arr.length;
        System.out.println(SubsetSum.solve7(arr,n));
    }

    @Test
    void solve7V2() {
        int[] arr ={10, 20, 15, 5, 25};
        int n = arr.length;
        System.out.println(SubsetSum.solve7(arr,n));
    }

    @Test
    void solve8() {
        int[] arr ={1,1,2,3};
        int n = arr.length;
        int k =1;
        System.out.println(SubsetSum.solve8(arr,n,k));
    }
}

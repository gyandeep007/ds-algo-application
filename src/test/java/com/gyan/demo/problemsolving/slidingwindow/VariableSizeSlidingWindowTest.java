package com.gyan.demo.problemsolving.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariableSizeSlidingWindowTest {

    @Test
    void solve1() {
        int[] arr = {4,1,1,1,2,3,5};
        int sum = 8;
        System.out.println("Maximum subarray "+VariableSizeSlidingWindow.solve1(arr,sum));
    }

    @Test
    void solve2() {
        String input = "aabacbebebe";
        int k = 3;
        System.out.println("Length of longest substring with "+k+" unique character is "+VariableSizeSlidingWindow.solve2(input,k));
    }

    @Test
    void solve3T1() {
        String input = "GEEKSFORGEEKS";
        System.out.println("Length of longest substring with all unique character is "+VariableSizeSlidingWindow.solve3(input));
    }

    @Test
    void solve3T2() {
        String input = "ABDEFGABEF";
        System.out.println("Length of longest substring with all unique character is "+VariableSizeSlidingWindow.solve3(input));
    }

    @Test
    void solve5() {
       String s = "ADOBECODEBANC";
       String t = "ABC";
        System.out.println(VariableSizeSlidingWindow.solve5(s,t));
    }
}

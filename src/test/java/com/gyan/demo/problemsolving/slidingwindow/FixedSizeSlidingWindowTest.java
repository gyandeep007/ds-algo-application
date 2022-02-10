package com.gyan.demo.problemsolving.slidingwindow;

import org.junit.jupiter.api.Test;

import java.util.List;


class FixedSizeSlidingWindowTest {

    @Test
    void solve1() {
        int[] arr = {2,5,1,8,2,9,1};
        int k =3;
        System.out.println("sum of subarray of size "+k+" is "+FixedSizeSlidingWindow.solve1(arr,k));
    }

    @Test
    void solve2() {
        int[] arr = {6,2,8,3,4,7,1};
        int r = 7;
        int[] result = FixedSizeSlidingWindow.solve2(arr,r);
        for (int i:result) {
            System.out.print(i+"\t");
        }
    }

    @Test
    void solve3() {
        int[] arr = {2,5,1,8,2,9,1};
        int k =3;
        System.out.println("sum of subarray of size "+k+" is "+FixedSizeSlidingWindow.solve3(arr,k));
    }

    @Test
    void solve4() {
        int[] arr = {12,-1,-7,8,-15,30,16,28};
        int k = 3;
        System.out.println("First negative number of subarray of size "+k+" is ");
        List<Integer> result = FixedSizeSlidingWindow.solve4(arr,k);
        for (int i:result) {
            System.out.print(i+"\t");
        }
    }

    @Test
    void solve5T1() {
        String input = "forxxorfxdofr";
        String ptr = "for";
        System.out.println("Number of anagrams is  "+FixedSizeSlidingWindow.solve5(input,ptr));
    }

    @Test
    void solve5T2() {
        String input = "aabaabaa";
        String ptr = "aaba";
        System.out.println("Number of anagrams is  "+FixedSizeSlidingWindow.solve5(input,ptr));
    }

    @Test
    void solve6() {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k =3;
        List<Integer> result = FixedSizeSlidingWindow.solve6(arr,k);
        for (int i:result) {
            System.out.print(i+"\t");
        }
    }
}

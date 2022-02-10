package com.gyan.demo.algo.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void solve1T1() {
        int[] arr = {2, 3, 5, 7, 9};
        int target = 7;
        BinarySearch.solve1(arr,target);
    }

    @Test
    void solve1T2() {
        int[] arr = {1, 4, 5, 8, 9};
        int target = 2;
        BinarySearch.solve1(arr,target);
    }

    @Test
    void solve2T1() {
        int[] arr = {2, 3, 5, 7, 9};
        int target = 7;
       int index = BinarySearch.solve2(arr,0,arr.length-1,target);
        System.out.println("Element found at index "+index);
    }

    @Test
    void solve2T2() {
        int[] arr = {1, 4, 5, 8, 9};
        int target = 2;
     int index =   BinarySearch.solve2(arr, 0, arr.length - 1, target);
        System.out.println("Element found at index " + index);
    }

    @Test
    void solve3T1() {
        int[] arr = {20,17,15,14,13,12,10,9,8,4};
        int target = 4;
        int index =   BinarySearch.solve3(arr, target);
        System.out.println("Element found at index " + index);

    }

    @Test
    void solve3T2() {
        int[] arr = {20,17,15,14,13,12,10,9,8,4};
        int target = 20;
        int index =   BinarySearch.solve3(arr, target);
        System.out.println("Element found at index " + index);

    }

    @Test
    void solve4() {
        int[] arr = {2,4,10,10,1018,20};
        int target = 10;
        int index =   BinarySearch.solve4(arr, target);
        System.out.println("Element found at index " + index);
    }

    @Test
    void solve5() {
        int[] arr = {2,4,10,10,10,18,20};
        int target = 10;
        int index =   BinarySearch.solve5(arr, target);
        System.out.println("Element found at index " + index);
    }

    @Test
    void solve6() {
        int[] arr = {2,4,10,10,10,18,20};
        int target = 10;
        int count =   BinarySearch.solve6(arr, target);
        System.out.println("Element count is " + count);
    }

    @Test
    void solve7T1() {
        int[] arr = {6,8,11,12,15,18,2,5};
        System.out.println("number of rotation is "+BinarySearch.solve7(arr));
    }

    @Test
    void solve7T2() {
        int[] arr = {2,5,6,8,11,12,15,18};
        System.out.println("number of rotation is "+BinarySearch.solve7(arr));
    }

    @Test
    void solve7T3() {
        int[] arr = {5,6,8,11,12,15,18,2};
        System.out.println("number of rotation is "+BinarySearch.solve7(arr));
    }

    @Test
    void solve8() {
        int[] arr = {1,2,3,4,8,10,10,12,19};
        int element = 17;
        System.out.println("number of rotation is "+BinarySearch.solve8(arr,element));

    }

    @Test
    void solve9() {
        int[] arr = {1,2,3,4,8,10,10,12,19};
        int element = 17;
        System.out.println("number of rotation is "+BinarySearch.solve9(arr,element));
    }
}

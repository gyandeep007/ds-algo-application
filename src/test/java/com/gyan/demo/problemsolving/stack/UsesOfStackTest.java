package com.gyan.demo.problemsolving.stack;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsesOfStackTest {

    @Test
    void solve1() {

        int[] arr = {1,3,0,0,1,2,4};
        List<Integer> result = UsesOfStack.solve1(arr);
        Collections.reverse(result);
        System.out.println(result);
    }

    @Test
    void solve2() {
        int[] arr = {1,3,0,0,1,2,4};
        List<Integer> result = UsesOfStack.solve2(arr);
       // Collections.reverse(result);
        System.out.println(result);
    }

    @Test
    void solve2T2() {
        int[] arr = {1,3,2,4};
        List<Integer> result = UsesOfStack.solve2(arr);
        // Collections.reverse(result);
        System.out.println(result);
    }

    @Test
    void solve3() {
        int[] arr = {4,5,2,10,8};
        List<Integer> result = UsesOfStack.solve3(arr);
        System.out.println(result);
    }

    @Test
    void solve4() {
        int[] arr = {4,5,2,10,8};
        List<Integer> result = UsesOfStack.solve4(arr);
         Collections.reverse(result);
        System.out.println(result);
    }

    @Test
    void solve5() {
        int[] arr = {6,2,5,4,5,1,6};
        System.out.println("Max Area = "+UsesOfStack.solve5(arr));
    }

    @Test
    void solve6() {
        int[][] arr = {{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
        System.out.println("Max Area ="+UsesOfStack.solve6(arr));
    }
}

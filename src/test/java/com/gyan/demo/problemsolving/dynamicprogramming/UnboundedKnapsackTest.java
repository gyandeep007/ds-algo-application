package com.gyan.demo.problemsolving.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnboundedKnapsackTest {

    @Test
    void solve1() {
        int[] price = {1, 5, 8, 9};
        int L =4;
        int n = 4;
        System.out.println(UnboundedKnapsack.solve1(price,n,L));
    }

    @Test
    void solve2() {
        int[] price = {1, 5, 8, 9};
        int L =4;
        int n = 4;
        System.out.println(UnboundedKnapsack.solve2(price,L));
    }

    @Test
    void solve3() {
        int[] length = {1,2,3,4};
        int[] price = {1, 5, 8, 9};
        int L =4;
        int n = 4;
        System.out.println(UnboundedKnapsack.solve3(length,price,n,L));
    }

    @Test
    void solve4() {
        int[] coins = { 1, 3, 5, 7 };
        int target = 8;
        System.out.println(UnboundedKnapsack.solve4(coins,4,target));
    }

    @Test
    void solve5() {
        int[] coins = { 1, 3, 5, 7 };
        int target = 8;
        UnboundedKnapsack.initialize(4,target,-1);
        System.out.println(UnboundedKnapsack.solve5(coins,4,target));
    }

    @Test
    void solve6() {
        int[] coins = { 1, 3, 5, 7 };
        int target = 8;
        System.out.println(UnboundedKnapsack.solve6(coins,4,target));
    }

    @Test
    void solve7() {
        int[] coins = {  3, 5, 7 };
        int target = 15;
        System.out.println(UnboundedKnapsack.solve7(coins,3,target));
    }
}

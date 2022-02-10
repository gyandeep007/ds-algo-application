package com.gyan.demo.problemsolving.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayProblemTest {

    @Test
    void maxProfit() {
        int[] input = {1,3,7,5,10,3};
        int fee = 3;
        System.out.println(ArrayProblem.maxProfit(input,fee));
    }

    @Test
    public void solve1(){
        int[][] arr = {
                        {1,2,3,4,5},
                        {16,17,18,19,6},
                        {15,24,25,20,7},
                        {14,23,22,21,8},
                        {13,12,11,10,9}
                       };
        ArrayProblem.solve1(arr,5,5);
    }

    @Test
    void solve2() {

        List<Integer> amount = Arrays.asList(1,3,2);
        int k=2;
        List<Integer> ans = ArrayProblem.solve2(k,amount);
        System.out.println(ans);
    }
}

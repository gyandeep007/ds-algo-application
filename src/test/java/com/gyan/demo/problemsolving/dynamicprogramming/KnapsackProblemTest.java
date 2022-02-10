package com.gyan.demo.problemsolving.dynamicprogramming;

import com.gyan.demo.util.Utility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackProblemTest {

    @Test
    void knapsack1() {
        int[] weight = {1,2,3,8,7,4};
        int[] value =  {20,5,10,40,15,25};
        int capacity = 10;
        KnapsackProblem.initialize(6,10);
       int maxProfit = KnapsackProblem.knapsackMemoized(weight,value,capacity,6);
        System.out.println("Max Profit = "+maxProfit);
    }

    @Test
    void knapsack2() {
        int[] weight = {1,3,4,5};
        int[] value =  {1,4,5,7};
        int capacity = 7;
        KnapsackProblem.initialize(4,7);
        int maxProfit = KnapsackProblem.knapsackMemoized(weight,value,capacity,4);
        System.out.println("Max Profit = "+maxProfit);
       // Utility.print2DArray(KnapsackProblem.t,"item","weight");
    }

    @Test
    void knapsack3() {
        int[] weight = {1,3,4,5};
        int[] value =  {1,4,5,7};
        int capacity = 7;
        KnapsackProblem.initialize(4,7);
        int maxProfit = KnapsackProblem.knapsackTabular(weight,value,capacity,4);
        System.out.println("Max Profit = "+maxProfit);
        // Utility.print2DArray(KnapsackProblem.t,"item","weight");
    }
    @Test
    void knapsack4() {
        int[] weight = {1,2,3,8,7,4};
        int[] value =  {20,5,10,40,15,25};
        int capacity = 10;
        KnapsackProblem.initialize(6,11);
        int maxProfit = KnapsackProblem.knapsackTabular(weight,value,capacity,6);
        System.out.println("Max Profit = "+maxProfit);
        // Utility.print2DArray(KnapsackProblem.t,"item","weight");
    }
}

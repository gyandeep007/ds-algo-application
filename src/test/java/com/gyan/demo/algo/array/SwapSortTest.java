package com.gyan.demo.algo.array;

import com.gyan.demo.util.Utility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapSortTest {

    @Test
    void solveT1() {
        int[] arr = {2,3,1,5,1};
        Utility.printArray(arr);
        SwapSort.solve(arr,arr.length);
        Utility.printArray(arr);
    }

    @Test
    void solveT2() {
        int[] arr = {2,3,1,5,1};
        Utility.printArray(arr);
        SwapSort.solve(arr,arr.length);
        Utility.printArray(arr);
    }
}

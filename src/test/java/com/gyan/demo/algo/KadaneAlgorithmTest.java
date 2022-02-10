package com.gyan.demo.algo;

import com.gyan.demo.algo.array.KadaneAlgorithm;
import org.junit.jupiter.api.Test;

class KadaneAlgorithmTest {

    @Test
    void solve1T1() {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum sum "+ KadaneAlgorithm.solve1(arr));
    }

    @Test
    void solve1T2() {
        int[] arr = {4,1};
        System.out.println("Maximum sum "+KadaneAlgorithm.solve1(arr));
    }

    @Test
    void solve2() {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum sum "+KadaneAlgorithm.solve2 (arr));
    }
}

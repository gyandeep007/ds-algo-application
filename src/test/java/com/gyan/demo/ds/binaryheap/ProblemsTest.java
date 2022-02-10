package com.gyan.demo.ds.binaryheap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProblemsTest {

    @Test
    void solve1() {
        int[] stream = {1,10,2,9,3,8,4,7,5,6};
        int k =5;
        Problems.solve1(stream,k);
    }
}

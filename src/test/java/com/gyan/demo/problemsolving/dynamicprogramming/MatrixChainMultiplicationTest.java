package com.gyan.demo.problemsolving.dynamicprogramming;

import com.gyan.demo.util.Utility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixChainMultiplicationTest {

    @Test
    void solve1() {
        int[] dims = { 10, 30};
        //we have to choose the value of i and j
        //since first matrix will be at second index that is 1 so value of i will be 1
        //since the last matrix will be at last index so value of j is length of array-1
        int i = 1;
        int j = dims.length-1;
        int totalMinimumCost =  MatrixChainMultiplication.solve1(dims,i,j);
        System.out.println("Total Minimum Cost = "+totalMinimumCost);
    }

    @Test
    void solve2() {
        int[] dims = { 10, 30,5,60};
        //we have to choose the value of i and j
        //since first matrix will be at second index that is 1 so value of i will be 1
        //since the last matrix will be at last index so value of j is length of array-1
        int i = 1;
        int j = dims.length-1;
        int totalMinimumCost =  MatrixChainMultiplication.solve2(dims,i,j);
        System.out.println("Total Minimum Cost = "+totalMinimumCost);
        Utility.print2DArray(MatrixChainMultiplication.t,"i","j");
    }

    @Test
    void solve3() {
        String input = "great";

    }

    @Test
    void testSolve3() {
        System.out.println(MatrixChainMultiplication.solve3("great","taegr"));
    }

    @Test
    void solve4() {
        System.out.println(MatrixChainMultiplication.solve4("great","ategr"));
    }

    @Test
    void solve5() {
        int k =6;
        int n =10000;
        System.out.println(MatrixChainMultiplication.solve5(k,n));
    }

    @Test
    void solve6() {
        int k =6;
        int n =10000;
        MatrixChainMultiplication.init(k+1,n+1);
        System.out.println(MatrixChainMultiplication.solve6(k,n));
    }

    @Test
    void referenceTest() {
       Integer a =new Integer(10);
        System.out.println(a);
        test1(a);
        System.out.println(a);

    }

    void test1(Integer b){
        b = b+10;
    }
}

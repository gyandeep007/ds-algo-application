package com.gyan.demo.algo.recursion;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RecursionProblemTest {

    @Test
    void solve1() {
        Instant t1 = Instant.now();
        RecursionProblem.solve1V1(1000);
        Instant t2 = Instant.now();
        System.out.println();
        System.out.println("time taken head recursion "+ Duration.between(t1,t2).getNano());

        Instant  t3 = Instant.now();
        RecursionProblem.solve1V2(1,1000);
        Instant t4 = Instant.now();
        System.out.println();
        System.out.println("time taken tail recursion "+ Duration.between(t3,t4).getNano());

    }

    @Test
    void solve2() {
        int[] items = {5,9,7,4,3,1,2,6,8,10};
        print(items,0,9);
        RecursionProblem.solve2(items,0,9);
        print(items,0,9);
    }

    private void print(int[] items,int start,int end){
        for (int i = start; i <= end ; i++) {
            System.out.print(items[i] +" ");
        }
        System.out.println();
    }

    @Test
    void solve3() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(0);
        stack.push(2);
        System.out.println("before sorting");
        System.out.println(stack);
        RecursionProblem.solve3(stack);
        System.out.println("after  sorting");
        System.out.println(stack);

    }

    @Test
    void solve4() {
        int N=4;
        for (int i = 1; i <=Math.pow(2,N-1) ; i++) {
            System.out.println( RecursionProblem.solve4(N,i));
        }
    }

    @Test
    void solve6() {
        RecursionProblem.solve6("abc","");
    }


    @Test
    void nullTest() {
        String item1 = "";
        String item2 = "";
        HashSet<String> list = new HashSet<>();
        list.add(item1);
        list.add(item2);
        System.out.println("size of list is "+list.size());
        System.out.println("list contains item1 "+list.contains(item1));
        System.out.println("list contains item2 "+list.contains(item2));


    }

    @Test
    void solve7() {
        RecursionProblem.solve7("aab","",new HashSet<String>());
    }

    @Test
    void solve8() {
        RecursionProblem.solve8("abc","");
    }

    @Test
    void solve9() {
        RecursionProblem.solve9("abc","");
    }

    @Test
    void solve10() {
        RecursionProblem.solve10("a1B2","");
    }

    @Test
    void solve11() {
        RecursionProblem.solve11(3,3,"");
    }

    @Test
    void solve12() {
        RecursionProblem.solve12(5,0,0,"");
    }

    @Test
    void solve13() {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=40;i++) {
            list.add(i);
        }
        System.out.println("Last member "+ RecursionProblem.solve13(list,40,6));
    }

    @Test
    void solve14() {
        int[] input = {4,15,3,42,23,26,43};
        System.out.println("Maximum element in the given array is "+RecursionProblem.solve14(input,6));
    }

    @Test
    void solve11Backtrack() {
        RecursionProblem.solve11Backtrack(3,3,new ArrayList<>());
    }

    @Test
    void solve15() {
        char[][] grid = {
                {'a','b','c','e'},
                {'s','f','c','s'},
                {'a','d','e','e'}
        };
       String word = "abccedx";
        System.out.println(" searched "+RecursionProblem.solve15(grid,0,0,3,5,0,word,"",new HashSet<String>()));
    }

    @Test
    void solve15T1() {
        char[][] grid = {
                {'a','b','c','e'},
                {'s','f','c','s'},
                {'a','d','e','e'}
        };
        String word = "asfd";
        System.out.println(" searched "+RecursionProblem.solve15(grid,0,0,3,5,0,word,"",new HashSet<String>()));
    }

    @Test
    void solve16() {
        int n =4;
        int N = 4 ;
        int[][] board = new int[n][n];
        int row = 0;
        int col = 0;
        RecursionProblem.solve16(board,row,col,n,N,new HashSet<>());
    }

    @Test
    void solve17() {
        RecursionProblem.solve17("abc","");
    }

    @Test
    void testSolve16() {
    }
}

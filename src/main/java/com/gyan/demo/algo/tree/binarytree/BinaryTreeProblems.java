package com.gyan.demo.algo.tree.binarytree;

public class BinaryTreeProblems {

    // wap to count the number of structurally unique binary trees
    public static int solve1(int numNodes){
        if(numNodes <= 1){
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= numNodes ; i++) {
            int countLeftTree = solve1(i-1);
            int countRightTree = solve1(numNodes-i);
            sum = sum + (countLeftTree * countRightTree);
        }
        return sum;
    }
}

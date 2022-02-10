package com.gyan.demo.problemsolving.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {

    @Test
    void solve1() {
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        System.out.println("Length of longest common subsequence is "+LongestCommonSubsequence.solve1(str1,str1.length(),str2,str2.length()));
    }

    @Test
    void solve2() {
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        LongestCommonSubsequence.init(str1.length(),str2.length());
        System.out.println("Length of longest common subsequence is "+LongestCommonSubsequence.solve2(str1,str1.length(),str2,str2.length()));
    }

    @Test
    void solve3() {
        String str1 = "BDCABA";
        String str2 = "ABCBDAB";

        System.out.println("Length of longest common subsequence is "+LongestCommonSubsequence.solve3(str1,str2,str1.length(),str2.length()));

    }

    @Test
    void solve4() {
        String s1 = "ABCABCD";
        String s2 = "ABDABCD";
        System.out.println("result = "+LongestCommonSubsequence.solve4(s1,s2,s1.length(),s2.length(),0));
    }

    @Test
    void testSolve4() {
    }
}

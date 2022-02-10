package com.gyan.demo.problemsolving.stack;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UsesOfStack {

    //nearest greater to right
    public static List<Integer> solve1(int[] arr){
        int n = arr.length;
        List<Integer> nearestGreaterList = new ArrayList<>();
        Stack<Integer> stack  =new Stack<>();

        for (int end = n-1; end >=0 ; end--) {
            if(stack.isEmpty()){
                nearestGreaterList.add(-1);
            }else if(!stack.isEmpty() && arr[end] < stack.peek()){
                nearestGreaterList.add(stack.peek());
            }else if(!stack.isEmpty() && arr[end] >= stack.peek()){
                while (!stack.isEmpty() && arr[end] >= stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    nearestGreaterList.add(-1);
                }else
                    nearestGreaterList.add(stack.peek());
            }

            stack.push(arr[end]);
        }
        return nearestGreaterList;
    }

    //nearest greater to left
    public static List<Integer> solve2(int[] arr){
    //    int start=0;
        int n = arr.length;
        List<Integer> listNGL = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int start = 0; start < n ; start++) {
            if(stack.empty()){
                listNGL.add(-1);
            }else if(!stack.empty() && arr[start] < stack.peek()){
                listNGL.add(stack.peek());
            }else if(!stack.empty() && arr[start] >= stack.peek()){
                while (!stack.empty() && arr[start] >= stack.peek()){
                    stack.pop();
                }
                if(stack.empty())
                    listNGL.add(-1);
                else
                    listNGL.add(stack.peek());
            }
            stack.push(arr[start]);
        }
        return listNGL;
    }

    //nearest smaller to left
    public static List<Integer> solve3(int[] arr){
        int n = arr.length;
        List<Integer> listNSL = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int start = 0; start < n; start++) {
            if(stack.empty()){
                listNSL.add(-1);
            }else if(!stack.empty() && arr[start] > stack.peek()){
                listNSL.add(stack.peek());
            }else if(!stack.empty() && arr[start] <= stack.peek()){
                while (!stack.empty() && arr[start] <= stack.peek()){
                    stack.pop();
                }
                if(stack.empty())
                    listNSL.add(-1);
                else
                    listNSL.add(stack.peek());
            }
            stack.push(arr[start]);
        }
        return listNSL;
    }

    //nearest smaller to right
    public static List<Integer> solve4(int[] arr){
        int n = arr.length;
        List<Integer> listNSR = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int end = n-1; end >= 0 ; end--) {
            if(stack.empty()){
                listNSR.add(-1);
            }else if(!stack.empty() && arr[end] > stack.peek()){
                listNSR.add(stack.peek());
            }else if(!stack.isEmpty() && arr[end] <= stack.peek()){
                while (!stack.empty() && arr[end] <= stack.peek()){
                    stack.pop();
                }
                if(stack.empty()){
                    listNSR.add(-1);
                }else {
                    listNSR.add(stack.peek());
                }
            }
            stack.push(arr[end]);
        }
        return listNSR;
    }

    //maximum area histogram
    public static int solve5(int[] arr){
        int n = arr.length;
        int[] nsl = calculateNSL(arr);
        int[] nsr = calculateNSR(arr);

        int[] width = new int[n];

        for (int i = 0; i < width.length ; i++) {
            width[i] = nsr[i]-nsl[i]-1;
        }

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            if(arr[i]*width[i] > maxArea){
                maxArea = arr[i]*width[i];
            }
        }
        return maxArea;
    }

    private static int[] calculateNSR(int[] arr) {
        int n = arr.length;
        int[] nsr = new int[n];
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        for (int i = n-1; i >=0 ; i--) {
            if(stack.isEmpty()){
                nsr[i] = n;
            }else if(!stack.empty() && arr[i] > stack.peek().getValue()){
                nsr[i] = stack.peek().getKey();
            }else if(!stack.isEmpty() && arr[i] <= stack.peek().getValue()){
                while (!stack.isEmpty() && arr[i] <= stack.peek().getValue()){
                    stack.pop();
                }
                if(stack.empty())
                    nsr[i] = n;
                else
                    nsr[i] = stack.peek().getKey();
            }
            stack.push(new Pair<>(i,arr[i]));
        }
        return nsr;
    }

    private static int[] calculateNSL(int[] arr) {
        int n = arr.length;
        int[] nsl = new int[n];
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        for (int i = 0; i <n ; i++) {
            if(stack.isEmpty()){
                nsl[i] = -1;
            }else if(!stack.isEmpty() && arr[i] > stack.peek().getValue()){
                nsl[i] = stack.peek().getKey();
            }else if(!stack.empty() && arr[i] <= stack.peek().getValue()){
                while (!stack.empty() && arr[i] <= stack.peek().getValue()){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    nsl[i] = -1;
                }else{
                    nsl[i] = stack.peek().getKey();
                }
            }
            stack.push(new Pair<>(i,arr[i]));
        }
        return nsl;
    }

    //calculate maximum area rectangle in binary matrix
    public static int solve6(int[][] arr){
        int[] floor=new int[arr.length];


        int maxArea = solve5(arr[0]);
        for (int i = 1; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if(i==0)
                    floor[j] = 0;
                else
                    floor[j] = arr[i-1][j]+arr[i][j];
            }
            int currentMax = solve5(floor);
            if(currentMax > maxArea){
                maxArea = currentMax;
            }
        }
        return maxArea;
    }
}

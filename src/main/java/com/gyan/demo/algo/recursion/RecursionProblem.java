package com.gyan.demo.algo.recursion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RecursionProblem {

    // print 1 to n  head recursion
    public static void solve1V1(int n){
        if(n==0)
            return;


        solve1V1(n-1);
        System.out.print(n+"-->");
    }

    //print 1 to n tail recursion
    public static void solve1V2(int i,int n){
        if(i > n)
            return;

        System.out.print(i+"-->");
        solve1V2(i+1,n);
    }

    // sort an array using recursion
    public static void solve2(int[] items,int startIndex,int endIndex){
        if(startIndex == endIndex)
            return;

          int key = items[endIndex];
          solve2(items,startIndex,endIndex-1);
          mergeItem(items,startIndex,endIndex-1,key);
    }

    private static void mergeItem(int[] items, int startIndex, int endIndex, int key) {
        if(startIndex == endIndex){
          if(key < items[endIndex]){
             items[endIndex+1] = items[endIndex];
              items[endIndex] = key;
              return;
          }


        }

        if(key > items[endIndex]){
            items[endIndex+1] = key;
            return;
        }



        int temp = items[endIndex];
        mergeItem(items,startIndex,endIndex-1,key);
        items[endIndex+1] = temp;
    }

    //sort an stack
    public static void solve3(Stack<Integer> stack){
        if(stack.size() == 1){
            return;
        }

        int key = stack.pop();
        solve3(stack);
        insert(stack,key);

    }

    private static void insert(Stack<Integer> stack, int key) {
        if(stack.size() == 1){
            if(key < stack.peek()){
              int temp =  stack.pop();
              stack.push(key);
              stack.push(temp);
              return;
            }
        }

        if(key > stack.peek()){
            stack.push(key);
            return;
        }

        int temp = stack.pop();
        insert(stack,key);
        stack.push(temp);

    }

    //generate kth symbol grammar
    // base condition N = 1 and K=1 => 0

    public static boolean solve4(int N,int K){
        if(N ==1 && K == 1){
            return false;
        }

        int mid =(int) Math.pow(2,N-1)/2;
        if( K <= mid)
            return solve4(N-1,K);
        else
            return !solve4(N-1,K-mid);
    }
   // tower of hanoi
    public void solve5(int N,char source,char destination,char auxiliary){
        if(N == 1){
            System.out.println("move dist"+N+" from "+source+" to "+destination);
        }

        solve5(N-1,source,auxiliary,destination);
        System.out.println("move disk "+N+" from "+source+" to "+destination);
        solve5(N-1,auxiliary,destination,source);


    }

    //print all subsets
    public static void solve6(String input,String output){
        if(input.length() == 0){
            System.out.println("{"+output+"}");
            return;
        }

        solve6(input.substring(0,input.length()-1),output);
        solve6(input.substring(0,input.length()-1),output+input.charAt(input.length()-1));
    }

    //print unique subsets
    public static void solve7(String input, String output, HashSet<String> unique){

        if(input.length() == 0){
            if(!unique.contains(output)){
                unique.add(output);
                System.out.println("{"+output+"}");
            }
            return;
        }

        solve7(input.substring(1),output,unique);
        solve7(input.substring(1),output+input.charAt(0),unique);
    }

    //permutation with spaces
    public static void solve8(String input,String output){
     if(input.length() == 0){
         System.out.println("{"+output+"}");
         return;
     }


        if(output.length() == 0){
            solve8(input.substring(1),output+input.charAt(0));
        }else{
            solve8(input.substring(1),output+input.charAt(0));
            solve8(input.substring(1),output+"_"+input.charAt(0));
        }
    }

    //permutation with case change
    public static void solve9(String input, String output){
        if(input.length() == 0){
            System.out.println("{"+output+"}");
            return;
        }

        solve9(input.substring(1),output+input.charAt(0));
        solve9(input.substring(1),output+Character.toUpperCase(input.charAt(0)));

    }

    //letter case permutation
    public static void solve10(String input, String output) {
        if (input.length() == 0) {
            System.out.println("{" + output + "}");
            return;
        }

        if(Character.isDigit(input.charAt(0)))
            solve10(input.substring(1),output+input.charAt(0));
        else{
            solve10(input.substring(1),output+input.charAt(0));
            solve10(input.substring(1),output+(Character.isUpperCase(input.charAt(0))?
                                                     Character.toLowerCase(input.charAt(0)):Character.toUpperCase(input.charAt(0))));

        }

    }

    // balanced parenthesis
    public static void solve11(int opening,int closing,String output){
         if(opening == 0 && closing == 0){
             System.out.println("{"+output+"}");
             return;
         }

         if(opening > 0){
             solve11(opening-1,closing,output+"(");
         }
         if(closing > opening){
             solve11(opening,closing-1,output+")");
         }
    }

    public static void solve11Backtrack(int opening,int closing,List<String> output){
        if(opening == 0 && closing == 0){
            System.out.println(output);
            return;
        }

        if(opening > 0){
            output.add("(");
            solve11Backtrack(opening-1,closing,output);
            output.remove(output.size()-1);
        }
        if(closing > opening){
            output.add(")");
            solve11Backtrack(opening,closing-1,output);
            output.remove(output.size()-1);
        }
    }

    //balanced parenthesis backtracking approach

    //generate all binary number of size n having number of 1's greater than or equal to number of 0's
    public static void solve12(int n,int one,int zero,String output){
        if(n == 0){
            System.out.println("{"+output+"}");
            return;
        }

        if( n > 0){
            solve12(n-1,one+1,zero,output+"1");
        }
        if(zero < one){
            solve12(n-1,one,zero+1,output+"0");
        }
    }

    //josephus problem
    public static int solve13(List<Integer> list,int killerIndex,int k){
        if(list.size() == 1)
            return list.get(0);

        int killedIndex = (killerIndex+k) % list.size();
        list.remove(killedIndex);
       return solve13(list,killedIndex,k);
    }

    //finding maximum number in an array using recursion
    public static int solve14(int[] input,int pos){
        if(pos == 0)
            return input[pos];

        int current = input[pos];
        int max = solve14(input,pos-1);
        return max> current?max:current;
    }


    //searching word in a grid time complexity m*n = N
    // N* pow(3,l) where l is the length of string
    // here 3 comes because after moving from one cell to another cell we have only 3 option
    // because we can't go to that direction from where we came
    public static boolean solve15(char[][] grid, int i, int j, int m, int n, int pos, String word, String temp, Set<String> visited){

        if(word.equals(temp))
            return true;

        if(i < 0 || i>= m || j < 0 || j >= n)
            return false;

        String key = i+"_"+j;
        if(visited.contains(key))
            return false;

        if(grid[i][j] == word.charAt(pos)){
            temp = temp+grid[i][j];
            key = i+"_"+(j);
            visited.add(key);
            boolean left  =   solve15(grid,i,j-1,m,n,pos+1,word,temp,visited);//left
//            visited.remove(key);
//            key = i+"_"+(j+1);
//            visited.add(key);
            boolean right =   solve15(grid,i,j+1,m,n,pos+1,word,temp,visited);//right
//            visited.remove(key);
//            key = (i-1)+"_"+(j);
//            visited.add(key);
            boolean up    =   solve15(grid,i-1,j,m,n,pos+1,word,temp,visited);//up
//            visited.remove(key);
//            key = (i+1)+"_"+(j);
//            visited.add(key);
            boolean down =    solve15(grid,i+1,j,m,n,pos+1,word,temp,visited);//down
            visited.remove(key);
            return left||right||up||down;
        }else{
//            key = i+"_"+(j);
//            visited.add(key);
//            boolean left  =   solve15(grid,i,j-1,m,n,pos,word,temp,visited);//left
////            visited.remove(key);
////            key = i+"_"+(j-1);
////            visited.add(key);
//            boolean right =  solve15(grid,i,j+1,m,n,pos,word,temp,visited);//right
////            visited.remove(key);
////            key = i+"_"+(j-1);
////            visited.add(key);
//            boolean up  =solve15(grid,i-1,j,m,n,pos,word,temp,visited);//up
////            visited.remove(key);
////            key = i+"_"+(j-1);
////            visited.add(key);
//            boolean down =  solve15(grid,i+1,j,m,n,pos,word,temp,visited);//down
//            visited.remove(key);
//            return left||right||up||down;
            return false;
        }
    }

    //N-Queen problem
    public static void solve16(int[][] board,int row,int col,int n,int N,Set<String> output){
        if(N == 0) {
            System.out.println(output);
            return;
        }


        for (int i = 0; i <n ; i++) {
            if(isValid(board,row,i,n)) {
                String index = row + "_" + i;
                output.add(index);
                board[row][i] = 1;
                solve16(board,row+1,0,n,N-1,output);
                output.remove(index);
                board[row][i] = 0;
            }
        }
    }

    public static boolean isValid(int[][] board,int row,int col,int n){
        if(board[row][col] == 1)
            return false;

        //checking for row
        for (int i = 0; i <=col ; i++) {
            if(board[row][i] == 1)
                return false;
        }

        //checking for column
        for (int i = 0; i <=row ; i++) {
            if(board[i][col] == 1)
                return false;
        }

        // checking for diagonals
        int i = row-1;
        int j = col-1;
        while (i>=0 && j >= 0){
            if(board[i][j] == 1)
                return false;
            i--;
            j--;
        }

         i = row-1;
         j = col+1;
        while (i>=0 && j < n){
            if(board[i][j] == 1)
                return false;
            i--;
            j++;
        }

        return true;
    }

    //permutation of a string
    public static void solve17(String input,String output){
        if(input.length() == 0) {
            System.out.println(output);
         return;
        }

        for (int i = 0; i <input.length() ; i++) {
            solve17(input.substring(0,i)+input.substring(i+1),output+input.charAt(i));
        }
    }
}

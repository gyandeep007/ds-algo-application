package com.gyan.demo.problemsolving.dynamicprogramming;

public class BinaryTree {

    public static int solve(Node root,Result result){
        if(root == null)
            return 0;

        int left = solve(root.left,result);
        int right = solve(root.right,result);

        int temp = 1 +Math.max(left,right);
        int ans = Math.max(temp,1+left+right);

        result.setResult(Math.max(result.getResult(),ans));
        System.out.println("At node "+root.data+" temp = "+temp+" ans ="+ans+" result ="+result);
        return temp;

    }











        static class Node{
        int data;
        Node left;
        Node right;

           public Node(int data){
               this.data = data;

           }

            public Node getLeft() {
                return left;
            }

            public void setLeft(Node left) {
                this.left = left;
            }

            public Node getRight() {
                return right;
            }

            public void setRight(Node right) {
                this.right = right;
            }
        }


        static class Result{
        int result;

            public int getResult() {
                return result;
            }

            public void setResult(int result) {
                this.result = result;
            }

            @Override
            public String toString() {
                return "Result{" +
                        "result=" + result +
                        '}';
            }
        }
}

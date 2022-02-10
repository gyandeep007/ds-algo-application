package com.gyan.demo.ds.tree.binarytree;

public class BinaryTreeProblems {

    //program to check given tree is full binary tree
    public static boolean solve1(Node root){
        if(root == null)
            return true;

        if(root.left == null && root.right == null)
            return true;

        if(root.left != null && root.right != null)
            return solve1(root.left) && solve1(root.right);

        return false;
    }

    //program to check given tree complete binary tree
      // calculate depth
      public static int depth(Node root){
        int d = 0;
        while (root != null){
            d++;
            root = root.left;
        }
        return d;
      }

      public static boolean is_perfect(Node node,int depth,int level){
        if(node == null)
            return true;

        if(node.left == null && node.right == null)
            return depth == level+1;

        if(node.left == null || node.right == null)
            return false;
        return is_perfect(node.left,depth,level+1) && is_perfect(node.right,depth,level+1);
      }

      //program to print all the path from root to leaf
    public static void solve2(Node root,String output){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            System.out.println(output+root.data);
            return;
        }

        output = output+root.data+"-->";
        solve2(root.left,output);
        solve2(root.right,output);

    }
      public static boolean is_perfect(Node root){
        int d = depth(root);
        return  is_perfect(root,d,0);
      }


      public static int findOptimalPoint(int[] blocks){
        if(blocks.length == 2){
            return -1;
        }
        for(int i=1;i<blocks.length-1;i++){
            if(blocks[i-1] >= blocks[i] && blocks[i] <= blocks[i+1] )
                return i;
        }
        return -1;
      }

      public  static int solve(int[] blocks){
        int optimalPoint = findOptimalPoint(blocks);
        if(optimalPoint == -1){
            optimalPoint = 0;
            int i = optimalPoint;
            while (i < blocks.length-1 && blocks[i] <= blocks[i+1]){
                i++;
            }
            return i+1;
        }else{
            int i = optimalPoint;
            int j = optimalPoint;
            while (i>0 && blocks[i-1] >= blocks[i]){
                i--;
            }
            while (j < blocks.length-1 && blocks[j] <=  blocks[j+1]){
                j++;
            }
            return j-i+1;
        }
      }


    public static void main(String[] args) {
        int[] blocks= {2,6,8,5 };
        System.out.println(solve(blocks));
    }

}

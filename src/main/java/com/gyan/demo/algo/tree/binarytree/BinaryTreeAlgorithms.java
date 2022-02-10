package com.gyan.demo.algo.tree.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeAlgorithms {

    // binary tree traversal
      // breadth first traversal or level order traversal
    //1. iterative way time complexity O(n) where n is total number of nodes
    public static void solve1(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new ArrayDeque();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.data+"\t");

            if(node.left != null)
                queue.add(node.left);

            if(node.right != null)
                queue.add(node.right);
        }

    }
    //2. iterative way print level wise
     public static void  solve2(Node root){
        if(root == null)
            return;
         Queue<Node> queue = new ArrayDeque<>();
         int count=0;
         queue.add(root);
         while (true){
             count = queue.size();
             if(count == 0)
                 break;
             while (count > 0){
                 Node current = queue.poll();
                 count--;
                 System.out.print(current.data+"\t");

                 if(current.left != null)
                     queue.add(current.left);
                 if(current.right != null)
                     queue.add(current.right);
             }
             System.out.println();
         }
     }

     //3. recursive way  time complexity O(n2)
    private static boolean solve3(Node root,int level){
        if(root == null)
            return false;
        if(level == 1){
            System.out.print(root.data+"\t");
            return true;
        }

            boolean left = solve3(root.left,level-1);
            boolean right =  solve3(root.right,level-1);
            return left || right;

    }

    private static boolean solve3(Node root,int level,int space,boolean printSpace){
        if(root == null)
            return false;
        if(level == 1){
            if(printSpace)
                System.out.printf("%"+space+"s","");
            System.out.print(root.data+"\t");
            return true;
        }

        boolean left = solve3(root.left,level-1,space-1,true);
        boolean right =  solve3(root.right,level-1,space-1,false);
        return left || right;

    }

    public static void solve3(Node root){
        int level = 1;
        while (solve3(root,level,3,true)){
            level++;
            System.out.println();
        }
    }


    // depth first traversal
     //1. PreOrder traversal
      // recursive way
     public static void solve4(Node root){
        if(root == null)
            return;

         System.out.print(root.data+"\t");
         solve4(root.left);
         solve4(root.right);
     }


     // iterative way
    public static void solve5(Node root){
        if(root == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            Node current = stack.pop();
            System.out.print(current.data+"\t");
            if(current.right != null)
                stack.push(current.right);
            if(current.left != null)
                stack.push(current.left);
        }
    }

    //2. inorder traversal
    public static void solve6(Node root){
        if(root != null){
            solve6(root.left);
            System.out.print(root.data+"\t");
            solve6(root.right);
        }
    }

    // iterative way
    public static void solve7(Node root){
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                current = stack.pop();
                System.out.print(current.data+"\t");
                current = current.right;
            }
        }
    }

    //3. post oder traversal recursive way
    public static void solve8(Node root){
        if(root != null){
            solve8(root.left);
            solve8(root.right);
            System.out.print(root.data+"\t");
        }
    }

    // post order iterative way using 2 stack
    public static void solve9(Node root){
        if(root == null)
            return;
        Stack<Node> s = new Stack<>();
        Stack<Node> t = new Stack<>();
        s.push(root);
        while (!s.isEmpty()){
            Node current = s.pop();
            t.push(current);
            if(current.left != null){
                s.push(current.left);
            }
            if(current.right != null){
                s.push(current.right);
            }
        }

        while (!t.isEmpty()){
            System.out.print(t.pop().data+"\t");
        }
    }

    // post order iterative way using 1 stack
    public static void solve10(Node root){
        if(root == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (!stack.isEmpty() || current != null){
            if(current != null){
                if(current.right != null)
                    stack.push(current.right);

                stack.push(current);
                current = current.left;
            }else{
                current = stack.pop();
                if(current!= null &&(!stack.isEmpty() && current.right == stack.peek())){
                    Node temp = stack.pop();
                    stack.push(current);
                    current = temp;
                }else{
                    System.out.print(current.data+"\t");
                    current = null;
                }
            }
        }
    }

}

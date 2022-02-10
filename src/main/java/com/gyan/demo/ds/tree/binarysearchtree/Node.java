package com.gyan.demo.ds.tree.binarysearchtree;

import lombok.Data;

@Data
public class Node {
   int data;
   Node left;
   Node right;

   public Node(int key){
       this.data = key;
       left = null;
       right = null;
   }
}

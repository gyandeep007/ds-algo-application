package com.gyan.demo.ds.array.staticarray;

import com.gyan.demo.ds.array.exceptions.ArrayEmpty;
import com.gyan.demo.ds.array.exceptions.ArrayFull;

public class MyArray {
   private int[] bucket;
   private int count=0;

    public MyArray(int size) {
        this.bucket = new int[size];
        this.count = 0;
    }
    public MyArray(int[] bucket) {
        this.bucket = bucket;
        this.count = bucket.length;
    }

    // insert operation
        //1.insert at first position
        public void insertAtFirst(int key){
         if(isFull()){
             throw new ArrayFull("array is full");
         }
         int i=count;
         while (i > 0){
             bucket[i] = bucket[i-1];
             i--;
         }

         bucket[0] = key;
         count++;
        }
         //2. insert at last position
        public void insertAtLast(int key){
          if(isFull()){
              throw new ArrayFull("array is full");
          }
          bucket[count++] = key;
        }
          // insert at given index
        public void insertAtIndex(int index,int key){
          if(isFull()){
              throw new ArrayFull("array is full");
          }
          if(!isValid(index)){
              throw new RuntimeException("index is not valid");
          }

          for(int i=count-1;i>=index;i--){
              bucket[i+1] = bucket[i];
          }
          bucket[index] = key;
          count++;

        }

        //delete operation
      //1. delete from first
      public int delete(){
        if(isEmpty()){
            throw  new ArrayEmpty("array is empty");
        }
        int temp = bucket[0];
        for(int i=0;i<count-1;i++){
            bucket[i] = bucket[i+1];
        }
        count--;
        return temp;
      }

      //2. delete from last
      public int deleteFromLast(){
        if(isEmpty()){
            throw new ArrayEmpty("Array is empty");
        }
       int temp = bucket[count--];
        return temp;
      }

      //3. delete at given index
        public int deleteAtIndex(int index){
            if(isEmpty()){
                throw new ArrayEmpty("Array is empty");
            }
            if(!isValid(index)){
                throw new RuntimeException("index is not valid");
            }

            int temp = bucket[index];
            for(int i = index;i<count-1;i++){
                bucket[i] = bucket[i+1];
            }
            count--;
            return temp;
        }

    public boolean isFull(){
        return count == bucket.length;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isValid(int index){
        return index >= 0 && index < count;
    }

    public void print(){
        for(int i=0;i<count;i++){
            System.out.print(bucket[i]+" ");
        }
    }


}

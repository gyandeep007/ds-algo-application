package com.gyan.demo.ds.binaryheap;

public class MinHeap<T extends Comparable> extends Heap<T> {


    public MinHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    public MinHeap(Class<T> clazz) {
        super(clazz);
    }

    @Override
    public void siftDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int smallerIndex = -1;
        if(leftChildIndex != -1 && rightChildIndex != -1){
            smallerIndex = getElementAtIndex(leftChildIndex).compareTo(getElementAtIndex(rightChildIndex)) <0
                           ?leftChildIndex:rightChildIndex;
        }else if(leftChildIndex != -1){
            smallerIndex = leftChildIndex;
        }else if(rightChildIndex != -1){
            smallerIndex = rightChildIndex;
        }

        if(smallerIndex == -1){
            return;
        }

        if(getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index))<0){
            swap(smallerIndex,index);
            siftDown(smallerIndex);
        }
    }

    @Override
    public void siftUp(int index) {
        int parentIndex = getParentIndex(index);

        if(parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex))<0){
            swap(index,parentIndex);
            siftDown(parentIndex);
        }
    }


}

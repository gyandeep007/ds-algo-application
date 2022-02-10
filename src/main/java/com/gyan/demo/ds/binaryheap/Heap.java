package com.gyan.demo.ds.binaryheap;

import java.lang.reflect.Array;

public abstract class Heap<T extends Comparable> {
    private static int MAX_SIZE = 40;
    private T[] array;
    private int count = 0;

    public Heap(Class<T> clazz, int size) {
        this.array = (T[]) Array.newInstance(clazz, size);
    }

    public Heap(Class<T> clazz) {
        this.array = (T[]) Array.newInstance(clazz, MAX_SIZE);
    }

    public int getLeftChildIndex(int index) {
        int leftChildIndex = 2 * index + 1;
        if (!isValidIndex(leftChildIndex))
            return -1;
        return leftChildIndex;
    }

    public int getRightChildIndex(int index) {
        int rightChildIndex = 2 * index + 1;
        if (!isValidIndex(rightChildIndex))
            return -1;
        return rightChildIndex;
    }

    public int getParentIndex(int index) {
        if (!isValidIndex(index))
            return -1;

        return (index - 1) / 2;
    }

    protected void swap(int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == array.length;
    }

    public T getElementAtIndex(int index) {
        return array[index];
    }

    public boolean isValidIndex(int index) {
        return index >= 0 && index < count;
    }

    public void insert(T value) throws HeapFullException {
        if (isFull())
            throw new HeapFullException("heap is full");
        array[count] = value;
        siftUp(count);
        count++;

    }

    public T remove() throws HeapEmptyException {


        T temp = getHighestPriority();
        array[0] = array[count - 1];
        count--;
        siftDown(0);
        return temp;
    }

    public T getHighestPriority() throws HeapEmptyException {
        if (isEmpty())
            throw new HeapEmptyException("heap is empty");
        return array[0];
    }

    public abstract void siftDown(int index);

    public abstract void siftUp(int index);
}

package com.gyan.demo.ds.tree.binarysearchtree.generic;

public interface Tree<T> {
    public void traversal();
    public void insert(T data);
    public void delete(T data);
    public T getMin();
    public T getMax();
    public boolean search(T data);
}

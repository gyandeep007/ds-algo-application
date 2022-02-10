package com.gyan.demo.algo.graph.flownetwork;

import java.util.List;

public interface Graph {

    void addEdge(int vertex1,int vertex2,int capacity);
    void addEdge(char vertex1,char vertex2,int capacity);
    List<Integer> getAdjacentVertices(int vertex);
    List<Character> getAdjacentVertices(char vertex);
}

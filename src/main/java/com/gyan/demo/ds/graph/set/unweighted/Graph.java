package com.gyan.demo.ds.graph.set.unweighted;

import java.util.List;

public interface Graph {
    void addEdge(int v1,int v2);
    void addEdge(char v1,char v2);
    List<Integer> getAdjacentVertices(int v);
    List<Character> getAdjacentVertices(char v);
     List<Node> getVertices();
}

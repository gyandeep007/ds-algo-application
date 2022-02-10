package com.gyan.demo.ds.graph;

import java.util.List;

public interface Graph {

    void addEdge(int v1,int v2);
    List<Integer> getAdjacentVertices(int v);
}

package com.gyan.demo.ds.graph.set.weighted;

import com.gyan.demo.ds.graph.set.weighted.Node;

import java.util.List;

public interface Graph {

    void addEdge(int v1, int v2, int weight);

    void addEdge(char v1, char v2, int weight);

    List<Integer> getAdjacentVertices(int v);

    List<Character> getAdjacentVertices(char v);

    List<Node> getVertices();

    int getEdgeWeight(int v1, int v2);

    int getEdgeWeight(char v1, char v2);
}

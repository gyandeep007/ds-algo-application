package com.gyan.demo.ds.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrix<T> implements Graph{

    private int[][] adjacencyMatrix ;
    private int totalVertices;
    private GraphType graphType;

    public AdjacencyMatrix(int totalVertices){
        this(totalVertices,GraphType.UNDIRECTED);
    }

    public AdjacencyMatrix(int totalVertices, GraphType graphType) {
        adjacencyMatrix = new int[totalVertices][totalVertices];
        this.totalVertices = totalVertices;
        this.graphType = graphType;
    }

    @Override
    public void addEdge(int v1, int v2) {

         if(!isValidIndex(v1) || !isValidIndex(v2))
             return;

         adjacencyMatrix[v1][v2] = 1;

         if(graphType == GraphType.UNDIRECTED)
             adjacencyMatrix[v2][v1] = 1;
    }

    public boolean isValidIndex(int v){
        return v >= 0 && v < totalVertices;
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if(!isValidIndex(v))
            return null;

        List<Integer> adjacentVertices = new ArrayList<>();
        for (int i = 0; i <adjacencyMatrix.length ; i++) {
            if(adjacencyMatrix[v][i] == 1){
                adjacentVertices.add(i);
            }

        }
        Collections.sort(adjacentVertices);
        return adjacentVertices;
    }
}

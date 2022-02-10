package com.gyan.demo.algo.graph.flownetwork;

import java.util.*;

public class Node {
    private int vertexNumber;
    private boolean isVisited;
    private Map<Integer,Edge> adjacentVertices = new HashMap<>();

    public Node(int vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public void addEdge(int neighbour,Edge edge){
      //  adjacentVertices.put(neighbour,edge);
        adjacentVertices.put(neighbour,edge);
    }

    public void addEdge(int neighbour,int capacity){
        adjacentVertices.put(neighbour,new Edge(capacity,neighbour));
    }

    public List<Integer> getAdjacentVertices(){
        List<Integer> neighbours = new ArrayList<>(adjacentVertices.keySet());
        Collections.sort(neighbours);
        return neighbours;
    }
}

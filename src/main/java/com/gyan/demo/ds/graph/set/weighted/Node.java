package com.gyan.demo.ds.graph.set.weighted;

import java.util.*;

public class Node {
    private int vertexNumber;
    private boolean isVisited;
    private Map<Integer,Integer> adjacentVertices= new HashMap<>();

    public Node(int vertexNumber){
        this.vertexNumber = vertexNumber;
    }

    public void addEdge(int neighbour,int weight){
        adjacentVertices.put(neighbour,weight);
    }

    public List<Integer> getAdjacentVertices(){
        List<Integer> neighbours = new ArrayList<>(adjacentVertices.keySet());
        Collections.sort(neighbours);
        return neighbours;
    }

    public int getEdgeWeight(int neighbour){
      return   adjacentVertices.get(neighbour);
    }

    public int getVertexNumber() {
        return vertexNumber;
    }



    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}

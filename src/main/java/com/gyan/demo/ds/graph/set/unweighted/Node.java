package com.gyan.demo.ds.graph.set.unweighted;

import com.gyan.demo.ds.graph.GraphUtil;

import java.util.*;

public class Node {
   private int vertexNumber;
   private boolean visited;
    private boolean beingVisited;
    private Set<Integer> adjacentVertices = new HashSet<>();

    public Node(int vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public void addEdge(int v){
        adjacentVertices.add(v);
    }

    public List<Integer> getAdjacentVertices(){
        List<Integer> adjacentVerticesSortedList = new ArrayList<>(adjacentVertices);
        Collections.sort(adjacentVerticesSortedList);
        return adjacentVerticesSortedList;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    @Override
    public String toString() {
        return "Node{" +
                "vertexNumber=" + vertexNumber +
                ", adjacentVertices=" + adjacentVertices +
                '}';
    }

    public void printNode(){
        StringBuilder sb = new StringBuilder();
        sb.append("Node{vertexNumber="+ GraphUtil.itoc(vertexNumber)+",");
        sb.append("adjacentVertices=[");
        for (int i:adjacentVertices) {
            sb.append(GraphUtil.itoc(i)+"\t");
        }
        sb.append("]}");
        System.out.println(sb);
    }


}

package com.gyan.demo.algo.graph.flownetwork;

import com.gyan.demo.ds.graph.GraphUtil;

import java.util.ArrayList;
import java.util.List;

public class AdjacencySet implements Graph{

    private List<Node> vertices;
    private int totalVertices;

    public AdjacencySet(int totalVertices) {
        this.totalVertices = totalVertices;
        vertices = new ArrayList<>(totalVertices);
        for (int i=0;i<totalVertices;i++){
           vertices.add(new Node(i));
        }
    }

    @Override
    public void addEdge(int vertex1, int vertex2,int capacity) {
          if(!validIndex(vertex1) || !validIndex(vertex2))
              throw new IllegalArgumentException("index is not valid");

          vertices.get(vertex1).addEdge(vertex2,capacity);
    }

    @Override
    public void addEdge(char vertex1, char vertex2,int capacity) {
       int iVertex1 = GraphUtil.ctoi(vertex1);
       int iVertex2 = GraphUtil.ctoi(vertex2);
       addEdge(iVertex1,iVertex2,capacity);
    }

    @Override
    public List<Integer> getAdjacentVertices(int vertex) {
        if(!validIndex(vertex))
            throw new IllegalArgumentException("vertex index is not valid");

        return vertices.get(vertex).getAdjacentVertices();
    }

    @Override
    public List<Character> getAdjacentVertices(char vertex) {

        int iVertex = GraphUtil.ctoi(vertex);
        List<Integer> iNeighbours = getAdjacentVertices(iVertex);
        List<Character> cNeighbours = new ArrayList<>();
        for (int neighbour:iNeighbours) {
            cNeighbours.add(GraphUtil.itoc(neighbour));
        }
        return cNeighbours;
    }

    public boolean validIndex(int index){
        return index >= 0 && index < totalVertices;
    }
}

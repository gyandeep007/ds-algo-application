package com.gyan.demo.ds.graph.set.weighted;


import com.gyan.demo.ds.graph.GraphType;
import com.gyan.demo.ds.graph.GraphUtil;

import java.util.ArrayList;
import java.util.List;

public class AdjacencySet implements Graph{
    List<Node> vertices;
    int totalVertices;
    GraphType graphType;

    public AdjacencySet(int totalVertices) {
        this(totalVertices,GraphType.DIRECTED);
    }

    public AdjacencySet(int totalVertices, GraphType graphType) {
        this.totalVertices = totalVertices;
        this.graphType = graphType;
        vertices = new ArrayList<>();
        for (int i = 0; i <totalVertices ; i++) {
            vertices.add(new Node(i));
        }
    }

    @Override
    public void addEdge(int source, int destination, int weight) {
        if(!validIndex(source) || !validIndex(destination))
            throw new IllegalArgumentException();

        vertices.get(source).addEdge(destination,weight);
        if (graphType == GraphType.UNDIRECTED){
            vertices.get(destination).addEdge(source,weight);
        }
    }
    @Override
    public List<Integer> getAdjacentVertices(int vertex) {
        if(!validIndex(vertex))
            return null;

        List<Integer> neighbours = vertices.get(vertex).getAdjacentVertices();
        return neighbours;
    }

    @Override
    public int getEdgeWeight(int source, int neighbour) {
        if(!validIndex(source) || !validIndex(neighbour))
            throw new IllegalArgumentException();
        return vertices.get(source).getEdgeWeight(neighbour);
    }

    @Override
    public List<Node> getVertices() {
        return vertices;
    }

    public boolean validIndex(int index){
        return index>=0 && index < totalVertices;
    }

    @Override
    public void addEdge(char source, char destination, int weight) {
       int iSource = GraphUtil.ctoi(source);
       int iDestination = GraphUtil.ctoi(destination);
       addEdge(iSource,iDestination,weight);
    }



    @Override
    public List<Character> getAdjacentVertices(char vertex) {
        int iVertex = GraphUtil.ctoi(vertex);
        List<Integer> neighbours =  getAdjacentVertices(iVertex);
        List<Character> cNeighbours = new ArrayList<>();
        for (int i:neighbours) {
            cNeighbours.add(GraphUtil.itoc(i));
        }
        return cNeighbours;
    }





    @Override
    public int getEdgeWeight(char source, char neighbour) {
        int iSource = GraphUtil.ctoi(source);
        int iNeighbour = GraphUtil.ctoi(neighbour);
        return getEdgeWeight(iSource,iNeighbour);
    }


}

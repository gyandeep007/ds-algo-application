package com.gyan.demo.ds.graph.set.unweighted;

import com.gyan.demo.ds.graph.GraphType;
import com.gyan.demo.ds.graph.GraphUtil;

import java.util.ArrayList;
import java.util.List;

public class AdjacencySet implements Graph{

    List<Node> vertices;
    int totalVertices;
    GraphType graphType;

    public AdjacencySet(int totalVertices) {
        this(totalVertices,GraphType.UNDIRECTED);
    }

    public AdjacencySet(int totalVertices, GraphType graphType) {
        vertices = new ArrayList<>(totalVertices);
        this.totalVertices = totalVertices;
        this.graphType = graphType;
        for (int i = 0; i <totalVertices ; i++) {
            vertices.add(new Node(i));
        }

    }

    @Override
    public void addEdge(int v1, int v2) {
        if(!validIndex(v1) || !validIndex(v2))
            throw new IllegalArgumentException("either "+v1+" or "+v2+" is invalid");

        vertices.get(v1).addEdge(v2);
        if(graphType == GraphType.UNDIRECTED)
            vertices.get(v2).addEdge(v1);

    }

    @Override
    public void addEdge(char v1, char v2) {
        int  vertexIndex1 = GraphUtil.ctoi(v1);
        int vertexIndex2 = GraphUtil.ctoi(v2);
        addEdge(vertexIndex1,vertexIndex2);
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if(!validIndex(v))
            throw new IllegalArgumentException(v+" is invalid");
        return vertices.get(v).getAdjacentVertices();
    }

    @Override
    public List<Character> getAdjacentVertices(char v) {
        int vertexIndex = GraphUtil.ctoi(v);
        List<Character> neighbours = new ArrayList<>();
        for (int i:getAdjacentVertices(vertexIndex)) {
            neighbours.add(GraphUtil.itoc(i));
        }

        return neighbours;
    }

    public boolean validIndex(int index){
        return index >= 0 && index < totalVertices;
    }

    @Override
    public List<Node> getVertices(){
        return vertices;
    }
}

package com.gyan.demo.algo.graph.flownetwork;

public class Edge {
    private final int  capacity;
    private int flow;
    private int neighbour;



    public Edge(int capacity) {
        this.capacity = capacity;
        this.flow = 0;
    }

    public Edge(int capacity,int neighbour) {
        this.capacity = capacity;
        this.neighbour = neighbour;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    public int getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(int neighbour) {
        this.neighbour = neighbour;
    }
}

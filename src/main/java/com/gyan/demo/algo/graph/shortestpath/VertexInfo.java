package com.gyan.demo.algo.graph.shortestpath;

import com.gyan.demo.ds.graph.GraphUtil;

import java.util.Objects;

public class VertexInfo {
    private int vertexNumber;
    private int distance;

    public VertexInfo(int vertexNumber, int distance) {
        this.vertexNumber = vertexNumber;
        this.distance = distance;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VertexInfo that = (VertexInfo) o;
        return vertexNumber == that.vertexNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexNumber);
    }

    @Override
    public String toString() {
        return "VertexInfo{" +
                "vertexNumber=" + GraphUtil.itoc(vertexNumber) +
                ", distance=" + distance +
                '}';
    }
}

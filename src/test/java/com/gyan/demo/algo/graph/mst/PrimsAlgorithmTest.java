package com.gyan.demo.algo.graph.mst;

import com.gyan.demo.ds.graph.GraphType;
import com.gyan.demo.ds.graph.set.weighted.AdjacencySet;
import com.gyan.demo.ds.graph.set.weighted.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PrimsAlgorithmTest {
    Graph graph;

    @BeforeEach
    public void createGraph(){
        graph = new AdjacencySet(6, GraphType.UNDIRECTED);
        graph.addEdge('A','B',3);
        graph.addEdge('A','C',15);
        graph.addEdge('A','E',5);
        graph.addEdge('B','E',5);
        graph.addEdge('B','C',2);
        graph.addEdge('B','F',8);
        graph.addEdge('C','F',9);
        graph.addEdge('D','E',11);
        graph.addEdge('D','F',4);
        graph.addEdge('E','F',4);

    }
    @Test
    void solve() {
        Set<String> mst = PrimsAlgorithm.solve(graph,'F');
        for (String edge:mst) {
            System.out.println(edge);
        }
    }
}

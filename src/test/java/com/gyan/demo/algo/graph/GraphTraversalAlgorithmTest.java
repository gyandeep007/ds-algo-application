package com.gyan.demo.algo.graph;

import com.gyan.demo.ds.graph.set.unweighted.AdjacencySet;
import com.gyan.demo.ds.graph.set.unweighted.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTraversalAlgorithmTest {

    Graph graph;

    @BeforeEach
    public void createGraph(){
        graph = new AdjacencySet(5);
        graph.addEdge('A','B');
        graph.addEdge('A','C');
        graph.addEdge('B','D');
        graph.addEdge('B','E');
        graph.addEdge('C','E');
        graph.addEdge('D','E');

    }

    @Test
    void solve1() {
        GraphTraversalAlgorithm.solve1(graph,'A');
    }

    @Test
    void solve2() {
        GraphTraversalAlgorithm.solve2(graph,'A');
    }

    @Test
    void solve3() {
        boolean[] visited = new boolean[graph.getVertices().size()];
        GraphTraversalAlgorithm.solve3(graph,visited,'A');
    }

    @Test
    void solve4() {
        GraphTraversalAlgorithm.solve4(graph,'A');
    }
}

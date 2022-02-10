package com.gyan.demo.algo.graph;

import com.gyan.demo.ds.graph.GraphType;
import com.gyan.demo.ds.graph.set.unweighted.AdjacencySet;
import com.gyan.demo.ds.graph.set.unweighted.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class TopologicalSortTest {

    Graph graph;

    @BeforeEach
    public void createGraph(){
        graph = new AdjacencySet(5, GraphType.DIRECTED);
        graph.addEdge('A','B');
        graph.addEdge('A','C');
        graph.addEdge('B','D');
        graph.addEdge('C','E');
        graph.addEdge('E','B');
        graph.addEdge('E','D');
    }


    @Test
    void topologicalSort() {
        List<Character> sortedList = TopologicalSort.topologicalSort(graph);
        System.out.println(sortedList);
    }
}

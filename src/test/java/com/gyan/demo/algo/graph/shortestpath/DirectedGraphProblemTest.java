package com.gyan.demo.algo.graph.shortestpath;

import com.gyan.demo.ds.graph.GraphType;
import com.gyan.demo.ds.graph.set.unweighted.AdjacencySet;
import com.gyan.demo.ds.graph.set.unweighted.Graph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectedGraphProblemTest {

    Graph graph;

    @BeforeEach
    public void createGraph(){
        graph = new AdjacencySet(6, GraphType.DIRECTED);
        graph.addEdge('A','B');
        graph.addEdge('B','C');
        graph.addEdge('C','D');
        graph.addEdge('C','E');
        graph.addEdge('B','F');
     //   graph.addEdge('F','A');
    }

    @Test
    void hasCycle() {
        System.out.println("Cycle detected " +DirectedGraphProblem.hasCycle(graph,'A'));
    }

    @Test
    void mazeProblem() {
        int[][] map = {
                        {1,1,1,1,1},
                        {1,2,0,1,1},
                        {1,1,0,1,1},
                        {1,1,0,3,1},
                        {1,1,1,1,1}
                       };
        boolean[][] visited = new boolean[5][5];
        List<String> output = new ArrayList<>();
        DirectedGraphProblem.mazeProblem(map,visited,1,1,output);
        System.out.println(output);
    }
}

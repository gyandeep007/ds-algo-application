package com.gyan.demo.algo.graph.shortestpath;

import com.gyan.demo.ds.graph.GraphType;
import com.gyan.demo.ds.graph.GraphUtil;
import com.gyan.demo.ds.graph.set.weighted.AdjacencySet;
import com.gyan.demo.ds.graph.set.weighted.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DirectedNegativeWeightedTest {

    Graph graph;
    Graph graph1;

    @BeforeEach
    public void createGraph1(){
        graph = new AdjacencySet(5, GraphType.DIRECTED);
        graph.addEdge('A','B',2);
        graph.addEdge('A','C',1);
        graph.addEdge('B','D',3);
        graph.addEdge('B','E',-2);
        graph.addEdge('C','B',-5);
        graph.addEdge('C','E',2);
        graph.addEdge('E','D',1);

    }

    @BeforeEach
    public void createGraph2(){
        graph1 = new AdjacencySet(5, GraphType.DIRECTED);
        graph1.addEdge('A','B',-1);
        graph1.addEdge('A','C',4);
        graph1.addEdge('B','C',3);
        graph1.addEdge('B','D',2);
        graph1.addEdge('B','E',2);
        graph1.addEdge('D','B',1);
        graph1.addEdge('E','D',-3);

    }
    @Test
    void buildDistanceTable() {
      Map<Integer,DistanceInfo> distanceTable = DirectedNegativeWeighted.buildDistanceTable(graph,'A');
        System.out.println("Final Distance Table");
        GraphUtil.formatDistanceTable(distanceTable);
    }

    @Test
    void findShortestPath() {
        List<Character> shortestPath = DirectedNegativeWeighted.findShortestPath(graph, 'A', 'D');
       GraphUtil.printPath(shortestPath);
    }

    @Test
    void buildDistanceTable1() {
        Map<Integer,DistanceInfo> distanceTable = DirectedNegativeWeighted.buildDistanceTable(graph1,'A');
        System.out.println("Final Distance Table");
        GraphUtil.formatDistanceTable(distanceTable);
    }
    @Test
    void findShortestPath1() {
        List<Character> shortestPath = DirectedNegativeWeighted.findShortestPath(graph1, 'A', 'D');
        GraphUtil.printPath(shortestPath);
    }
}

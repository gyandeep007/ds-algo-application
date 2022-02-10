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

class DirectedWeightedGraphTest {

    Graph graph;
    Graph graph1;

    @BeforeEach
    public void createGraph(){
        graph = new AdjacencySet(5, GraphType.DIRECTED);
        graph.addEdge('A','B',2);
        graph.addEdge('A','C',3);
        graph.addEdge('B','D',2);
        graph.addEdge('C','E',6);
        graph.addEdge('E','B',5);
        graph.addEdge('E','D',4);

    }

    @BeforeEach
    public void createGraph1(){
        graph1 = new AdjacencySet(5, GraphType.DIRECTED);
        graph1.addEdge('A','B',10);
        graph1.addEdge('A','E',3);
        graph1.addEdge('B','C',2);
        graph1.addEdge('B','E',4);
        graph1.addEdge('C','D',9);
        graph1.addEdge('D','C',7);
        graph1.addEdge('E','B',1);
        graph1.addEdge('E','C',8);
        graph1.addEdge('E','D',2);

    }

    @Test
    void buildDistanceTable() {
        Map<Integer,DistanceInfo> distanceTable = DirectedWeightedGraph.buildDistanceTable(graph,'A');
        GraphUtil.formatDistanceTable(distanceTable);
    }

    @Test
    void findShortestPath() {
        List<Character> shortestPath = DirectedWeightedGraph.findShortestPath(graph, 'A', 'D');
        GraphUtil.printPath(shortestPath);
    }

    @Test
    void testBuildDistanceTable() {
        Map<Integer,DistanceInfo> distanceTable = DirectedWeightedGraph.buildDistanceTable(graph1,'A');
        GraphUtil.formatDistanceTable(distanceTable);
    }

    @Test
    void testFindShortestPath() {
    }
}

package com.gyan.demo.algo.graph.mst;

import com.gyan.demo.ds.graph.GraphType;
import com.gyan.demo.ds.graph.set.weighted.AdjacencySet;
import com.gyan.demo.ds.graph.set.weighted.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class KruskalAlgorithmTest {

    Graph graph;
    Graph graph1;
    Graph graph2;
          //  ;= new AdjacencyMatrixGraph(9, Graph.GraphType.UNDIRECTED);


    @BeforeEach
    public void createGraph1(){
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
    @BeforeEach
    public void createGraph() {
         graph1 = new AdjacencySet(9,GraphType.UNDIRECTED);
        graph1.addEdge(2, 7, 4);
        graph1.addEdge(0, 3, 2);
        graph1.addEdge(0, 4, 2);
        graph1.addEdge(0, 1, 1);
        graph1.addEdge(2, 1, 3);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(3, 5, 3);
        graph1.addEdge(3, 6, 2);
        graph1.addEdge(4, 7, 22);
        graph1.addEdge(7, 5, 4);
        graph1.addEdge(6, 5, 1);

       // spanningTree(graph1);
    }

    @BeforeEach
    public void createGraph2(){
        graph2 = new AdjacencySet(7,GraphType.UNDIRECTED);
        graph2.addEdge('A','B',7);
        graph2.addEdge('A','D',5);
        graph2.addEdge('B','C',8);
        graph2.addEdge('B','D',9);
        graph2.addEdge('B','E',7);
        graph2.addEdge('C','E',5);
        graph2.addEdge('D','E',15);
        graph2.addEdge('D','F',6);
        graph2.addEdge('E','F',8);
        graph2.addEdge('E','G',9);
        graph2.addEdge('F','G',11);



    }

    @Test
    void kruskal() {
        KruskalAlgorithm.kruskal(graph2);
    }

    @Test
    void getSortedEdges() {
        PriorityQueue<KruskalAlgorithm.EdgeInfo> sortedEdges = KruskalAlgorithm.getSortedEdges(graph);
        while (!sortedEdges.isEmpty()){
            System.out.println(sortedEdges.poll());
        }

    }

    @Test
    void testKruskal() {
    }
}

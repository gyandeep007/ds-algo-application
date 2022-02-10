package com.gyan.demo.ds.graph.set;

import com.gyan.demo.ds.graph.GraphType;
import com.gyan.demo.ds.graph.set.unweighted.AdjacencySet;
import com.gyan.demo.ds.graph.set.unweighted.Graph;
import com.gyan.demo.ds.graph.set.unweighted.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdjacencySetTest {

    Graph directedGraph ;
    Graph undirectedGraph ;

    @BeforeEach
    public void createDirectedGraph(){
        directedGraph = new AdjacencySet(5, GraphType.DIRECTED);
        directedGraph.addEdge('A','B');
        directedGraph.addEdge('A','C');
        directedGraph.addEdge('B','D');
        directedGraph.addEdge('C','E');
        directedGraph.addEdge('E','B');
        directedGraph.addEdge('E','D');
    }

    @BeforeEach
    public void createUndirectedGraph(){
        undirectedGraph = new AdjacencySet(5);
        undirectedGraph.addEdge('A','B');
        undirectedGraph.addEdge('A','C');
        undirectedGraph.addEdge('B','D');
        undirectedGraph.addEdge('C','E');
        undirectedGraph.addEdge('E','B');
        undirectedGraph.addEdge('E','D');
    }
    @Test
    void addEdge() {
        for (Node node:undirectedGraph.getVertices()) {
           node.printNode();
        }
    }
}

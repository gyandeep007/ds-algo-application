package com.gyan.demo.algo.graph;

import com.gyan.demo.ds.graph.GraphUtil;
import com.gyan.demo.ds.graph.set.unweighted.Graph;
import com.gyan.demo.ds.graph.set.unweighted.Node;

import java.util.*;

public class TopologicalSort {

    //program to calculate in degree
    public static int inDegree(Graph graph,int currentVertex){
        int count =0;
        for (Node vertex:graph.getVertices()) {
              if(vertex.getAdjacentVertices().contains(currentVertex))
                  count++;
        }
        return count;
    }

    //program for topological sort
    public static List<Character> topologicalSort(Graph graph){
        List<Character> sortedList = new ArrayList<>();
        Queue<Character> queue = new LinkedList<>();
        Map<Character,Integer> inDegreeMap = new HashMap<>();
        for (Node vertex:graph.getVertices()) {
            int count = inDegree(graph,vertex.getVertexNumber());
            inDegreeMap.put(GraphUtil.itoc(vertex.getVertexNumber()),count);
            if(count == 0)
                queue.add(GraphUtil.itoc(vertex.getVertexNumber()));
        }

        while (!queue.isEmpty()){
            char current = queue.poll();
            sortedList.add(current);
            for (char neighbour:graph.getAdjacentVertices(current)) {
                int updatedInDegree = inDegreeMap.get(neighbour)-1;
                inDegreeMap.put(neighbour,updatedInDegree);
                if(updatedInDegree == 0)
                    queue.add(neighbour);
            }
        }
        if(sortedList.size() != graph.getVertices().size())
            throw new NoSuchElementException();

        return sortedList;
    }
}

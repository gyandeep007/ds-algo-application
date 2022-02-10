package com.gyan.demo.algo.graph.mst;

import com.gyan.demo.ds.disjointset.DisjointSet;
import com.gyan.demo.ds.graph.GraphUtil;
import com.gyan.demo.ds.graph.set.weighted.Graph;
import com.sun.javafx.geom.Edge;

import java.util.*;

public class KruskalAlgorithm {

    public static void kruskal(Graph graph){
          // create a disjoint set to check is there any cucle
        DisjointSet disjointSet = new DisjointSet(graph.getVertices().size());
        //sort the edges based on the priority of edge weight
        PriorityQueue<EdgeInfo> queue = getSortedEdges(graph);

        Set<Integer> visitedVertices = new HashSet<>();
        Set<EdgeInfo> spanningTree = new HashSet<>();
        Map<Integer,Set<Integer>> edgeMap = new HashMap<>();
        for (int i = 0; i <graph.getVertices().size() ; i++) {
            edgeMap.put(i,new HashSet<>());
        }

        while (!queue.isEmpty() && spanningTree.size() < graph.getVertices().size()-1){
            EdgeInfo currentEdge = queue.poll();
//            second way of detecting cycle
//            edgeMap.get(currentEdge.getVertex1()).add(currentEdge.getVertex2());
//            if(hasCycle(edgeMap)){
//                edgeMap.get(currentEdge.getVertex1()).remove(currentEdge.getVertex2());
//                continue;
//            }
            if(disjointSet.find(currentEdge.vertex1) == disjointSet.find(currentEdge.vertex2)){
                System.out.println("adding "+currentEdge+" will create cycle");
                continue;
            }
            disjointSet.union(currentEdge.getVertex1(), currentEdge.getVertex2());
            spanningTree.add(currentEdge);
            visitedVertices.add(currentEdge.getVertex1());
            visitedVertices.add(currentEdge.getVertex2());
        }

        if(spanningTree.size() != graph.getVertices().size()-1){
            System.out.println("Minimum Spanning tree is not possible");
        }else{
            for (EdgeInfo edge:spanningTree) {
                System.out.println(edge);
            }
        }
    }

    private static boolean hasCycle(Map<Integer, Set<Integer>> edgeMap) {
        for (int sourceVertex:edgeMap.keySet()) {
           Queue<Integer> queue = new LinkedList<>();
           Set<Integer> visitedVertices = new HashSet<>();
           queue.add(sourceVertex);
           while (!queue.isEmpty()){
               int current = queue.poll();
               if(visitedVertices.contains(current))
                   return true;

               visitedVertices.add(current);
               queue.addAll(edgeMap.get(current));
           }
        }
        return false;
    }

    public static PriorityQueue<EdgeInfo> getSortedEdges(Graph graph){

        PriorityQueue<EdgeInfo> sortedEdge = new PriorityQueue<>(new Comparator<EdgeInfo>() {
            @Override
            public int compare(EdgeInfo o1, EdgeInfo o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        Set<Integer> visitedVertices = new HashSet<>();
            for (int eachVertex = 0; eachVertex <graph.getVertices().size() ; eachVertex++) {
                for (int neighbour:graph.getAdjacentVertices(eachVertex)){
                   if(!visitedVertices.contains(neighbour)) {
                       sortedEdge.add(new EdgeInfo(eachVertex, neighbour, graph.getEdgeWeight(eachVertex, neighbour)));
                   }
                 }
//                System.out.println("after exploring vertex "+GraphUtil.itoc(eachVertex));
//                System.out.println(sortedEdge);
                visitedVertices.add(eachVertex);
            }

        return sortedEdge;
    }



    static class EdgeInfo{
        private Integer vertex1;
        private Integer vertex2;
        private Integer weight;

        public EdgeInfo(Integer vertex1, Integer vertex2, Integer weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        public Integer getVertex1() {
            return vertex1;
        }

        public void setVertex1(Integer vertex1) {
            this.vertex1 = vertex1;
        }

        public Integer getVertex2() {
            return vertex2;
        }

        public void setVertex2(Integer vertex2) {
            this.vertex2 = vertex2;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "EdgeInfo{" +
                    "vertex1=" + GraphUtil.itoc(vertex1) +
                    ", vertex2=" + GraphUtil.itoc(vertex2) +
                    ", weight=" + weight +
                    '}';
        }
    }
}

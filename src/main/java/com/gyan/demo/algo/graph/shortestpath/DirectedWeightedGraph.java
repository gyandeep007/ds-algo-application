package com.gyan.demo.algo.graph.shortestpath;

import com.gyan.demo.ds.graph.GraphUtil;
import com.gyan.demo.ds.graph.set.weighted.Graph;

import java.util.*;

public class DirectedWeightedGraph {
    //finding shortest path from a given source to destination in a directed weighted graph
    // is also known as Dijkstra's algorithm

    //1. first step to build distance table
    public static Map<Integer,DistanceInfo> buildDistanceTable(Graph graph,char source){
        int iSource = GraphUtil.ctoi(source);
        return buildDistanceTable(graph,iSource);
    }
    public static Map<Integer,DistanceInfo> buildDistanceTable(Graph graph,int source){
        Map<Integer,DistanceInfo>  distanceTable = new HashMap<>();

        // initialize the distance table
        for (int i = 0; i <graph.getVertices().size() ; i++) {
            distanceTable.put(i,new DistanceInfo(Integer.MAX_VALUE));
        }
        //create a priority queue to hold vertex with ascending order of edges
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo o1, VertexInfo o2) {
                return ((Integer)o1.getDistance()).compareTo(o2.getDistance());
            }
        });

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);
        VertexInfo sourceVertexInfo = new VertexInfo(source,0);
        queue.add(sourceVertexInfo);
        Map<Integer,VertexInfo> vertexInfoMap = new HashMap<>();
        vertexInfoMap.put(source,sourceVertexInfo);

        while (!queue.isEmpty()){
            VertexInfo currentVertexInfo = queue.poll();
            int currentVertex = currentVertexInfo.getVertexNumber();
            for (int neighbour: graph.getAdjacentVertices(currentVertex)) {
                int newDistance = distanceTable.get(currentVertex).getDistance()+
                                   graph.getEdgeWeight(currentVertex,neighbour);
                if(newDistance < distanceTable.get(neighbour).getDistance()){
                    distanceTable.get(neighbour).setDistance(newDistance);
                    distanceTable.get(neighbour).setLastVertex(currentVertex);
                    VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
                    if(neighbourVertexInfo != null) {
                        queue.remove(neighbourVertexInfo);
                    }
                    neighbourVertexInfo = new VertexInfo(neighbour,newDistance);
                    queue.add(neighbourVertexInfo);
                    vertexInfoMap.put(neighbour,neighbourVertexInfo);
                }
            }
        }

        return  distanceTable;
    }

    //2. find the shortest path using distance table
    public static List<Character> findShortestPath(Graph graph,char source,char destination) {
        int iSource = GraphUtil.ctoi(source);
        int iDestination = GraphUtil.ctoi(destination);

        List<Character> shortestPath = new ArrayList<>();
        for (int i:findShortestPath(graph,iSource,iDestination)) {
            shortestPath.add(GraphUtil.itoc(i));
        }
        return shortestPath;
    }
        public static List<Integer> findShortestPath(Graph graph,int source,int destination){
        List<Integer> shortestPath = new ArrayList<>();
        shortestPath.add(source);
        Stack<Integer> stack = new Stack<>();
        stack.push(destination);
        Map<Integer,DistanceInfo> distanceTable = buildDistanceTable(graph,source);
        int prevVertex = distanceTable.get(destination).getLastVertex();
        while (prevVertex != -1 && prevVertex != source){
            stack.push(prevVertex);
            prevVertex = distanceTable.get(prevVertex).getLastVertex();
        }

        if(prevVertex == -1){
           return null;
        }

        while (!stack.isEmpty()){
            shortestPath.add(stack.pop());
        }
        return shortestPath;
    }


}

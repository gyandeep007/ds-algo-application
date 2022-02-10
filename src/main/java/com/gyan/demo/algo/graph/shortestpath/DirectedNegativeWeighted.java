package com.gyan.demo.algo.graph.shortestpath;

import com.gyan.demo.ds.graph.GraphUtil;
import com.gyan.demo.ds.graph.set.weighted.Graph;
import com.gyan.demo.ds.graph.set.weighted.Node;

import java.util.*;

public class DirectedNegativeWeighted {

    //Bellman Ford algorithm
    //step1. build the distance table
    public static Map<Integer,DistanceInfo> buildDistanceTable(Graph graph,char source){
        int iSource = GraphUtil.ctoi(source);
        return buildDistanceTable(graph,iSource);
    }
    public static Map<Integer,DistanceInfo> buildDistanceTable(Graph graph,int source){

        //initialize the distance table
        Map<Integer,DistanceInfo> distanceTable = new HashMap<>();
        for (int i = 0; i <graph.getVertices().size() ; i++) {
            //initialize each vertex with random maximum value
            distanceTable.put(i,new DistanceInfo(100000));
        }
        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);
        Queue<Integer> queue = new ArrayDeque<>();

        //iterate each edge v-1 times
        for (int i = 0; i <graph.getVertices().size()-1 ; i++) {
            //add each vertex to queue
            for (Node eachVertex:graph.getVertices()) {
                queue.add(eachVertex.getVertexNumber());
            }

            //create a set that keep track edges we have visited
            Set<String> visitedEdges = new HashSet<>();
            while (!queue.isEmpty()){
                int currentVertex = queue.poll();
                for (int neighbour:graph.getAdjacentVertices(currentVertex)) {
                    String edge = String.valueOf(currentVertex)+"-->"+String.valueOf(neighbour);
                    if(visitedEdges.contains(edge)){
                        System.out.println("duplicate dge found "+edge);
                        continue;
                    }
                    visitedEdges.add(edge);
                    int newDistance = distanceTable.get(currentVertex).getDistance()+
                                       graph.getVertices().get(currentVertex).getEdgeWeight(neighbour);

                    if(newDistance < distanceTable.get(neighbour).getDistance()){
                        distanceTable.get(neighbour).setDistance(newDistance);
                        distanceTable.get(neighbour).setLastVertex(currentVertex);
                    }
                }
            }
            System.out.println("distance table at iteration "+(i+1));
            GraphUtil.formatDistanceTable(distanceTable);
        }
        //add all the vertices to the queue one last time to check if there exists a negative cycle
        for (Node eachVertex: graph.getVertices()) {
            queue.add(eachVertex.getVertexNumber());
        }

        while (!queue.isEmpty()){
            int currentVertex = queue.poll();
            for (int neighbour: graph.getAdjacentVertices(currentVertex)) {
                int newDistance = distanceTable.get(currentVertex).getDistance()+
                        graph.getEdgeWeight(currentVertex,neighbour);
                 if(newDistance < distanceTable.get(neighbour).getDistance()){
                     throw new IllegalArgumentException("the graph have negative cycle");

                 }
            }

        }
        return distanceTable;
    }

    //step2. find the shortest path using distance table
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
        Map<Integer,DistanceInfo> distanceTable = buildDistanceTable(graph,source);
        List<Integer> shortestPath = new ArrayList<>();
        shortestPath.add(source);
        Stack<Integer> path = new Stack<>();
        path.push(destination);
        int prevVertex = distanceTable.get(destination).getLastVertex();
        while (prevVertex != -1 && prevVertex != source){
            path.push(prevVertex);
            prevVertex = distanceTable.get(prevVertex).getLastVertex();
        }
        if(prevVertex == -1)
            return null;

        while (!path.isEmpty()){
            shortestPath.add(path.pop());
        }
        return shortestPath;
    }
}

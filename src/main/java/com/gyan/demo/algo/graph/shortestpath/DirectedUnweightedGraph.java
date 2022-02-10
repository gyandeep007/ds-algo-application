package com.gyan.demo.algo.graph.shortestpath;

import com.gyan.demo.ds.graph.GraphUtil;
import com.gyan.demo.ds.graph.set.unweighted.Graph;

import java.util.*;

public class DirectedUnweightedGraph {
    //find shortest path from source to destination
    //step1. create the distance table

    public static Map<Integer,DistanceInfo> buildDistanceTable(Graph graph,char sourceVertex){
        return buildDistanceTable(graph,GraphUtil.ctoi(sourceVertex));
    }
    public static Map<Integer,DistanceInfo> buildDistanceTable(Graph graph,int sourceVertex){
        //variable to store distance info
        Map<Integer,DistanceInfo> distanceTable = new HashMap<>();

        //initialize distance table with default distance and last vertex as -1
        for (int i= 0; i<graph.getVertices().size();i++) {
            distanceTable.put(i,new DistanceInfo());
        }

        //declare queue to process vertex in breadth first search
        Queue<Integer> queue = new LinkedList<>();
        //adding source vertex to queue to start processing
        queue.add(sourceVertex);
        //initialize distance table of source vertex
        // distance of source vertex will be zero
        distanceTable.get(sourceVertex).setDistance(0);
        //last vertex of source is source itself
        distanceTable.get(sourceVertex).setLastVertex(sourceVertex);
        // repeat the process until queue is empty
        while (!queue.isEmpty()){
            //take the current vertex from queue
            int currentVertex = queue.poll();
            //explore neighbour of current vertex
            for (int neighbour: graph.getAdjacentVertices(currentVertex)) {
                //get the distance of neighbour
                int updateDistance = distanceTable.get(neighbour).getDistance();
                //check if neighbour is not already visited
                if(updateDistance == -1 ){
                    //get the distance info of neighbour
                    DistanceInfo neighbourDistanceInfo = distanceTable.get(neighbour);
                    //set distance of neighbour to distance of current vertex +1
                    neighbourDistanceInfo.setDistance(distanceTable.get(currentVertex).getDistance()+1);
                    // set the last vertex of neighbour to current vertex
                    neighbourDistanceInfo.setLastVertex(currentVertex);
                    //update the distance table of neighbour
                    distanceTable.put(neighbour,neighbourDistanceInfo);
                    //check if the neighbours of current neighbour is not empty then add it to queue
                    if(!graph.getVertices().get(neighbour).getAdjacentVertices().isEmpty()){
                        queue.add(neighbour);
                    }
                }
             //   GraphUtil.formatDistanceTable(distanceTable);
            }
        }


        return distanceTable;
    }

    public static List<Integer> findShortestPath(Graph graph,int source,int destination){
        //create a list to store the path
        List<Integer> shortestPath = new ArrayList<>();
        //add source to shortest path
        shortestPath.add(source);
        //create a stack to backtrack the vertices from distance table
        Stack<Integer> stack = new Stack<>();
        //build the distance table
        Map<Integer,DistanceInfo> distanceTable = buildDistanceTable(graph,source);
        //push the destination to the stack
        stack.push(destination);
        //get the previous vertex of destination
        int prevVertex = distanceTable.get(destination).getLastVertex();
        // repeat the step until prev vertex is not -1 and prev vertex is not equal to source
        while (prevVertex != -1 && prevVertex != source){
            stack.push(prevVertex);
            prevVertex = distanceTable.get(prevVertex).getLastVertex();
        }
        // if prev vertex is -1 then no shortest path exist between source and destination
        if(prevVertex == -1){
            return null;
        }
        //pop the node from stack and add to shortest path list
        while (!stack.isEmpty()){
            shortestPath.add(stack.pop());
        }
        // return shortest path
        return shortestPath;
    }

    public static List<Character> findShortestPath(Graph graph,char source,char destination){
        List<Character> shortestPath = new ArrayList<>();
        int iSource = GraphUtil.ctoi(source);
        int iDestination = GraphUtil.ctoi(destination);
        for (int i:findShortestPath(graph,iSource,iDestination)) {
            shortestPath.add(GraphUtil.itoc(i));
        }
        return shortestPath;
    }


}

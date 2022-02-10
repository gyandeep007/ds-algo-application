package com.gyan.demo.algo.graph.mst;

import com.gyan.demo.algo.graph.shortestpath.DistanceInfo;
import com.gyan.demo.algo.graph.shortestpath.VertexInfo;
import com.gyan.demo.ds.graph.GraphUtil;
import com.gyan.demo.ds.graph.set.weighted.Graph;

import java.util.*;

public class PrimsAlgorithm {
    //Undirected Weighted connected graph

    public static Set<String> solve(Graph graph,char source){
        int iSource = GraphUtil.ctoi(source);
        return solve(graph,iSource);
    }

    public static Set<String> solve(Graph graph,int source){
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        //initialize the distance table
        for (int i = 0; i <graph.getVertices().size() ; i++) {
            distanceTable.put(i,new DistanceInfo(Integer.MAX_VALUE));
        }
        //set distance and last vertex of source
        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo o1, VertexInfo o2) {
                return ((Integer)o1.getDistance()).compareTo(o2.getDistance());
            }
        });
        VertexInfo sourceVertexInfo = new VertexInfo(source,0);
        Map<Integer,VertexInfo> vertexInfoMap = new HashMap<>();
        queue.add(sourceVertexInfo);
        vertexInfoMap.put(source,sourceVertexInfo);

        Set<String> spanningTree = new HashSet<>();
        Set<Integer> visitedVertices = new HashSet<>();

        while (!queue.isEmpty()){
            VertexInfo currentVertexInfo = queue.poll();
            int currentVertex = currentVertexInfo.getVertexNumber();
            System.out.println("start exploring Vertex "+GraphUtil.itoc(currentVertex));
            if(visitedVertices.contains(currentVertex)){
                System.out.println("Vertex "+GraphUtil.itoc(currentVertex)+" is already visited");
                continue;
            }
            System.out.println("adding "+GraphUtil.itoc(currentVertex)+" to visited list");
            visitedVertices.add(currentVertex);
            if(currentVertex != source){
                String edge = String.valueOf(GraphUtil.itoc(currentVertex))+"-->"+
                              String.valueOf(GraphUtil.itoc(distanceTable.get(currentVertex).getLastVertex()))
                              +" with edge weight "+distanceTable.get(currentVertex).getDistance();
                if(!spanningTree.contains(edge)) {
                    System.out.println("adding "+edge+" spanning tree");
                    spanningTree.add(edge);
                }
                else {
                    System.out.println("duplicate edge found "+edge);
                }
            }

            for (int neighbour:graph.getAdjacentVertices(currentVertex)) {
                System.out.println("start exploring neighbour "+GraphUtil.itoc(neighbour)+" of vertex "+GraphUtil.itoc(currentVertex));
                int newDistance = graph.getEdgeWeight(currentVertex,neighbour);

                if(newDistance < distanceTable.get(neighbour).getDistance()){
                    distanceTable.get(neighbour).setDistance(newDistance);
                    distanceTable.get(neighbour).setLastVertex(currentVertex);

                    VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
                    if(neighbourVertexInfo != null) {
                        System.out.println("removing "+neighbourVertexInfo);
                        queue.remove(neighbourVertexInfo);
                    }

                   neighbourVertexInfo = new VertexInfo(neighbour,newDistance);
                    System.out.println("adding "+neighbourVertexInfo+" to queue");
                    queue.add(neighbourVertexInfo);
                    vertexInfoMap.put(neighbour,neighbourVertexInfo);
                }else {
                    System.out.println("New Distance of neighbour " + GraphUtil.itoc(neighbour) + "is " + newDistance + " which is greater than " +
                            " old distance " + distanceTable.get(neighbour).getDistance() + " so not updated distance table and returned");
                }
            }
            System.out.println("------------------------------");
            GraphUtil.formatDistanceTable(distanceTable);
            System.out.println("mst "+spanningTree);
            System.out.println("Vertex Info Map"+vertexInfoMap);
            System.out.println("Queue"+queue);
            System.out.println("------------------------------");
        }

        return spanningTree;
    }
}

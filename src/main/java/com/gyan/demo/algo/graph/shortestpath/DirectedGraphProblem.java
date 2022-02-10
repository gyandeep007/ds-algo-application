package com.gyan.demo.algo.graph.shortestpath;

import com.gyan.demo.ds.graph.GraphUtil;
import com.gyan.demo.ds.graph.set.unweighted.Graph;

import java.util.List;

public class DirectedGraphProblem {

    public static boolean hasCycle(Graph graph,char source) {
        int iSource = GraphUtil.ctoi(source);
        return hasCycle(graph,iSource);
    }

        public static boolean hasCycle(Graph graph,int source){

        graph.getVertices().get(source).setVisited(false);
        graph.getVertices().get(source).setBeingVisited(true);

        for (int neighbour: graph.getAdjacentVertices(source)) {
            if(graph.getVertices().get(neighbour).isBeingVisited()){
                System.out.println("cycle detected in the graph");
                return true;
            }
            if(!graph.getVertices().get(neighbour).isVisited()){
                graph.getVertices().get(neighbour).setVisited(true);
                hasCycle(graph,neighbour);
            }
        }
        graph.getVertices().get(source).setBeingVisited(false);
        graph.getVertices().get(source).setVisited(true);
        return false;
    }

  //finding path in maze
    public static void mazeProblem(int[][] map, boolean[][] visited, int row, int col, List<String> output){
        if(row<0 || col >= map.length)
            return;
        if(col<0 || row >= map.length)
            return;
        if(map[row][col] == 1)
            return;
        if(map[row][col] == 3){
            output.add(row+","+col);
            return;
        }
        if(visited[row][col])
            return;

        visited[row][col] = true;
         output.add(row+","+col);
         mazeProblem(map,visited,row,col+1,output);
        mazeProblem(map,visited,row,col-1,output);
        mazeProblem(map,visited,row-1,col,output);
        mazeProblem(map,visited,row+1,col,output);

    }
}

package com.gyan.demo.algo.graph;

import com.gyan.demo.ds.graph.GraphUtil;
import com.gyan.demo.ds.graph.set.unweighted.Graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversalAlgorithm {

    //graph depth first search post order
    public static void solve1(Graph graph,char currentVertex){
       if(graph.getVertices().get(GraphUtil.ctoi(currentVertex)).isVisited())
           return;

       graph.getVertices().get(GraphUtil.ctoi(currentVertex)).setVisited(true);
        List<Character> neighbours = graph.getAdjacentVertices(currentVertex);
        for (char neighbour:neighbours) {
            solve1(graph,neighbour);
        }
        System.out.print(currentVertex+"-->");
    }

    public static void solve1(Graph graph,boolean[] visited,char currentVertex){
        if(visited[currentVertex])
            return;

         visited[currentVertex] = true;
        List<Character> neighbours = graph.getAdjacentVertices(currentVertex);
        for (char neighbour:neighbours) {
            solve1(graph,neighbour);
        }
        System.out.print(currentVertex+"-->");
    }

    //graph depth first search pre order
    public static void solve2(Graph graph,char currentVertex){
        if(graph.getVertices().get(GraphUtil.ctoi(currentVertex)).isVisited())
            return;

        graph.getVertices().get(GraphUtil.ctoi(currentVertex)).setVisited(true);
        System.out.print(currentVertex+"-->");
        List<Character> neighbours = graph.getAdjacentVertices(currentVertex);
        for (char neighbour:neighbours) {
            solve2(graph,neighbour);
        }

    }

    public static void solve2(Graph graph,boolean[] visited,char currentVertex){
        if(visited[currentVertex])
            return;

        visited[currentVertex] = true;
        System.out.print(currentVertex+"-->");
        List<Character> neighbours = graph.getAdjacentVertices(currentVertex);
        for (char neighbour:neighbours) {
            solve2(graph,neighbour);
        }

    }

    //depth first search iterative way
        public static void solve4(Graph graph,char source) {
        int iSource = GraphUtil.ctoi(source);
        solve4(graph,iSource);
        }
        public static void solve4(Graph graph,int source){
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        graph.getVertices().get(source).setVisited(true);
        while (!stack.empty()){
            int current = stack.pop();

            for (int neighbour: graph.getAdjacentVertices(current)) {
                if(!graph.getVertices().get(neighbour).isVisited()){
                    graph.getVertices().get(neighbour).setVisited(true);
                    stack.push(neighbour);
                }
            }
            System.out.print(GraphUtil.itoc(current));
            if(!stack.empty()){
                System.out.print("-->");
            }
        }

    }

    //breadth first traversal
    public static void solve3(Graph graph,boolean[] visited,char source){
        Queue<Character> queue = new ArrayDeque<>();
        queue.add(source);
        visited[GraphUtil.ctoi(source)] = true;
        while (!queue.isEmpty()){
            char current = queue.poll();
            System.out.print(current);

            List<Character> neighbours = graph.getAdjacentVertices(current);
            for (char neighbour:neighbours) {
                if(!visited[GraphUtil.ctoi(neighbour)]){
                    visited[GraphUtil.ctoi(neighbour)] = true;
                    queue.add(neighbour);
                }
            }
            if(queue.size() != 0)
                System.out.print("-->");

        }
    }
}

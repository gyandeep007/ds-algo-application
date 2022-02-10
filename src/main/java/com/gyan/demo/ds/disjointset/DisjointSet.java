package com.gyan.demo.ds.disjointset;

public class DisjointSet {
    int[] parent,rank;
    int n;

    public DisjointSet(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        makeSet();
    }

    private void makeSet() {
        for (int i = 0; i <n ; i++) {
            parent[i] = i;
        }
    }

    public int find(int i){
        if(parent[i] == i)
            return i;

        return parent[i] = find(parent[i]);
    }

    public void union(int i,int j){
        int iRep = find(i);
        int jRep = find(j);

        if(iRep == jRep)
            return;

        if(rank[iRep] < rank[jRep])
           parent[iRep] = jRep;
        else if(rank[jRep] < rank[iRep])
            parent[jRep] = iRep;
        else{
            parent[iRep] = jRep;
            rank[jRep]++;
        }

    }
}

package com.gyan.demo.ds.binaryheap;

import java.util.PriorityQueue;

public class Problems {
    //K largest element in the stream
    public static void solve1(int[] stream,int k){
        PriorityQueue<Integer> buckets = new PriorityQueue<>(k);

        for (int i = 0; i < stream.length ; i++) {
            if(buckets.size() != k)
                buckets.add(stream[i]);
            else
                if(buckets.peek() > stream[i])
                    continue;
                else
                {
                    buckets.remove();
                    buckets.add(stream[i]);
                }
        }
        System.out.println(buckets);
    }
}

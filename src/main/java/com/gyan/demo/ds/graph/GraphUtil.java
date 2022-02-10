package com.gyan.demo.ds.graph;

import com.gyan.demo.algo.graph.shortestpath.DistanceInfo;
import com.gyan.demo.util.ColorUtil;
import com.gyan.demo.util.Utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphUtil {

    public static char itoc(int i){
        return (char)(i+65);
    }

    public static int ctoi(char i){
        return i-65;
    }

    public static void printDistanceTable(Map<Character, DistanceInfo> distanceTable){
        String header = "Vertex"+"\t"+"DistanceInfo";
        Utility.printInColor(header);
        System.out.println();
        distanceTable.entrySet().iterator().forEachRemaining((n)->System.out.println("\t"+n.getKey()+"\t\t"+n.getValue().getDistance()+"\t\t\t"+n.getValue().getLastVertex()));

    }

    public static void formatDistanceTable(Map<Integer, DistanceInfo> distanceTable){
       Map<Character,DistanceInfo> map= new HashMap<>();
        for (Map.Entry<Integer,DistanceInfo> item:distanceTable.entrySet()) {
           map.put(GraphUtil.itoc(item.getKey()), item.getValue());
        }

        String header = "Vertex"+"\t"+"Distance"+"\t"+"last vertex";
        Utility.printInColor(header);
        System.out.println();
        map.entrySet().iterator().forEachRemaining((n)->System.out.println("\t"+n.getKey()+"\t\t"+n.getValue().getDistance()+"\t\t\t"+GraphUtil.itoc(n.getValue().getLastVertex())));

    }


    public  static <T>void printPath(List<T> elements){
        int count = 0;
        for (T data:elements) {
            count++;
            System.out.print(ColorUtil.ANSI_RED+data+ColorUtil.ANSI_RESET);
            if(count != elements.size()){
                System.out.print(ColorUtil.ANSI_BLACK+"-->"+ColorUtil.ANSI_RESET);

            }
        }
    }


}

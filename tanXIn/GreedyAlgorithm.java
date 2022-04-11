package org.tanXIn;

import javafx.beans.property.SimpleStringProperty;

import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;
import java.util.*;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        int capacity=150;
        int[] weights={35,30,60,50,40,10,25};
        int[] value={10,40,30,50,35,40,30};
        GreedyAlgorithmDemo(capacity,weights,value);
    }

    public static void GreedyAlgorithmDemo(int capacity,int[] weights,int[] value){
        int n=weights.length;
        Map<String,Float> quality=new HashMap<>();
        for(int i=0;i<n;i++){
            quality.put(String.valueOf(i),(float) value[i]/weights[i]);
        }
        //根据性价比排序，并且下标随着动
        List<Map.Entry<String,Float>> list=new ArrayList<>(quality.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Float>>() {
            @Override
            public int compare(Map.Entry<String, Float> o1, Map.Entry<String, Float> o2) {
                if(o1.getValue()-o2.getValue()>0){
                    return -1;
                }else {
                    return 1;
                }
            }
        });


        Map<String,Float> result=new LinkedHashMap<String, Float>();
        for(Map.Entry<String,Float> entry:list){
            result.put(entry.getKey(),entry.getValue());
        }

        int[] path=new int[n];
        int maxValue=0;
        int maxWeight=0;
        for(Map.Entry<String,Float> entry:result.entrySet()){
           int index=Integer.parseInt(entry.getKey());
           if(weights[index]<=capacity){
             path[index]=1;
             capacity-=weights[index];
             maxValue+=value[index];
             maxWeight+=weights[index];
           }

        }
        Integer o1=4;
        Integer o2=3;
        System.out.println(o1.equals(o2));
        System.out.println("最大价值="+maxValue);
        System.out.println("最大重量="+maxWeight);
        System.out.println("商品路径="+Arrays.toString(path));
    }
}

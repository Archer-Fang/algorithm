package PartOne.Heap.WeightdShortestDistance.q787;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Created by Fangzj
 * @data 2021/3/25 21:34
 **/
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int i=0;i<flights.length;i++){
            List<int[]> tmp=map.getOrDefault(flights[i][0],new ArrayList<int[]>());
            tmp.add(new int[]{flights[i][1],flights[i][2]});
            map.put(flights[i][0],tmp);
        }
        PriorityQueue<Item> minHeap=new PriorityQueue<>((a,b)->a.distance-b.distance);
        minHeap.add(new Item(-1,src,0));
        HashMap<Integer,Integer> r=new HashMap<>();// dst List<int[]{distance,k}>
        while (!minHeap.isEmpty()){
            Item tmp=minHeap.poll();
            r.put(tmp.index,tmp.distance);
            if(tmp.index==dst) return tmp.distance;
            if(map.get(tmp.index)!=null&&tmp.k!=K){
                for (int[] edge:map.get(tmp.index)){
                    minHeap.add(new Item(tmp.k+1,edge[0],edge[1]+tmp.distance));
                }
            }
        }
        return-1;
    }
    class Item{
        int k;
        int index;
        int distance;

        public Item(int k, int index, int distance) {
            this.k = k;
            this.index = index;
            this.distance = distance;
        }
    }
}

public class q787 {
    public static void main(String[] args) {
        Solution solution=new Solution();
//        System.out.println(solution.findCheapestPrice(5,new int[][]{{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}},0,2,2));
//        System.out.println(solution.findCheapestPrice(3,new int[][]{{0,1,100},{1,2,100},{0,2,500}},0,2,0));
        System.out.println(solution.findCheapestPrice(3,new int[][]{{0,1,2},{1,2,1},{2,0,10}},1,2,1));
    }
}

package Heap.WeightdShortestDistance.q743;

import java.util.*;

/**
 * @author Created by Fangzj
 * @data 2021/3/25 15:00
 **/
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Item> minHeap=new PriorityQueue<>((a,b)->a.distance-b.distance);
        int ans=-1;
        int[] visit=new int[n];
        minHeap.add(new Item(0,k));
        Item tmp=null;
        Map<Integer, Integer> dist = new HashMap();
        while (!minHeap.isEmpty()){
            tmp=minHeap.poll();
            if(visit[tmp.index-1]==1) continue;
            visit[tmp.index-1]=1;
            dist.put(tmp.index,tmp.distance);
            for (int i=0;i<times.length;i++){
                if(times[i][0]==tmp.index){
                    if(visit[times[i][1]-1]==0){
                        minHeap.add(new Item(times[i][2]+tmp.distance,times[i][1]));
                    }
                }
            }
        }
        if(dist.size()<n) return -1;
        for (Integer key:dist.keySet()){
            ans=Math.max(ans,dist.get(key));
        }
        return ans;
    }
    class Item{
        int distance;
        int index;
        public Item(int distance, int index) {
            this.distance = distance;
            this.index = index;
        }
    }
}

public class q743 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.networkDelayTime(new int[][]{{1,2,1}},2,2));
//        System.out.println(solution.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,2));
    }
}

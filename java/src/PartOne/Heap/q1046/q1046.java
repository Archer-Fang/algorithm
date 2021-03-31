package PartOne.Heap.q1046;

import java.util.PriorityQueue;

/**
 * @author Created by Fangzj
 * @data 2021/3/22 20:16
 **/
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(stones.length,(a,b)->b-a);
        for (Integer num:stones){
            maxHeap.add(num);
        }
        while (maxHeap.size()>=2){
            int a=maxHeap.poll();
            int b=maxHeap.poll();
            if(a==b) continue;
            maxHeap.add(a-b);
        }
        if(maxHeap.size()==0) return 0;
        return maxHeap.poll();
    }
}
public class q1046 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}

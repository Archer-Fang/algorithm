package PartOne.Heap.q1642;

import java.util.PriorityQueue;

/**
 * @author Created by Fangzj
 * @data 2021/3/25 10:14
 **/
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        int useBricks=0;
        for (int i=1;i<heights.length;i++){
            if(heights[i]-heights[i-1]>0){
                minHeap.add(heights[i]-heights[i-1]);
                if(minHeap.size()>ladders){
                    useBricks+=minHeap.remove();
                }
                if(useBricks>bricks){
                    return i-1;
                }
            }
        }
        return heights.length-1;
    }
}

public class q1642 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.furthestBuilding(new int[]{3,19},87,1));
    }
}

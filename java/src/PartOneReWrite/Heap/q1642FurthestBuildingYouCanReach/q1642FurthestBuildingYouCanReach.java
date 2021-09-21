package PartOneReWrite.Heap.q1642FurthestBuildingYouCanReach;

import java.util.PriorityQueue;

//Java：可以到达的最远建筑
public class q1642FurthestBuildingYouCanReach{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int ans=0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if(diff<=0) continue;
            minHeap.add(diff);
            if(minHeap.size()>ladders){
                bricks-=minHeap.poll();
            }
            if(bricks<0) return i;
        }
        return heights.length-1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

package PartOneReWrite.Heap.q1046LastStoneWeight;

import java.util.PriorityQueue;

//Java：最后一块石头的重量
public class q1046LastStoneWeight{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b-a);
        for (Integer integer : stones
        ) {
            priorityQueue.add(integer);
        }
        while (priorityQueue.size()>1){
            priorityQueue.add(priorityQueue.poll()-priorityQueue.poll());
        }
        return priorityQueue.size()==0?0:priorityQueue.poll();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

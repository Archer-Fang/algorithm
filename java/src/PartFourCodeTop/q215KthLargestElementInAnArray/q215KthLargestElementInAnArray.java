package PartFourCodeTop.q215KthLargestElementInAnArray;

import java.util.PriorityQueue;

//Java：数组中的第K个最大元素
public class q215KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findKthLargest(new int[]{3,2,1,5,6,4},2);
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((a,b)->b.compareTo(a));
        for (int num : nums) {
            priorityQueue.add(num);
        }
        while ((--k)>0){
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

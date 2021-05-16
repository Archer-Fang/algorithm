package PartThree.Mid.leetcode.editor.cn.q215KthLargestElementInAnArray;
//Java：数组中的第K个最大元素

import java.util.PriorityQueue;

public class q215KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((a,b)->a-b);
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();


    }
}
//leetcode submit region end(Prohibit modification and deletion)

package DMSXL.DP.q239SlidingWindowMaximum;

import java.util.ArrayDeque;

//Java：滑动窗口最大值
public class q239SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k+1];
        int i=0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int j = 0; j < nums.length; j++) {
            while (!queue.isEmpty()&&queue.peek()<j+1-k){
                queue.poll();
            }
            while (!queue.isEmpty()&&nums[queue.peekLast()]<nums[j]){
                queue.pollLast();
            }
            queue.offer(j);
            if(j+1>=k){
                ans[i++]=nums[queue.peekFirst()];
            }

        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

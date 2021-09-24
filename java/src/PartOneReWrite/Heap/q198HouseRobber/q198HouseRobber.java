package PartOneReWrite.Heap.q198HouseRobber;
//Java：打家劫舍
public class q198HouseRobber{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
//        solution.rob(new int[]{2,7,9,3,1});
//        solution.rob(new int[]{1,2});
        solution.rob(new int[]{1,2,3,1});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        //dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

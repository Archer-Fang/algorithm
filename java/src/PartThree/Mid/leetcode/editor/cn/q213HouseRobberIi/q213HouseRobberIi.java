package PartThree.Mid.leetcode.editor.cn.q213HouseRobberIi;
//Java：打家劫舍 II

import java.util.Arrays;

public class q213HouseRobberIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.rob(new int[]{1,2,3,1});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        return Math.max(rob2(Arrays.copyOfRange(nums,0,nums.length-1)),rob2(Arrays.copyOfRange(nums,1,nums.length)));

    }
    public int rob2(int[] nums) {
        //dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i])
        int[] dp=new int[nums.length+1];
        dp[1]=nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package DMSXL.DP.q300LongestIncreasingSubsequence;

import java.util.Arrays;

//Java：最长递增子序列
public class q300LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.lengthOfLIS(new int[]{4,10,4,3,8,9});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        //第i个位置最长严格递增子序列的长度dp[i]
        //if(nums[i]>nums[j]) dp[i]=Math.max(dp[i],dp[j]+1)
        //else dp[i]=Math.max(dp[i],dp[j])
        if(nums.length<=1) return nums.length;
        int[] dp = new int[2501];
        Arrays.fill(dp,1);
        dp[0]=1;
        int max=1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]) dp[i]=Math.max(dp[i],dp[j]+1);
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

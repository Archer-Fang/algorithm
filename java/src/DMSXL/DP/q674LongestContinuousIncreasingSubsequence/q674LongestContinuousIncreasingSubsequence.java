package DMSXL.DP.q674LongestContinuousIncreasingSubsequence;

import java.util.Arrays;

//Java：最长连续递增序列
public class q674LongestContinuousIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        //第i个位置最长且连续递增的子序列的长度dp[i]
        //if(nums[i]>nums[i-1]) dp[i]=dp[i-1]+1
        if(nums.length<=1) return nums.length;
        int[] dp = new int[10001];
        Arrays.fill(dp,1);
        int max=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]) dp[i]=dp[i-1]+1;
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

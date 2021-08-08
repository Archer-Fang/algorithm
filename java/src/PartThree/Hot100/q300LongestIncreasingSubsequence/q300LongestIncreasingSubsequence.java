package PartThree.Hot100.q300LongestIncreasingSubsequence;

import java.util.Arrays;

//Java：最长递增子序列
public class q300LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(solution.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        //dp[i]=Math.max(dp[0],dp[1],...dp[i-1])+1; if(nums[i]>nums[k]&&i>k)
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

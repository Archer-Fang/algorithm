package PartThree.Mid.q673NumberOfLongestIncreasingSubsequence;
//Java：最长递增子序列的个数

import java.util.HashMap;

public class q673NumberOfLongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.findNumberOfLIS(new int[]{1,3,5,4,7}));
        System.out.println(solution.findNumberOfLIS(new int[]{2,2,2,2,2}));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][2];
        for (int i = 0; i < dp.length; i++) {
            int[] ints = dp[i];
            for (int j = 0; j < ints.length; j++) {
                dp[i][j]=1;
            }
        }
        //dp[j]=Math.max(dp[j-nums[i]]+1,dp[j]) if(nums[j]>nums[i])
        int max=1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j >i; j--) {
                if(nums[j]>nums[i]){
                    if(dp[i][0]+1>dp[j][0]){
                        dp[j][0]=dp[i][0]+1;
                        dp[j][1]=dp[i][1];
                        max=Math.max(max,dp[j][0]);
                    }else if(dp[i][0]+1==dp[j][0]){
                        dp[j][1]=dp[i][1]+dp[j][1];
                    }
                }
            }
        }
        int sum=0;
        for (int i = 0; i < dp.length; i++) {
            int[] ints = dp[i];
            if(ints[0]==max){
                sum+=ints[1];
            }

        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

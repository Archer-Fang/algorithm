package PartOneReWrite.Heap.q486PredictTheWinner;
//Java：预测赢家
public class q486PredictTheWinner{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        //dp[][]:score
        //dp[i][j]=Math.max(dp[i]-dp[i+1][j],dp[j]-dp[i][j-1]);
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i]=nums[i];
        }
        for (int l = 2; l <= n ; l++) {
            for (int i = 0; i +l-1< n; i++) {
                dp[i][i+l-1]=Math.max(nums[i]-dp[i+1][i+l-1],nums[i+l-1]-dp[i][i+l-2]);
            }
        }
        return dp[0][n-1]>=0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

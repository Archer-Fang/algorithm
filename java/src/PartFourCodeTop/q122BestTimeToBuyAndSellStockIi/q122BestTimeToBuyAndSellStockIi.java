package PartFourCodeTop.q122BestTimeToBuyAndSellStockIi;

import java.util.Arrays;

//Java：买卖股票的最佳时机 II
public class q122BestTimeToBuyAndSellStockIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        //dp
        //dp[i][0] 不持有
        //dp[i][1] 持有
        //dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i])
        //dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i])
        int[][] dp = new int[prices.length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

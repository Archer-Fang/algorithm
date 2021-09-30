package DMSXL.DP.q122BestTimeToBuyAndSellStockIi;
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
        if(prices.length<=1) return 0;
        //第i天的买入获取的最大利润dp[i][0]
        //第i天的卖出获取的最大利润dp[i][1]
        //第i天的获取的最大利润Math.max(dp[i][0],dp[i][1])
        //dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i])
        //dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i])
        int[][] dp = new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

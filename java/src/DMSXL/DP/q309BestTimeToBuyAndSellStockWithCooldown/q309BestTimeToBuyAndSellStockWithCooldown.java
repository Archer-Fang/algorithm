package DMSXL.DP.q309BestTimeToBuyAndSellStockWithCooldown;
//Java：最佳买卖股票时机含冷冻期
public class q309BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        //2种状态
        //0:买入
        //1：卖出
        //dp[i][j]:在i天，处于第j的状态，可以获取的最大价值。
        //dp[i][0]=Math.max(dp[i-1][0],dp[i-2][1]-prices[i]);
        //dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        if(prices.length<=1) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        dp[1][0]=Math.max(-prices[0],-prices[1]);
        dp[1][1]=Math.max(0,prices[1]-prices[0]);
        for (int i = 2; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-2][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

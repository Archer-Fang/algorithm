package DMSXL.DP.q714BestTimeToBuyAndSellStockWithTransactionFee;
//Java：买卖股票的最佳时机含手续费
public class q714BestTimeToBuyAndSellStockWithTransactionFee{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices, int fee) {
        //2种状态
        //0:买入
        //1：sell
        //dp[i][j]:第i天，处以第j状态，获得利润的最大值
        //dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
        //dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]-fee);
        if(prices.length<=1) return 0;
        int[][] dp = new int[50001][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]-fee);
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

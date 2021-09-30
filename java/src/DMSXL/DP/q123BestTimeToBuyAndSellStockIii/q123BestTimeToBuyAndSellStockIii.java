package DMSXL.DP.q123BestTimeToBuyAndSellStockIii;

//Java：买卖股票的最佳时机 III
public class q123BestTimeToBuyAndSellStockIii{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        //一天有5个状态：
        //0：不操作
        //1：第一次买入
        //2：第一次卖出
        //3：第二次买入
        //4： 第二次卖出
        //dp[i][j]:表示第i天，最多可以完成两笔交易，j种状态获取的最大的价值。
        //dp[i][0]=Math.max(dp[i-1][0],0);
        //dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        //dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+pirces[i]);
        //dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
        //dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        if(prices.length<=1) return 0;
        int[][] dp = new int[prices.length][5];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[0][2]=0;
        dp[0][3]=-prices[0];
        dp[0][4]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],0);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }
        return dp[prices.length - 1][4];


    }
}
//leetcode submit region end(Prohibit modification and deletion)

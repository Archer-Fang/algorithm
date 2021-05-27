package PartThree.leetcode.editor.cn.q309BestTimeToBuyAndSellStockWithCooldown;
//Java：最佳买卖股票时机含冷冻期

public class q309BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.maxProfit(new int[]{1});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1)return 0;
        if(prices.length==2)return Math.max(prices[1]-prices[0],0);
        int[][] dp=new int[prices.length][2];
        //dp[i][0]:not hold,dp[i][1]:hold
        //dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
        //dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[1][0]=Math.max(dp[0][0],dp[0][1]+prices[1]);
        dp[1][1]=Math.max(dp[0][1],-prices[1]);
        for (int i = 2; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return Math.max(dp[dp.length-1][0],dp[dp.length-1][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

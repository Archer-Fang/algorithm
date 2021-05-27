package PartThree.leetcode.editor.cn.q714BestTimeToBuyAndSellStockWithTransactionFee;
//Java：买卖股票的最佳时机含手续费

public class q714BestTimeToBuyAndSellStockWithTransactionFee{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.maxProfit(new int[]{1,3,7,5,10,3},3));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length][2];
        //dp[n][0]:not hold
        //dp[n][1]:hold
        //dp[n][0]=Math.max(dp[n-1][0],dp[n-1][1]+prices[n]-fee)
        //dp[n][1]=Math.max(dp[n-1][1],dp[n-1][0]-prices[n])
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+price-fee);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-price);
        }
        return Math.max(dp[dp.length-1][0],dp[dp.length-1][1]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

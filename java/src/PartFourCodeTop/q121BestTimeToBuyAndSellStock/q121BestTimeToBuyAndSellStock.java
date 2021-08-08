package PartFourCodeTop.q121BestTimeToBuyAndSellStock;

import java.util.Arrays;

//Java：买卖股票的最佳时机
public class q121BestTimeToBuyAndSellStock{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        //前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
        int ans=0;
        int[] dp = new int[prices.length];
        int[] min = new int[prices.length];
        Arrays.fill(min, Integer.MAX_VALUE);
        dp[0]=0;
        min[0]=prices[0];
        for (int i = 1; i < prices.length; i++){
            dp[i]=Math.max(dp[i-1],prices[i]-min[i-1]);
            min[i]=Math.min(min[i-1],prices[i]);
        }
        return Arrays.stream(dp).max().getAsInt();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

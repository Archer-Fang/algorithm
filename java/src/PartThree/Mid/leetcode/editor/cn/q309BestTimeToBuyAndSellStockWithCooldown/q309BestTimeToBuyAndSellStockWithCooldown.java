package PartThree.Mid.leetcode.editor.cn.q309BestTimeToBuyAndSellStockWithCooldown;
//Java：最佳买卖股票时机含冷冻期

public class q309BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.maxProfit(new int[]{1,2,3,0,2});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        //dp[i]=price[i]-price[j]+dp[j-2];
        int n=prices.length;
        int[] dp=new int[n];
        for (int i = 1; i < n; i++) {
            dp[i]=dp[i-1];
            for (int j = 0; j < i; j++) {
                if(j==0||j==1){
                    dp[i]=Math.max(prices[i]-prices[j]+0,dp[i]);
                }else {
                    dp[i]=Math.max(prices[i]-prices[j]+dp[j-2],dp[i]);
                }

            }
        }
        return dp[n-1];


    }
}
//leetcode submit region end(Prohibit modification and deletion)

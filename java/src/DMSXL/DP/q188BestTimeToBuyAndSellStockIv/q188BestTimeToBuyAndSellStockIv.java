package DMSXL.DP.q188BestTimeToBuyAndSellStockIv;
//Java：买卖股票的最佳时机 IV
public class q188BestTimeToBuyAndSellStockIv{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.maxProfit(2,new int[]{2,4,1});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        //共2k+1种状态
        //0：不操作
        //1：第一次买入
        //2：第一次卖出
        //3：第二次买入
        //4：第二次卖出
        //...
        //dp[i][j]:第i天，最多可以完成 k 笔交易，所能获取的最大利润dp[i][j]
        //dp[i][0]=0;
        //dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i])
        //dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+prices[i])
        //dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i])
        //dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3]-prices[i])
        if(prices.length<=1) return 0;
        int[][] dp = new int[1001][2 * k + 1];
        //init
        for (int i = 1; i <=2*k; i++) {
            if(i%2==1){
                dp[0][i]=-prices[0];
            }

        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= 2*k; j++) {
                if(j%2==1){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]-prices[i]);
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]+prices[i]);
                }

            }
        }
        return Math.max(dp[prices.length-1][2*k],0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

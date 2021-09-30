package DMSXL.DP.q322CoinChange;

import java.util.Arrays;

//Java：零钱兑换
public class q322CoinChange{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.coinChange(new int[]{1},2);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        //凑成总金额j所需的最少的硬币个数dp[j]
        //dp[j]=Main.min(dp[j],dp[j-coins[i]]+1)
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if(j>=coins[i]) dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return dp[amount]==(amount+1)?-1:dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

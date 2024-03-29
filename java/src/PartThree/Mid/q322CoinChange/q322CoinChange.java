package PartThree.Mid.q322CoinChange;
//Java：零钱兑换

import java.util.Arrays;

public class q322CoinChange{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.coinChange(new int[]{2},3);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp[i]=Math.min(dp[i-coins[0]],dp[i-coins[1]],...,dp[i-coins[n-1]])+1
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for (int i = 1; i < amount+1; i++) {
            int min=amount+1;
            for (int j = 0; j < coins.length; j++) {
                if(i-coins[j]>=0&&dp[i-coins[j]]!=-1){
                    min=Math.min(min,dp[i-coins[j]]);
                }
            }
            dp[i]=min==amount+1?-1:min+1;
        }
        return dp[amount];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

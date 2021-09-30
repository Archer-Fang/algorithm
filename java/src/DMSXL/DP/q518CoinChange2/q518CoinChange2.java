package DMSXL.DP.q518CoinChange2;

//Java：零钱兑换 II
public class q518CoinChange2{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change(int amount, int[] coins) {
        //dp[j]:the num that sum to j
        //dp[j]=dp[j]+dp[j-coins[i]]
        int[] dp = new int[amount + 1];
        dp[0]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <=amount ; j++) {
                if(j>=coins[i]) dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

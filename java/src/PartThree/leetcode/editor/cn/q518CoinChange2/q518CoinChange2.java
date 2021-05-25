package PartThree.leetcode.editor.cn.q518CoinChange2;
//Java：零钱兑换 II

public class q518CoinChange2{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.change(5,new int[]{1,2,5}));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        //dp[j]=dp[j]+dp[j-coint[i]];
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j <= amount; j++) {
                dp[j]+=dp[j-coin];
            }
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

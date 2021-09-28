package DMSXL.DP.q1049LastStoneWeightIi;

import java.util.Arrays;

//Java：最后一块石头的重量 II
public class q1049LastStoneWeightIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastStoneWeightII(int[] stones) {
        //从stones数组中选择，凑成不超过sum/2的最大价值，从总和为j的背包能背dp[j]的价值,要求价值最大
        //dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
        int[] dp = new int[15001];
        int sum = Arrays.stream(stones).sum();
        int target =  sum/ 2;
        for (int i = 0; i < stones.length; i++) {
            for (int j=target;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return (sum-dp[target])-dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

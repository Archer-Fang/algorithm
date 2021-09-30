package DMSXL.DP.q279PerfectSquares;

import java.util.Arrays;

//Java：完全平方数
public class q279PerfectSquares{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        //组成j的完全平方数的个数最少dp[j]
        //dp[j]=Math.min(dp[j],dp[j-i]+1);
        int[] dp = new int[n + 1];
        Arrays.fill(dp,n+1);
        dp[0]=0;
        for (int i = 1; i*i < n+1; i++) {
            for (int j = 1; j <= n; j++) {
                if(j-i*i>=0){
                    dp[j]=Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n]==n+1?-1:dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

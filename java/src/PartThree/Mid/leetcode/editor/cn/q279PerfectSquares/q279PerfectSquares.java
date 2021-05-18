package PartThree.Mid.leetcode.editor.cn.q279PerfectSquares;
//Java：完全平方数

public class q279PerfectSquares{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int ans=Integer.MAX_VALUE;
    public int numSquares(int n) {
        //dp[i]=min(dp[i-1^2],dp[i-2^2],...,dp[i-j^2])+1;
        int[] dp=new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 1; j * j<=i ; j++) {
                min=Math.min(min,dp[i-j*j]);
            }
            dp[i]=min+1;
        }

        return dp[n];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

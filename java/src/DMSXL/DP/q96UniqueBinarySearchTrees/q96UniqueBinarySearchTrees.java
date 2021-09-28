package DMSXL.DP.q96UniqueBinarySearchTrees;
//Java：不同的二叉搜索树
public class q96UniqueBinarySearchTrees{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=dp[0]*dp[1]+dp[1]*dp[0];
//        dp[3]=dp[0]*dp[2]+dp[1]*dp[1]+dp[2]*dp[0];

        for (int i = 3; i <=n ; i++) {
            for (int j = 0; j <=i-1; j++) {
                dp[i]+=dp[j]*dp[i-1-j];
            }
        }
        return dp[n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

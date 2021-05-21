package PartThree.Mid.q343IntegerBreak;
//Java：整数拆分

public class q343IntegerBreak{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.integerBreak(10));

    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        int r=dfs(n,dp);
        return r;
    }

    private int dfs(int k, int[] dp) {
        if(dp[k]!=0) return dp[k];
        int mul=0;

        for (int j = 1; j < k; j++) {
            mul=Math.max(mul,Math.max(j*dfs(k-j,dp),j*(k-j)));
        }
        dp[k]=mul;
        return dp[k];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

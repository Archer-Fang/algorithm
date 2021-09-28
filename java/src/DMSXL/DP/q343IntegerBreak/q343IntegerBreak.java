package DMSXL.DP.q343IntegerBreak;
//Java：整数拆分
public class q343IntegerBreak{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        if(n==1) return -1;
        if(n==2) return 1;
        int[] dp = new int[n+1];
        //分拆数字i可以获取的最大乘积dp[i]
        //dp[i]=Math.max(dp[j]*(i-j),j*(i-j));
        dp[2]=1;
        for (int i = 3; i <=n ; i++) {
            for (int j = 1; j <=i-1 ; j++) {
                dp[i]=Math.max(dp[i],Math.max(dp[j]*(i-j),j*(i-j)));
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

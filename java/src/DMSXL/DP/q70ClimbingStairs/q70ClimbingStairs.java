package DMSXL.DP.q70ClimbingStairs;
//Java：爬楼梯
public class q70ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.climbStairs(3);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        //有dp[j]种不同的方法可以爬到j,排列问题.
        //dp[i]=dp[i]+dp[i-nums[j]]
        int[] nums = new int[]{1,2};
        int[] dp = new int[n + 1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i]+=dp[i-nums[j]];
            }
        }
        return dp[n];

    }
    public int climbStairs2(int n) {
        if(n==1||n==2) return n;
        //有dp[j]种不同的方法可以爬到j阶
        //dp[j]=dp[j-1]+dp[j-2]
        int[] dp = new int[n + 1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for (int i = 2; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

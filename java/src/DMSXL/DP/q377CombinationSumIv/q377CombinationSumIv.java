package DMSXL.DP.q377CombinationSumIv;
//Java：组合总和 Ⅳ
public class q377CombinationSumIv{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int combinationSum4(int[] nums, int target) {
        //找出和为j的组合的个数dp[j]
        //dp[i]=dp[i]+dp[i-nums[j]]
        //排序背包容量在外，组合背包容量在内
        int[] dp = new int[target + 1];
        dp[0]=1;
        for (int i = 1; i <= target ; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i>=nums[j]) dp[i]+=dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

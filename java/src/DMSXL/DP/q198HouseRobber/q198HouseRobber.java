package DMSXL.DP.q198HouseRobber;
//Java：打家劫舍
public class q198HouseRobber{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        //偷盗第i间时，一夜之内能够偷窃到的最高金额dp[i]
        //dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-2])
        int[] dp = new int[101];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

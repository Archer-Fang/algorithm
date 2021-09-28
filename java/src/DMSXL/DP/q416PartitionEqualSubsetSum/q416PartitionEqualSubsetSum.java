package DMSXL.DP.q416PartitionEqualSubsetSum;

import java.util.Arrays;

//Java：分割等和子集
public class q416PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.canPartition(new int[]{1,2,5});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2==1) return false;
        sum/=2;
        //能否凑成子集总和为j的dp[j]
        //dp[j]=dp[j]||dp[j-nums[i]]
        //dp[0]=true;
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp,false);
        dp[0]=true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >=0  ; j--) {
                if(j>=nums[i]){
                    dp[j]=dp[j]||dp[j-nums[i]];
                }
            }
        }
        return dp[sum];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

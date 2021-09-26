package PartOneReWrite.Heap.q416PartitionEqualSubsetSum;

import java.util.Arrays;

//Java：分割等和子集
public class q416PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2==1) return false;
        sum/=2;
        boolean[] dp = new boolean[sum+1];
        dp[0]=true;
        //dp[j]=dp[j-nums[0]]||dp[j-nums[1]]||...||dp[j-nums[n]]
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >=1 ; j--) {
                if(j>=nums[i]){
                    dp[j]=dp[j]||dp[j-nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

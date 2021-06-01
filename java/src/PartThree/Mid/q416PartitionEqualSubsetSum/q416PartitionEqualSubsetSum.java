package PartThree.Mid.q416PartitionEqualSubsetSum;
//Java：分割等和子集

import java.util.Arrays;

public class q416PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.canPartition(new int[]{1,2,5}));
        System.out.println(solution.canPartition(new int[]{2,2,1,1}));
        System.out.println(solution.canPartition(new int[]{1,5,11,5}));

    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int target;
    public boolean canPartition(int[] nums) {
        target= Arrays.stream(nums).sum();
        if(target%2==1) return false;
        target/=2;
        boolean[] dp=new boolean[target+1];
        Arrays.fill(dp,false);
        //
        dp[0]=true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >-1 ; j--) {
                if(j>=nums[i]){
                    dp[j]=dp[j]||dp[j-nums[i]];//不取为dp[j]，取为dp[j-nums[i]];
                }

            }
        }
        return dp[target];

    }

}
//leetcode submit region end(Prohibit modification and deletion)

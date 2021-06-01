package PartThree.Mid.q494TargetSum;
//Java：目标和

import java.util.Arrays;

public class q494TargetSum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.findTargetSumWays(new int[]{1},1);
        solution.findTargetSumWays(new int[]{1,1,1,1,1},3);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum= Arrays.stream(nums).sum();
        int tmp=target+sum;
        if(tmp%2==1) return 0;
        if(sum<target) return 0;
        tmp/=2;
        int[] dp=new int[tmp+1];
        dp[0]=1;
        //dp[i]=dp[i]+dp[i-num[j]];
        for (int i = 0; i < nums.length; i++) {
            for (int j = tmp; j >=nums[i] ; j--) {
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[tmp];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

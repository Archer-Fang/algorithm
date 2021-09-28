package DMSXL.DP.q494TargetSum;

import java.util.Arrays;

//Java：目标和
public class q494TargetSum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //a-b=d && a+b=sum-->a=(sum+d)/2 && sum+d%2==0
        int sum = Arrays.stream(nums).sum();
        if((sum+target)%2==1||Math.abs(target)>sum) return 0;
        int amount=(sum+target)/2;
        int[] dp = new int[1000+1];
        //从nums的数组中挑中a个数字，使最终数组和为目标数amount的所有添加符号的方法数 dp[amount]
        //dp[j]=dp[j]+dp[j-nums[i]]
        dp[0]=1;
        for (int i = 0; i < nums.length; i++) {
            for(int j=amount;j>=nums[i];j--){
                dp[j]=dp[j]+dp[j-nums[i]];
            }
        }
        return dp[amount]==0?-1:dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

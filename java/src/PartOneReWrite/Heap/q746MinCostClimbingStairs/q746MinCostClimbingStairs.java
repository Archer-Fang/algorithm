package PartOneReWrite.Heap.q746MinCostClimbingStairs;

import java.util.Arrays;

//Java：使用最小花费爬楼梯
public class q746MinCostClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==0) return 0;
        else if(cost.length==1) return cost[0];
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        //dp[i]=Math.min(dp[i],dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
        dp[0]=0;
        dp[1]=0;
        dp[2]=Math.min(cost[0],cost[1]);
        for (int i = 3; i <= cost.length; i++) {
            dp[i]=Math.min(dp[i],Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]));
        }
        return dp[cost.length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

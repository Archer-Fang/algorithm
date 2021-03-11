package DP.q1449;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/10 20:37
 **/
class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] dp=new int[target+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0]=0;
        for(int i=cost.length;i>0;i--){
            for (int j=1;j<target+1;j++){
                if(j>=cost[i-1]){
                    dp[j]=Math.max(dp[j],dp[j-cost[i-1]]*10+i);
                }
            }
        }
        return String.valueOf(dp[target]);
    }
}

public class q1449 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] coins={4,3,2,5,6,7,2,5,5};
        System.out.println(solution.largestNumber(coins,9));
    }
}

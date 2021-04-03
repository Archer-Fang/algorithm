package PartTwo.qbytedance.q494;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/31 21:05
 **/
class Solution {

    //整数和为x，-负数的和为y
    //x+y=nums.sum()
    //x-y=S
    //x=(nums.sum()+S)/2
    //问题转换为从N个整数中整数和为x有几种方式
    //一维数组
    //dp[j]=dp[j]+dp[j-num]
    public int findTargetSumWays(int[] nums, int S) {
        int x= Arrays.stream(nums).sum()+S;
        if(x%2!=0||S>Arrays.stream(nums).sum()) return 0;
        x/=2;
        int[] dp=new int[x+1];
        dp[0]=1;
        for (int i=0;i<nums.length;i++){
            for (int j=x;j>=nums[i];j--){
                dp[j]=dp[j]+dp[j-nums[i]];
            }
        }
        return dp[x];
    }
}

public class q494 {
    public static void main(String[] args) {
        Solution solution=new Solution();
//        System.out.println(solution.findTargetSumWays(new int[]{1,1,1,1,1},3));
//        System.out.println(solution.findTargetSumWays(new int[]{1000},-1000));
        System.out.println(solution.findTargetSumWays(new int[]{1,2,1},0));
    }
}

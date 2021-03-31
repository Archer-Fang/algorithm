package PartOne.DP.q198;

/**
 * @author Created by Fangzj
 * @data 2021/3/11 11:31
 **/
class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for (int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];
    }
}
public class q198 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={1,2,3,1};
        System.out.println(solution.rob(nums));
    }
}

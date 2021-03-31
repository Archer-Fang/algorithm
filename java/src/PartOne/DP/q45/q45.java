package PartOne.DP.q45;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/12 19:53
 **/
class Solution {
    public int jump(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 0;
        //dp[i]=Math.min(dp[i-1],...,dp[i-nums{i}]);
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,nums.length+1);
        dp[1]=0;
        for (int i=1;i<nums.length;i++){
            for (int j=1;j<=nums[i-1];j++){
                if(i+j<=nums.length){
                    dp[i+j]=Math.min(dp[i+j],dp[i]+1);
                }
            }
        }
        return dp[nums.length];
    }
}

public class q45 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
    }
}

package DP.q416;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/11 12:56
 **/
class Solution {
    public boolean canPartition(int[] nums) {
        int target=0;
        for (Integer i:nums){
            target+=i;
        }
        if(target%2!=0) return false;
        target/=2;
        //F[i, target] = F[i - 1, target] || F[i - 1, target - nums[i]]
        Boolean[] dp=new Boolean[target+1];
        Arrays.fill(dp,false);
        dp[0]=true;
        for(int i=0;i<nums.length;i++){
            for (int j=target;j>-1;j--){
                if(j>=nums[i]){
                    dp[j]=dp[j]||dp[j-nums[i]];
                }
            }

        }
        return dp[target];

    }
}

public class q416 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={1, 5, 11, 5};
        System.out.println(solution.canPartition(nums));
    }
}


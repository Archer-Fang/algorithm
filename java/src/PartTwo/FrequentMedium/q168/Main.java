package PartTwo.FrequentMedium.q168;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/4/13 20:56
 **/
class Solution {
    public int solve(int[] nums) {
        if(nums.length<=1) return nums.length;
        int[][] dp = new int[2][nums.length];
        Arrays.fill(dp[0], 1);
        Arrays.fill(dp[1], 1);
        int max=-1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[0][i] = dp[0][i - 1] + 1;
                dp[1][i] = dp[1][i - 1] + 1;
            }
            if(i>=2&&nums[i] > nums[i - 2]) {
                dp[1][i] = Math.max(dp[0][i - 2] +1,dp[1][i]);
            }
            max=Math.max(max,dp[0][i]);
            max=Math.max(max,dp[1][i]);
        }
        return max;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{1,2,0,3}));
    }
}

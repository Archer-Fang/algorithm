package PartOne.DP.q279;

/**
 * @author Created by Fangzj
 * @data 2021/4/5 20:48
 **/

class Solution {
    //dp[i]=min(dp[i-1^2],dp[i-2^2],...,dp[i-j^2])+1;
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                min=Math.min(min,dp[i-j*j]);
            }
            dp[i]=min+1;
        }
        return dp[n];
    }
}
public class q279 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.numSquares(12));
    }
}

package Heap.q871;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/24 16:31
 **/
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations.length == 0) return target > startFuel ? -1 : 0;
        if(startFuel>=target) return 0;
        int n = stations.length;
        // dp[i][j]表示经过i站加油j次能够到达的最远距离
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = startFuel;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j<=i; j++) {
                //i站不加油
                if(dp[i-1][j]>=stations[i-1][0]){
                    dp[i][j]=dp[i-1][j];
                }
                //i站加油
                if(dp[i-1][j-1]>=stations[i-1][0]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+stations[i-1][1]);
                }

            }
        }
        for (int j=1;j<dp.length;j++){
            for (int i=1;i<dp.length;i++){
                if(dp[i][j]>=target) return j;
            }
        }
        return -1;
    }
}
public class q871 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minRefuelStops(1000,83,
                new int[][]{{15,475},{156,100},{100,100},{150,40},}));
    }
}

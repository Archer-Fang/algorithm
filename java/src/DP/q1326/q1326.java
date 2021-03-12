package DP.q1326;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/12 20:34
 **/
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] clips=new int[ranges.length][2];
        for (int i=0;i<ranges.length;i++){
            clips[i][0]=i-ranges[i]<0?0:i-ranges[i];
            clips[i][1]=i+ranges[i];
        }
        //dp[i]=Math.min(dp[ai])+1 (ai<=i<bi)
        int[] dp=new int[n+1];
        Arrays.fill(dp,clips.length+1);
        dp[0]=0;
        for (int i=1;i<n+1;i++){
            for (int j=0;j<clips.length;j++){
                if(clips[j][0]<=i&&clips[j][1]>=i){
                    dp[i]=Math.min(dp[clips[j][0]]+1,dp[i]);
                }
            }
        }
        return dp[n]>clips.length?-1:dp[n];

    }
}

public class q1326 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minTaps(5,new int[]{3,4,1,1,0,0}));
    }
}

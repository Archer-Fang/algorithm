package PartOne.DP.q1024;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/12 20:20
 **/
class Solution {
    public int videoStitching(int[][] clips,int T) {
        //dp[i]=Math.min(dp[ai])+1 (ai<=i<bi)
        int[] dp=new int[T+1];
        Arrays.fill(dp,clips.length+1);
        dp[0]=0;
        for (int i=1;i<T+1;i++){
            for (int j=0;j<clips.length;j++){
                if(clips[j][0]<=i&&clips[j][1]>=i){
                    dp[i]=Math.min(dp[clips[j][0]]+1,dp[i]);
                }
            }
        }
        return dp[T]>clips.length?-1:dp[T];

    }

}
public class q1024 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[][] tmp=new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        System.out.println(solution.videoStitching(tmp,10));
    }
}

package PartOne.DP.q322;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/10 16:49
 **/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] dp=new int[amount+1];
        int max=amount+1;
        Arrays.fill(dp,max);
        dp[0]=0;
        for(int i=0;i<=amount;i++){
            for (int j=0;j<coins.length;j++){
                if(i>=coins[j]){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }

        }
//error
//        for(int i=0;i<coins.length;i++){
//            for (int j=1;j<amount+1;j++){
//                if(j>coins[i]){
//                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
//                }
//            }
//        }
        return dp[amount]>amount?-1:dp[amount];
    }
}


public class q322 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] coins={1,2,5};
        System.out.println(solution.coinChange(coins,11));
    }
}

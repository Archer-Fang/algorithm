package PartTwo.FrequentMedium.q475;

/**
 * @author Created by Fangzj
 * @data 2021/4/13 20:34
 **/
//设i为位数，j为数字的结尾
//dp[i][j] += dp[i - 1][k] if(j>k)
//dp[1][0]=0,dp[1][1]=1,dp[1][2]=2,...dp[1][9]=9
//dp[2][0]=0,dp[2][1]=0,dp[2][2]=dp[1][1]=1,dp[2][3]=dp[1][1]+dp[1][2]=3,
class Solution {
    public int solve(int n) {
        int[][] dp=new int[n+1][10];
        for (int i=1;i<10;i++){
            dp[1][i]=i;
        }
        for (int i=2;i<n+1;i++){
            for (int j=2;j<10;j++){
                for (int k=0;k<j;k++){
                    dp[i][j]+=dp[i-1][k];
                }
            }
        }
        return dp[n][9];

    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.solve(1));
        System.out.println(solution.solve(2));
        System.out.println(solution.solve(3));
    }
}

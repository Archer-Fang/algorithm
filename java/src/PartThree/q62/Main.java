package PartThree.q62;

/**
 * @author Created by Fangzj
 * @data 2021/5/10 20:37
 **/


class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0){
                    dp[i][j]=1;
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.uniquePaths(3,7));
        System.out.println(solution.uniquePaths(3,3));
    }
}

package DMSXL.DP.q63UniquePathsIi;
//Java：不同路径 II
public class q63UniquePathsIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        //dp[i][j]=dp[i-1][j]+dp[i][j-1];
        for (int i = 0; i < obstacleGrid.length&& obstacleGrid[i][0] == 0; i++) {
            dp[i][0]=1;
        }
        for (int j = 0; j < obstacleGrid[0].length&& obstacleGrid[0][j] == 0; j++) {
            dp[0][j]=1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

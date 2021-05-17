package PartThree.Mid.leetcode.editor.cn.q221MaximalSquare;
//Java：最大正方形

public class q221MaximalSquare{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});

    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        //dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1],dp[i][j])+1
        int m=matrix.length,n=matrix[0].length;
        int[][] dp=new int[m+1][n+1];
        int[][] matrix2=new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix2[i+1][j+1]=matrix[i][j];
            }
        }
        int max=0;
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(matrix2[i][j]=='1'){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }

    private void dfs(char[][] matrix,int[][] dp, int i, int j, int m, int n,int step) {
        if(i<0||j<0||i>=m||j>=n||i+step>=m||j+step>=n){
            return;
        }
        for (int k = i; k <= i+step; k++) {
            if(matrix[k][j+step]=='0') return;
        }
        for (int k = j; k <= j+step; k++) {
            if(matrix[i+step][j]=='0') return;
        }
        dp[i][j]=(1+step)*(1+step);
        dfs(matrix,dp,i+1,j+1,m,n,step+1);

    }

}
//leetcode submit region end(Prohibit modification and deletion)

package PartOneReWrite.Heap.q877StoneGame;
//Java：石子游戏
public class q877StoneGame{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.stoneGame(new int[]{5,3,4,5}));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        //dp[i][j]=Math.max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1])
        for (int i = 0; i < piles.length; i++) {
            int pile = piles[i];
            dp[i][i]=pile;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i+l-1 < n; i++) {
                dp[i][i+l-1]=Math.max(piles[i]-dp[i+1][i+l-1],piles[i+l-1]-dp[i][i+l-1-1]);
            }
        }
        return dp[0][n-1]>0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

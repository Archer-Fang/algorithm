package DMSXL.DP.q72EditDistance;
//Java：编辑距离
public class q72EditDistance{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        //word1[0:i] 转换成 word2[0:j] 所使用的最少操作数 dp[i][j]。
        //if(word1[i]==word2[j]) dp[i+1][j+1]=dp[i][j]
        //else dp[i+1][j+1]=min(dp[i][j+1]+1,dp[i+1][j]+1,dp[i][j]+1);
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length(); i++) {
            dp[i+1][0]=i+1;
        }
        for (int i = 0; i < word2.length(); i++) {
            dp[0][i+1]=i+1;
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if(word1.charAt(i)==word2.charAt(j)) dp[i+1][j+1]=dp[i][j];
                else dp[i+1][j+1]=Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i][j])+1;
            }
        }
        return dp[word1.length()][word2.length()];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

package DMSXL.DP.q1143LongestCommonSubsequence;
//Java：最长公共子序列
public class q1143LongestCommonSubsequence{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //这两个字符串各到下标i,j时的最长公共子序列的长度dp[i][j]。
        //if(text1[i]==text2[j]) dp[i][j]=dp[i-1][j-1]+1
        //else dp[i][]j=Math.max(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]);
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if(chars1[i]==chars2[j]) {
                    dp[i+1][j+1]=dp[i][j]+1;
                }else {
                    dp[i+1][j+1]=Math.max(dp[i][j],Math.max(dp[i+1][j],dp[i][j+1]));
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

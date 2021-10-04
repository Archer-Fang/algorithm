package DMSXL.DP.q516LongestPalindromicSubsequence;
//Java：最长回文子序列
public class q516LongestPalindromicSubsequence{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.longestPalindromeSubseq("bbbab");
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        int ans=0;
        //最长的回文子序列s[i:j]的最大长度dp[i][j]
        //if(s.charAt(i)==s.charAt(j)) dp[i][j]=dp[i+1][j-1]+2
        //else dp[i][j]=max(dp[i+1][j],dp[i][j-1],dp[i+1][j-1])

        int[][] dp = new int[1001][1001];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i]=1;
        }
        for (int i = 0; i+1 < s.length(); i++) {
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=2;
            }
        }
        for (int l = 2; l <=s.length() ; l++) {
            for (int i = 0; i+l-1 <s.length() ; i++) {
                if(s.charAt(i)==s.charAt(i+l-1)) dp[i][i+l-1]=dp[i+1][i+l-2]+2;
                else dp[i][i+l-1]=Math.max(dp[i][i+l-2],dp[i+1][i+l-1]);
            }
        }

        return dp[0][s.length()-1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

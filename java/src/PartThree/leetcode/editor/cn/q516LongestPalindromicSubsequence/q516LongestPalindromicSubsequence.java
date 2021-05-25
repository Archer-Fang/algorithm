package PartThree.leetcode.editor.cn.q516LongestPalindromicSubsequence;
//Java：最长回文子序列

public class q516LongestPalindromicSubsequence{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        //dp
        char[] chars = s.toCharArray();
        int[][] dp=new int[s.length()][s.length()];
//        if(chars[i]==chars[j]){
//            dp[i][j]=dp[i+1][j-1]+2;
//        }else {
//            dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
//        }
        for (int l = 0; l < chars.length; l++) {
            for (int i = 0; i < chars.length-l; i++) {
                if(l==0) dp[i][i+l]=1;
                else if(chars[i]==chars[i+l]){
                    dp[i][i+l]=dp[i+1][i+l-1]+2;
                }else if(chars[i]!=chars[i+l]){
                    dp[i][i+l]=Math.max(dp[i+1][i+l],dp[i][i+l-1]);
                }
            }
        }
        return dp[0][chars.length-1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

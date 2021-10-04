package DMSXL.DP.q392IsSubsequence;
//Java：判断子序列
public class q392IsSubsequence{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubsequence(String s, String t) {
        //dp[i][j]:s的下标i-1是否为t-1的下标j的子序列
        //dp[i+1][j+1]=dp[i][j]&&s[i]==t[j]
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0]=0;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < t1.length; j++) {
                if(s1[i]==t1[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else {
                    dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
                }

            }
        }
        return dp[s1.length][t1.length]==s1.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

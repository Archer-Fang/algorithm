package DMSXL.DP.q115DistinctSubsequences;
//Java：不同的子序列
public class q115DistinctSubsequences{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.numDistinct("babgbag","bag"));;//5
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {
        //dp[i][j]表示以s下标i-1的子序列中 t 下标j-1出现的个数。
        //if(s[i]==t[i]) dp[i+1][j+1]=dp[i][j]+dp[i][j+1]
        //else dp[i+1][j+1]=dp[i][j+1];
        if(s.length()==0) return 0;
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if(s.charAt(i)==t.charAt(j)) dp[i+1][j+1]=dp[i][j]+dp[i][j+1];
                else dp[i+1][j+1]=dp[i][j+1];
            }
        }
        return dp[s.length()][t.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

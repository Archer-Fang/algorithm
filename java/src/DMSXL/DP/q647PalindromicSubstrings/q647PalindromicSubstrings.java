package DMSXL.DP.q647PalindromicSubstrings;
//Java：回文子串
public class q647PalindromicSubstrings{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.countSubstrings("aaa");
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int ans=0;
        //s[i:j]是否为回文串dp[i][j]
        //dp[i][j]=dp[i+1][j-1]&&s.charAt(i)==s.charAt(j)
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i]=true;
            ans++;
        }
        for (int i = 0; i+1 < dp.length; i++) {
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                ans++;
            }
        }
        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0; i+l <=s.length() ; i++) {
                if(dp[i+1][i+l-2]&&s.charAt(i)==s.charAt(i+l-1)){
                    dp[i][i+l-1]=true;
                    ans++;
                }
            }
        }
        return ans;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

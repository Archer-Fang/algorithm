package PartThree.leetcode.editor.cn.q647PalindromicSubstrings;
//Java：回文子串
public class q647PalindromicSubstrings{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.countSubstrings("aba"));//4
        System.out.println(solution.countSubstrings("abc"));
        System.out.println(solution.countSubstrings("aaa"));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        //dp[i][j]=dp[i+1][j-1]&&s[i]==s[j]
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        int ans=0;
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i+l < chars.length; i++) {
                if(l==0) {
                    dp[i][i+l]=true;
                    ans++;
                }else if(l==1){
                    if(chars[i]==chars[i+l]){
                        dp[i][i+l]=true;
                        ans++;
                    }
                }
                else {
                    if(dp[i+1][i+l-1]==true&&chars[i]==chars[i+l]){
                        dp[i][i+l]=true;
                        ans++;
                    }
                }

            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package PartFourCodeTop.q5LongestPalindromicSubstring;
//Java：最长回文子串
public class q5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int max=1;
        int start=0,end=0;
        //dp
        int[][] dp = new int[s.length()][s.length()];
        //init
        for (int i = 0; i < s.length(); i++) {
            dp[i][i]=1;
        }
        for (int l = 2; l <= s.length(); l++) {
            for (int i = 0; i+l-1<s.length();i++){
                if((s.charAt(i)==s.charAt(i+l-1)&&l==2)||(s.charAt(i)==s.charAt(i+l-1)&&dp[i+1][i+l-2]==1)){
                    dp[i][i+l-1]=1;
                    if(l>max){
                        max=l;
                        start=i;
                        end=i+l-1;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

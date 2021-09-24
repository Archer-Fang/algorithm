package PartOneReWrite.Heap.q5LongestPalindromicSubstring;
//Java：最长回文子串
public class q5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.longestPalindrome("babad"));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int ans=0;
        int[] ansIndex=new int[2];
        for (int l = 0; l < n; l++) {
            for (int i = 0; i+l < n; i++) {
                if(l==0) dp[i][i+l]=1;
                else if(l==1&&s.charAt(i)==s.charAt(i+l)) dp[i][i+l]=1;
                else if(s.charAt(i)==s.charAt(i+l) && dp[i+1][i+l-1]==1) dp[i][i+l]=1;
                if((l+1)>=ans&&dp[i][i+l]==1){
                    ans=l+1;
                    ansIndex[0]=i;
                    ansIndex[1]=i+l;
                }
            }
        }
        return s.substring(ansIndex[0],ansIndex[1]+1);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

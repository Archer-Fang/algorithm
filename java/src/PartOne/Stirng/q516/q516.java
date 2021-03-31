package PartOne.Stirng.q516;

/**
 * @author Created by Fangzj
 * @data 2021/3/11 20:37
 **/
class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp=new int[s.length()][s.length()];
        for(int i=0;i<dp[0].length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==j) dp[i][j]=1;
            }
        }
        for(int i=s.length()-2;i>=0;i--){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];


    }
}
public class q516 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
    }
}

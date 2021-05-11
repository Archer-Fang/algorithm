package PartThree.Mid.q5;

/**
 * @author Created by Fangzj
 * @data 2021/5/8 11:00
 **/
class Solution {
    public String longestPalindrome(String s) {
        int left=-1,right=-1,ans=-1;
        //如果外围为回文，则内部必为回文
        int[][] dp=new int[s.length()][s.length()];
        for (int l=0;l<s.length();l++){
            for (int i=0;i<s.length()-l;i++){
                if(l==0){
                    dp[i][i]=1;
                }
                else if(l==1){
                    if(s.charAt(i)==s.charAt(i+l)){
                        dp[i][i+l]=1;
                    }
                }
                else if(l>1&&dp[i+1][i+l-1]==1&&s.charAt(i)==s.charAt(i+l)){
                    dp[i][i+l]=1;
                }
                if(l>ans&&dp[i][i+l]==1){
                    ans=l;
                    left=i;
                    right=i+l;
                }
            }
        }
        return s.substring(left,right+1);
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}

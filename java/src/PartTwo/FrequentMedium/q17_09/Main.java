package PartTwo.FrequentMedium.q17_09;

/**
 * @author Created by Fangzj
 * @data 2021/4/13 19:27
 **/
class Solution {
    public int getKthMagicNumber(int k) {
        //三指针
        //1，3，5，7，3*3，3*5，3*7,
        int a=0,b=0,c=0;
        int[] dp=new int[k];
        dp[0]=1;
        for (int i=1;i<k;i++){
            dp[i]=getMin(dp[a]*3,dp[b]*5,dp[c]*7);
            if(dp[i]==dp[a]*3){
                a++;
            }
            if(dp[i]==dp[b]*5){
                b++;
            }
            if(dp[i]==dp[c]*7){
                c++;
            }
        }
        return dp[k-1];

    }

    public int getMin(int x,int y,int z){
        return Math.min(x,Math.min(y,z));
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.getKthMagicNumber(50));
    }
}

package PartThree.Mid.q799ChampagneTower;
//Java：香槟塔

public class q799ChampagneTower{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.champagneTower(1,1,1));
        System.out.println(solution.champagneTower(2,1,1));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        //dp[i+1][j]+=0.5*dp[i][j]
        //dp[i+1][j+1]+=0.5*dp[i][j]
        double[][] dp=new double[100][100];
        dp[0][0]=poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if(dp[i][j]>1){
                    double half=dp[i][j]-1;
                    half/=2;
                    dp[i+1][j]+=half;
                    dp[i+1][j+1]+=half;
                }
            }
        }
        return dp[query_row][query_glass]>1?1:dp[query_row][query_glass];

    }

}
//leetcode submit region end(Prohibit modification and deletion)

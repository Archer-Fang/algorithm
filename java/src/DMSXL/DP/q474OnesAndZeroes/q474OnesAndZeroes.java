package DMSXL.DP.q474OnesAndZeroes;
//Java：一和零
public class q474OnesAndZeroes{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。
        //dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
        int[][] dp = new int[m + 1][n + 1];
        for (int k = 0; k < strs.length; k++) {
            int[] ints = computeZeroAndOne(strs[k]);
            int zeroNum=ints[0];
            int oneNum=ints[1];
            for(int i=m;i>=zeroNum;i--){
                for(int j=n;j>=oneNum;j--){
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeroNum][j-oneNum]+1);
                }
            }
        }
        return dp[m][n];
    }
    public int[] computeZeroAndOne(String str){
        int c1=0;
        int c2=0;
        for (char c : str.toCharArray()) {
            if(c=='0') c1++;
            else c2++;
        }
        return new int[]{c1,c2};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

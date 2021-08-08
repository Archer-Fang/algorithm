package PartThree.leetcode.editor.cn.q72EditDistance;
//Java：编辑距离
public class q72EditDistance{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.minDistance("zoologicoarchaeologist","zoogeologist"));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length()+1; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i < word2.length()+1; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i < word1.length()+1; i++) {
            for (int j = 1; j < word2.length()+1; j++) {
                int min=getMin(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]);
                dp[i][j]=word1.charAt(i-1)==word2.charAt(j-1)?dp[i-1][j-1]:min+1;
            }
        }
        return dp[word1.length()][word2.length()];
    }
    public int getMin(int i,int j,int k){
        int m=Math.min(i,j);
        return Math.min(m,k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

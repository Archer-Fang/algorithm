package DMSXL.DP.q718MaximumLengthOfRepeatedSubarray;
//Java：最长重复子数组
public class q718MaximumLengthOfRepeatedSubarray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        //dp[i][j]表示以i,j结尾的，最长的公共的、长度最长的子数组的长度dp[i][j]。
        //if(nums1[i]==nums2[j])dp[i][j]=dp[i-1][j-1]+1;
        int[][] dp = new int[nums1.length + 1][nums2.length+1];
        int ans=0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i]==nums2[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                }
                ans=Math.max(ans,dp[i+1][j+1]);
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

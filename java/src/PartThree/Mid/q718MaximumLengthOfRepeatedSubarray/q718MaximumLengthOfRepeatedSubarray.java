package PartThree.Mid.q718MaximumLengthOfRepeatedSubarray;
//Java：最长重复子数组

public class q718MaximumLengthOfRepeatedSubarray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.findLength(new int[]{0,1,1,1,1},new int[]{1,0,1,0,1}));;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length][nums2.length];
        //dp[i][j]=dp[i-1][j-1]+1 if nums1[i]==nums2[j]
        int max=0;
        for (int i = 0; i < nums1.length; i++) {
            int i1 = nums1[i];
            if(i1==nums2[0]) {
                dp[i][0]=1;
                max=1;
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            int i1 = nums2[i];
            if(i1==nums1[0]){
                dp[0][i]=1;
                max=1;
            }
        }

        for (int i = 1; i < nums1.length; i++) {
            int i1 = nums1[i];
            for (int j = 1; j < nums2.length; j++) {
                int i2 = nums2[j];
                if(i1==i2){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

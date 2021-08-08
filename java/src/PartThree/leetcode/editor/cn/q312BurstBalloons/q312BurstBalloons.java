package PartThree.leetcode.editor.cn.q312BurstBalloons;

//Java：戳气球
public class q312BurstBalloons{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.maxCoins(new int[]{3,1,5,8}));
        System.out.println(solution.maxCoins(new int[]{1,5}));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        System.arraycopy(nums,0,newNums,1,nums.length);
        newNums[0]=1;
        newNums[newNums.length-1]=1;
        int[][] dp=new int[newNums.length][newNums.length];
        for (int l = 2; l <=newNums.length; l++) {
            for (int i = 0; i+l <newNums.length ; i++) {
                rangeMax(newNums,i,i+l,dp);
            }
        }
        return dp[0][newNums.length-1];
    }

    private void rangeMax(int[] nums, int i, int j, int[][] dp) {
        int m=0;
        for (int k = i+1; k < j; k++) {
            m=Math.max(m,dp[i][k]+dp[k][j]+nums[i]*nums[k]*nums[j]);
        }
        dp[i][j]=m;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

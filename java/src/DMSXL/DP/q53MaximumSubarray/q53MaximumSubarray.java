package DMSXL.DP.q53MaximumSubarray;
//Java：最大子序和
public class q53MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int ans=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(sum>=0) sum+=nums[i];
            else sum=nums[i];
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

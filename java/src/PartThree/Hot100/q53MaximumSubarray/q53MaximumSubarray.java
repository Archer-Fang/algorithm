package PartThree.Hot100.q53MaximumSubarray;
//Java：最大子序和
public class q53MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int preSum=nums[0],ans=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if(preSum<0){preSum=0;}
            ans=Math.max(ans,num+preSum);
            preSum+=num;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

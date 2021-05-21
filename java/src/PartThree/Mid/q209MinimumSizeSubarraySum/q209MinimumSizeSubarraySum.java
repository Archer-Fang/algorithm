package PartThree.Mid.q209MinimumSizeSubarraySum;
//Java：长度最小的子数组

public class q209MinimumSizeSubarraySum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int ans=nums.length+1;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            while (sum>=target){
                ans=Math.min(ans,i-l+1);
                sum-=nums[l++];
            }
        }
        return ans==nums.length+1?0:ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

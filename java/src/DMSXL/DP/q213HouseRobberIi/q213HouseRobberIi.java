package DMSXL.DP.q213HouseRobberIi;

import java.util.Arrays;

//Java：打家劫舍 II
public class q213HouseRobberIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.rob(new int[]{1,2,1,1});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        if(nums.length==3) return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        //偷了第一间，就不能偷最后一间。
        //偷了最后一间，就不能偷第一间。
        int[] nums1= Arrays.copyOfRange(nums,0,nums.length-1);
        int[] dp1 = new int[101];
        dp1[0]=nums1[0];
        dp1[1]=Math.max(nums1[0],nums1[1]);
        for (int i = 2; i < nums1.length; i++) {
            dp1[i]=Math.max(dp1[i-1],dp1[i-2]+nums1[i]);
        }

        int[] nums2= Arrays.copyOfRange(nums,1,nums.length);
        int[] dp2 = new int[101];
        dp2[0]=nums2[0];
        dp2[1]=Math.max(nums2[0],nums2[1]);
        for (int i = 2; i < nums2.length; i++) {
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+nums2[i]);
        }
        return Math.max(dp1[nums1.length-1],dp2[nums2.length-1]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

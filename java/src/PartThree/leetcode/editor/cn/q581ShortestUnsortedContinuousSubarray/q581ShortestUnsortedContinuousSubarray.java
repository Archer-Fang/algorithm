package PartThree.leetcode.editor.cn.q581ShortestUnsortedContinuousSubarray;
//Java：最短无序连续子数组
public class q581ShortestUnsortedContinuousSubarray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));//5

    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length<=1) return 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int R = 0;
        int L = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<max) {
                R = i;
            }
            max = Math.max(max, nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i]>min) {
                L = i;
            }
            min = Math.min(min, nums[i]);
        }
        return R == L ? 0 : R - L + 1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

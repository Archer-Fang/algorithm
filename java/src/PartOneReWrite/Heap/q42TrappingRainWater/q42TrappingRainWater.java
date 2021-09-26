package PartOneReWrite.Heap.q42TrappingRainWater;
//Java：接雨水
public class q42TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int ans=0;
        int maxl=0;
        int maxr=0;
        for (int i = 0; i < height.length; i++) {
            maxl=Math.max(maxl,height[i]);
            left[i]=maxl;
            maxr=Math.max(maxr,height[height.length-1-i]);
            right[height.length-i-1]=maxr;
        }
        for (int i = 0; i < left.length; i++) {
            ans+=Math.min(left[i],right[i])-height[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

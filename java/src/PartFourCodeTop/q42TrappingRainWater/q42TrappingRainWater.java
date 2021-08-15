package PartFourCodeTop.q42TrappingRainWater;
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
        int max = -1;
        for (int i = 0; i < height.length; i++){
            max=height[i]>max?height[i]:max;
            left[i]=max;
        }
        max = -1;
        for (int i = height.length-1; i >-1; i--){
            max=height[i]>max?height[i]:max;
            right[i]=max;
        }
        int ans=0;
        for (int i = 0; i < height.length;i++){
            ans+=Math.min(left[i],right[i])-height[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package PartThree.Mid.q152MaximumProductSubarray;
//Java：乘积最大子数组

public class q152MaximumProductSubarray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.maxProduct(new int[]{-4,-3,-2});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getMax(int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }
    public int getMin(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        int ans=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp1=max*nums[i];
            int tmp2=min*nums[i];
            max=getMax(nums[i],tmp1,tmp2);
            min=getMin(nums[i],tmp1,tmp2);
            ans=Math.max(max,ans);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

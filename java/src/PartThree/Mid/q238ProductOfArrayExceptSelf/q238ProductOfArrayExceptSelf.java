package PartThree.Mid.q238ProductOfArrayExceptSelf;
//Java：除自身以外数组的乘积

public class q238ProductOfArrayExceptSelf{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //1 2 3 4
        //2*3*4 1*3*4 1*2*4 1*2*3
        //1*2*3*4 1*3*4 1*2*4 1*2*3*1
        int[] ans=new int[nums.length];
        int sum=1;
        for (int i = 0; i < nums.length; i++) {
            ans[i]=sum;
            sum*=nums[i];
        }
        sum=1;
        for (int i = nums.length-1; i >-1 ; i--) {
            ans[i]*=sum;
            sum*=nums[i];
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

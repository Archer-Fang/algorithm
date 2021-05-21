package PartThree.Mid.q169MajorityElement;
//Java：多数元素

public class q169MajorityElement{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        int c=1;
        int major=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(c==0){
                major=nums[i];
            }
            if(major==nums[i])c++;
            else c--;
        }
        return major;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

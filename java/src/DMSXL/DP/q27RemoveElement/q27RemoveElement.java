package DMSXL.DP.q27RemoveElement;
//Java：移除元素
public class q27RemoveElement{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.removeElement(new int[]{3,2,2,3},3);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val) nums[k++]=nums[i];
        }
        return k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

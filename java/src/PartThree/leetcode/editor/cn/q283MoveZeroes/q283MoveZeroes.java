package PartThree.leetcode.editor.cn.q283MoveZeroes;
//Java：移动零
public class q283MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=0){
                nums[i++]=nums[j];
            }
        }
        for (int j = i; j < nums.length; j++) {
            nums[j]=0;
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

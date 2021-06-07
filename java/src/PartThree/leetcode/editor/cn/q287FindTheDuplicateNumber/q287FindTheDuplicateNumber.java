package PartThree.leetcode.editor.cn.q287FindTheDuplicateNumber;

//Java：寻找重复数
public class q287FindTheDuplicateNumber{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(solution.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(solution.findDuplicate(new int[]{1,1}));
        System.out.println(solution.findDuplicate(new int[]{1,1,2}));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        //double point
        //fast=2s
        //slow=s;
        //a+nb=k
        //slow=a+x
        //fast=a+x+nb
        //s=nb;
        //
        int slow=0,fast=0;
        slow=nums[slow];
        fast=nums[nums[fast]];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        fast=0;
        while (fast!=slow){
            slow=nums[slow];
            fast=nums[fast];
        }
        return fast;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

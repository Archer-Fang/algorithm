package PartThree.Mid.q456One32Pattern;
//Java：132 模式

import java.util.Stack;

public class q456One32Pattern{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.find132pattern(new int[]{1,2,3,4});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length<3) return false;
        int[] minLeft=new int[nums.length];
        minLeft[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            minLeft[i]=Math.min(minLeft[i-1],nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(Integer.MAX_VALUE);
        for (int i = nums.length-1; i >0 ; i--) {
            while (!stack.isEmpty()&&nums[i]>stack.peek()){
                int tmp=stack.pop();
                if(tmp>minLeft[i-1]) return true;
            }
            stack.add(nums[i]);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

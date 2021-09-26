package PartOneReWrite.Heap.q503NextGreaterElementIi;

import java.util.Arrays;
import java.util.Stack;

//Java：下一个更大元素 II
public class q503NextGreaterElementIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] newNums = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            newNums[i]=nums[i];
            newNums[i+nums.length]=nums[i];
        }
        Stack<Item> stack = new Stack<>();
        int[] ans = new int[nums.length*2];
        Arrays.fill(ans,-1);
        for (int i = 0; i < newNums.length; i++) {
            while (!stack.isEmpty()&&newNums[i]>stack.peek().num){
                Item pop = stack.pop();
                ans[pop.index]=newNums[i];
            }
            stack.add(new Item(i,newNums[i]));
        }
        return Arrays.copyOfRange(ans,0,nums.length);
    }
    class Item{
        int index;
        int num;

        public Item(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package PartOneReWrite.Heap.q496NextGreaterElementI;

import java.util.Arrays;
import java.util.Stack;

//Java：下一个更大元素 I
public class q496NextGreaterElementI{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //下一个大-》单调递减栈
        Stack<Item> stack = new Stack<>();
        int[] record = new int[nums2.length];
        Arrays.fill(record,-1);
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty()&&nums2[i]>stack.peek().num){
                record[stack.pop().index]= nums2[i];
            }
            stack.add(new Item(i,nums2[i]));
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i]=record[findPos(nums2,nums1[i])];
        }
        return ans;

    }
    private int findPos(int[] ans,int a){
        for (int i = 0; i < ans.length; i++) {
            if(ans[i]==a) return i;
        }
        return -1;
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

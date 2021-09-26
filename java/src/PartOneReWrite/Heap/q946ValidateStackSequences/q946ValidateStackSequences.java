package PartOneReWrite.Heap.q946ValidateStackSequences;

import java.util.Stack;

//Java：验证栈序列
public class q946ValidateStackSequences{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length==0&&popped.length==0||popped.length==1&&pushed.length==1&&pushed[0]==popped[0]) return true;
        if(pushed.length!=popped.length) return false;
        Stack<Integer> stack = new Stack<Integer>();
        int j=0;
        for (int i : pushed) {
            stack.add(i);
            while (!stack.isEmpty()&&stack.peek()==popped[j]){
                j++;
                stack.pop();
            }
        }
        return j==popped.length;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

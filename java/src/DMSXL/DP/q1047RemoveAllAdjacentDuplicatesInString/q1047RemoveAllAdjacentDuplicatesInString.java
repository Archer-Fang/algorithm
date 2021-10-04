package DMSXL.DP.q1047RemoveAllAdjacentDuplicatesInString;

import java.util.Stack;

//Java：删除字符串中的所有相邻重复项
public class q1047RemoveAllAdjacentDuplicatesInString{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(!stack.isEmpty()&&stack.peek()==c){
                stack.pop();
            }
            else {
                stack.add(c);
            }


        }
        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty()){
            buffer.append(stack.pop());
        }
        return buffer.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

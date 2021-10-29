package DMSXL.DP2.q20ValidParentheses;

import java.util.Stack;

//Java：有效的括号
public class q20ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c=='['||c=='('||c=='{'){
                stack.add(c);
            }else {
                if(!stack.isEmpty()){
                    if(c==']'&&stack.peek()=='['||c==')'&&stack.peek()=='('||c=='}'&&stack.peek()=='{'){
                        stack.pop();
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

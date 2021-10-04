package DMSXL.DP.q20ValidParentheses;

import java.util.Stack;

//Java：有效的括号
public class q20ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.isValid("(])");//false
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if(s.length()==0) return true;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {

            if((aChar==')'||aChar=='}'||aChar==']')){
                if(aChar==')'&&!stack.isEmpty()&&stack.peek()=='(') stack.pop();
                else if(aChar==']'&&!stack.isEmpty()&&stack.peek()=='[') stack.pop();
                else if(aChar=='}'&&!stack.isEmpty()&&stack.peek()=='{') stack.pop();
                else return false;
            }else {
                stack.add(aChar);
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

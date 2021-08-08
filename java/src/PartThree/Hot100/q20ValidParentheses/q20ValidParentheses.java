package PartThree.Hot100.q20ValidParentheses;

import java.util.Stack;

//Java：有效的括号
public class q20ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.isValid("({[)"));
        System.out.println(solution.isValid("{[]}"));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(aChar==')'||aChar==']'||aChar=='}'){
                if(aChar==')') aChar='(';
                if(aChar==']') aChar='[';
                if(aChar=='}') aChar='{';
                if (stack.isEmpty()||stack.pop()!=aChar) return false;
            }
            else {stack.push(aChar);}
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package DMSXL.DP.q150EvaluateReversePolishNotation;

import java.util.Stack;

//Java：逆波兰表达式求值
public class q150EvaluateReversePolishNotation{
    public static void main(String[] args) {
        DMSXL.DP.q150EvaluateReversePolishNotation.Solution solution = new DMSXL.DP.q150EvaluateReversePolishNotation.Solution();
        // TO TEST
        System.out.println(solution.evalRPN(new String[]{"2","1","+","3","*"}));;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if("+".equals(tokens[i])){
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.add(a+b);
            }else if("-".equals(tokens[i])){
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.add(b-a);
            }else if("*".equals(tokens[i])){
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.add(a*b);
            }else if("/".equals(tokens[i])){
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.add(b/a);
            }else {
                stack.add(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

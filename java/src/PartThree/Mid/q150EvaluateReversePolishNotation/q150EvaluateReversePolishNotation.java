package PartThree.Mid.q150EvaluateReversePolishNotation;
//Java：逆波兰表达式求值

import java.util.Stack;

public class q150EvaluateReversePolishNotation{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack=new Stack<>();
        for (String tmp :
                tokens) {

            if(tmp.equals("+")){
                int b=numStack.pop();
                int a=numStack.pop();
                numStack.add(a+b);
            }else if(tmp.equals("-")){
                int b=numStack.pop();
                int a=numStack.pop();
                numStack.add(a-b);
            }else if(tmp.equals("*")){
                int b=numStack.pop();
                int a=numStack.pop();
                numStack.add(a*b);
            }else if(tmp.equals("/")){
                int b=numStack.pop();
                int a=numStack.pop();
                numStack.add(a/b);
            }else {
                numStack.add(Integer.parseInt(tmp));
            }
        }
        return numStack.pop();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

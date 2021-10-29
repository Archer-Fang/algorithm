package DMSXL.DP.q227BasicCalculatorIi;

import java.util.HashMap;
import java.util.Stack;

//Java：基本计算器 II
public class q227BasicCalculatorIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.calculate("1-1+1");
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        if(s==null) return 0;
        s=s.replaceAll(" ", "");
        Stack<Long> stack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        int i=0;
        long num=0;
        while (i<chars.length){
            if(Character.isDigit(chars[i])){
                num=Long.parseLong(String.valueOf(chars[i++]));
                while (i<chars.length&&Character.isDigit(chars[i])){
                    num=num*10+Long.parseLong(String.valueOf(chars[i++]));
                }
                stack.add(num);
            }
            else {
                while (!opStack.isEmpty()&&map.get(chars[i])<=map.get(opStack.peek())){
                    Long pop = stack.pop();
                    Long pop2 = stack.pop();
                    stack.add(cal(pop2,pop,opStack.pop()));
                }
                opStack.add(chars[i++]);

            }
        }
        while (!opStack.isEmpty()){
            long pop = stack.pop();
            long pop2 = stack.pop();
            stack.add(cal(pop2,pop,opStack.pop()));
        }
        return Math.toIntExact(stack.peek());

    }
    public long cal(Long a,Long b,char opt){
        if(opt=='+') return a+b;
        if(opt=='-') return a-b;
        if(opt=='*') return a*b;
        if(opt=='/') return a/b;
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package DMSXL.DP.q224BasicCalculator;

import java.util.HashMap;
import java.util.Stack;

//Java：基本计算器
public class q224BasicCalculator{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.calculate("(1+(4+5+2)-3)+(6+8)");
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        s=s.replaceAll(" ","");
        Stack<Long> stack = new Stack<>();
        Stack<Integer> opStack = new Stack<>();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int i=0;
        long num=0;
        long r=0;
        int sign=1;
        while (i<chars.length){
            if(Character.isDigit(chars[i])){
                num=Long.parseLong(String.valueOf(chars[i++]));
                while (i<chars.length&&Character.isDigit(chars[i])){
                    num=Long.parseLong(String.valueOf(chars[i++]))+num*10;
                }
                r=num*sign+r;
            }else {
                if(chars[i]=='+'){
                    sign=1;
                }else if(chars[i]=='-'){
                    sign=-1;
                }
                else if(chars[i]=='(') {
                    stack.add(r);
                    opStack.add(sign);
                    r=0;
                    sign=1;
                }else if(chars[i]==')'){
                    r=stack.pop()+opStack.pop()*r;
                }
                i++;

            }
        }

        return (int) r;
    }
    public long cal(long a,long b,int op){
        if(op==-1) return a-b;
        else return a+b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package PartThree.Mid.q227BasicCalculatorIi;
//Java：基本计算器 II

import java.util.HashMap;
import java.util.Stack;

public class q227BasicCalculatorIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.calculate("1+2*3");
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);

        Stack<Long> numStack = new Stack<Long>();
        Stack<Character> optStack = new Stack<Character>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(Character.isDigit(c[i])){
                int tmp=Integer.parseInt(String.valueOf(c[i]));
                while ((i+1)<c.length&&Character.isDigit(c[i+1])){
                    tmp=tmp*10+Integer.parseInt(String.valueOf(c[++i]));
                }
                numStack.push((long) tmp);
            }else {
                while (!optStack.isEmpty()){
                    if((map.get(c[i])<=map.get(optStack.peek()))){
                        Long b=numStack.pop();
                        Long a=numStack.pop();
                        char opt=optStack.pop();
                        numStack.add(cal(a,b,opt));
                    }else {
                        break;
                    }
                }
                optStack.add(c[i]);
            }
        }
        while (!optStack.isEmpty()){
            Long b=numStack.pop();
            Long a=numStack.pop();
            char opt=optStack.pop();
            numStack.add(cal(a,b,opt));
        }
        long tmp=numStack.peek();
        return (int) tmp;
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

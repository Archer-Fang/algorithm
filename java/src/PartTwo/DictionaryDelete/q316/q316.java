package PartTwo.DictionaryDelete.q316;

import java.util.Stack;

/**
 * @author Created by Fangzj
 * @data 2021/3/30 20:45
 **/
class Solution {
    public String removeDuplicateLetters(String s) {
        //栈
        //如果入栈为a<stack.peel()，查找后面是否存在c，如果存在，则出栈，否则不出栈
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            if(stack.contains(s.charAt(i))) continue;
            while (!stack.isEmpty()&&s.charAt(i)<stack.peek()){
                int size=stack.size();
                for (int j=i+1;j<s.length();j++){
                    if(s.charAt(j)==stack.peek()) {stack.pop();break;}
                }
                if(size==stack.size()) break;
            }
            stack.add(s.charAt(i));
        }
        StringBuffer sb=new StringBuffer();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

public class q316 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.removeDuplicateLetters("bcabc"));
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
    }
}

package PartTwo.DictionaryDelete.q402;

import java.util.Stack;

/**
 * @author Created by Fangzj
 * @data 2021/3/30 19:37
 **/
class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        Stack<Character> stack=new Stack<>();
        int remain=num.length()-k;
        for (Character c:num.toCharArray()){
            while (k>0&&!stack.isEmpty()&&stack.peek()>c){
                stack.pop();
                k--;
            }
            if(c=='0'&&stack.isEmpty()) continue;
            stack.push(c);
        }
        StringBuffer sb2=new StringBuffer();
        //如果k没去干净，把尾巴去掉
        while (!stack.isEmpty()&&(k--)>0){
            stack.pop();
        }
        //结果倒叙
        while (!stack.isEmpty()&&(remain--)>0){
            sb2.append(stack.pop());
        }
        String ans=sb2.reverse().toString();
        return ans.equals("")?"0":ans;
    }
}

public class q402 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.removeKdigits("1432219",3));
        System.out.println(solution.removeKdigits("10200",1));
        System.out.println(solution.removeKdigits("10",1));
        System.out.println(solution.removeKdigits("112",1));
    }
}

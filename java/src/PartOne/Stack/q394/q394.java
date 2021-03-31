package PartOne.Stack.q394;

import java.util.Stack;

/**
 * @author Created by Fangzj
 * @data 2021/3/21 15:36
 **/
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack=new Stack<>();
        Stack<StringBuilder> AlphStack=new Stack<>();
        int num=0;
        StringBuilder ans=new StringBuilder();
        for (Character c:s.toCharArray()){
            if(Character.isDigit(c)) num=num*10+c-'0';
            if(Character.isAlphabetic(c)) ans.append(c);
            if(c=='['){
                numStack.push(num);
                AlphStack.push(ans);
                ans=new StringBuilder();
                num=0;
            }
            if(c==']'){
                StringBuilder ansTmp=AlphStack.pop();
                int digit=numStack.pop();
                for (int i=0;i<digit;i++){
                    ansTmp.append(ans);
                }
                ans=ansTmp;
            }
        }

        return ans.toString();



    }
}
public class q394 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.decodeString("3[a2[c]]"));
    }
}

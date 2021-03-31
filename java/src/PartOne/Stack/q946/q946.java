package PartOne.Stack.q946;

import java.util.Stack;

/**
 * @author Created by Fangzj
 * @data 2021/3/22 9:54
 **/
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length==0&&popped.length==0||(pushed.length==popped.length&&popped.length==1&&pushed[0]==popped[0])) return true;
        if(pushed.length!=popped.length) return false;
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
public class q946 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.validateStackSequences(new int[]{1,0},new int[]{1,0}));
    }
}

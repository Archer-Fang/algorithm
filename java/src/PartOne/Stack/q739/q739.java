package PartOne.Stack.q739;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Created by Fangzj
 * @data 2021/3/22 19:32
 **/
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] T2=new int[T.length+1];
        System.arraycopy(T,0,T2,0,T.length);
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[T.length];
        Arrays.fill(ans,0);
        for (int i=0;i<T2.length;i++){
            while (!stack.isEmpty()&&T2[i]>T2[stack.peek()]){
                int peek=stack.pop();
                ans[peek]=i-peek;
            }
            stack.push(i);
        }
        Arrays.stream(ans).forEach(System.out::println);
        return ans;
    }
}

public class q739 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
}

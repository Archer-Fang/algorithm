package QiuZhao.writtenExamination.XC.q3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Created by Fangzj
 * @data 2021/10/21 20:16
 **/
//3 4 1
//1+2+1
public class Main4 {
    public static void main(String[] args) {
        //单调栈。
        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        //存index
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int ans=0;
        for (int i = 1; i < nums.length; i++) {
            //如果大于当前元素，pop，加插值。

            if (!stack.isEmpty()&&nums[stack.peek()]>nums[i]){
                ans+=nums[stack.peek()]-nums[i];
                int pop = stack.pop();

                //下标连续，直接pop。
                while (!stack.isEmpty()&&(stack.peek()+1==pop)){
                    pop = stack.pop();
                }
            }
            while (!stack.isEmpty()&&nums[stack.peek()]>nums[i]){
                ans+=nums[stack.peek()];
                int pop = stack.pop();

                //下标连续，直接pop。
                while (!stack.isEmpty()&&(stack.peek()+1==pop)){
                    pop = stack.pop();
                }
            }

            stack.add(i);
        }
        ans+=nums[stack.peek()];
        System.out.println(ans);

    }
}

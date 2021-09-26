package PartOneReWrite.Heap.q739DailyTemperatures;

import java.util.Stack;

//Java：每日温度
public class q739DailyTemperatures{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                Integer pop = stack.pop();
                ans[pop]=i-pop;
            }
            stack.add(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

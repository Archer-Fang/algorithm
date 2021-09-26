package PartOneReWrite.Heap.q84LargestRectangleInHistogram;

import java.util.Stack;

//Java：柱状图中最大的矩形
public class q84LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int area=0;
        Stack<Integer> stack=new Stack<>();
        int[] new_heights=new int[heights.length+2];
        System.arraycopy(heights,0,new_heights,1,heights.length);
        for (int i=0;i<new_heights.length;i++){
            while (!stack.isEmpty()&&new_heights[i]<new_heights[stack.peek()]){
                int peek=stack.pop();
                area=Math.max(area,(i-stack.peek()-1)*new_heights[peek]);
            }
            stack.push(i);
        }
        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

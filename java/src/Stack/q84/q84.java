package Stack.q84;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Created by Fangzj
 * @data 2021/3/22 13:10
 **/
class Solution {
    public int largestRectangleArea2(int[] heights) {//暴力//超时 90/96
        if(heights.length==1) return heights[0];
        int area=0;
        for (int i=0;i<heights.length;i++){
            int min=heights[i];
            for (int j=i;j<heights.length;j++){
                min=Math.min(min,heights[j]);
                if(min==0){
                    area=Math.max(area,heights[j]);
                }else {
                    area=Math.max(area,(j-i+1)*min);
                }
            }
        }
        return area;
    }
//    public int largestRectangleArea(int[] heights) {
//        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
//        int[] tmp = new int[heights.length + 2];
//        System.arraycopy(heights, 0, tmp, 1, heights.length);
//
//        Deque<Integer> stack = new ArrayDeque<>();
//        int area = 0;
//        for (int i = 0; i < tmp.length; i++) {
//            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
//            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
//            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积🌶️ ～
//            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
//                int h = tmp[stack.pop()];
//                area = Math.max(area, (i - stack.peek() - 1) * h);
//            }
//            stack.push(i);
//        }
//
//        return area;
//    }
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
public class q84 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2,1,2}));
        System.out.println(solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(solution.largestRectangleArea(new int[]{2,4}));
        System.out.println(solution.largestRectangleArea(new int[]{0,9}));
        System.out.println(solution.largestRectangleArea(new int[]{9}));
        System.out.println(solution.largestRectangleArea(new int[]{9,0}));
    }
}

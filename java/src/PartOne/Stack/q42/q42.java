package PartOne.Stack.q42;

import java.util.Stack;

/**
 * @author Created by Fangzj
 * @data 2021/3/22 10:53
 **/
class Solution {
    //解法1
    public int trap1(int[] height) {
        int[] leftHeight=new int[height.length];
        int[] rightHeight=new int[height.length];
        int max=0;
        for(int i=0;i<height.length;i++){
            max=Math.max(max,height[i]);
            leftHeight[i]=max;
        }
        max=0;
        for(int i=height.length-1;i>=0;i--){
            max=Math.max(max,height[i]);
            rightHeight[i]=max;
        }
        int sum=0;
        for (int i=0;i<height.length;i++){
            sum+=Math.min(leftHeight[i],rightHeight[i])-height[i];
        }
        return sum;

    }
    //解法2
//    public int trap(int[] height) {
//        if (height == null) {
//            return 0;
//        }
//        PartOne.Stack<Integer> stack = new PartOne.Stack<>();
//        int ans = 0;
//        for (int i = 0; i < height.length; i++) {
//            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
//                int curIdx = stack.pop();
//                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
//                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
//                    stack.pop();
//                }
//                if (!stack.isEmpty()) {
//                    int stackTop = stack.peek();
//                    // stackTop此时指向的是此次接住的雨水的左边界的位置。右边界是当前的柱体，即i。
//                    // Math.min(height[stackTop], height[i]) 是左右柱子高度的min，减去height[curIdx]就是雨水的高度。
//                    // i - stackTop - 1 是雨水的宽度。
//                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
//                }
//            }
//            stack.add(i);
//        }
//        return ans;
//    }
    public int trap(int[] height) {
        int ans=0;
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<height.length;i++){
            while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int peek=stack.pop();
                if(!stack.isEmpty()){
                    ans+=(Math.min(height[i],height[stack.peek()])-height[peek])*(i-stack.peek()-1);
                }

            }
            stack.push(i);
        }
        return ans;
    }

}

public class q42 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}

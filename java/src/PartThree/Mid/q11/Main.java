package PartThree.Mid.q11;

/**
 * @author Created by Fangzj
 * @data 2021/5/8 11:16
 **/
class Solution {
    public int maxArea(int[] height) {
        int max=-1;
        int i=0,j=height.length-1;
        while (i<j){
            max=Math.max(max,Math.min(height[i],height[j])*(j-i));
            if(height[i]>height[j]){
                j--;
            }else {i++;}
        }
        return max;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}

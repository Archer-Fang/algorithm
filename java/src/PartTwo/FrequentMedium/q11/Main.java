package PartTwo.FrequentMedium.q11;

/**
 * @author Created by Fangzj
 * @data 2021/4/14 14:15
 **/
class Solution {
    public int maxArea(int[] height) {
        //双指针
        int max=-1;
        for (int i=0,j=height.length-1;i<=j;){
            max=Math.max(max,Math.min(height[i],height[j])*(j-i));
            if(height[i]<height[j]){
                i++;
            }else {j--;}
        }
        return max;
    }
}
public class Main {
}

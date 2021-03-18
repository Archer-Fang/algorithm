package SlideWindow.q1658;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/18 14:51
 **/
class Solution {
    public int minOperations(int[] nums, int x) {
        //保留最大的数组
        int arraySum= Arrays.stream(nums).sum()-x;
        if(arraySum<0) return -1;
        int i=0,max=-1;
        for (int j=0;j<nums.length;j++){
            arraySum-=nums[j];
            while (arraySum<0){
                arraySum+=nums[i++];
            }
            if(arraySum==0) max=Math.max(max,j-i+1);
        }
        if(max==-1) return max;
        return nums.length-max;
    }
}
public class q1658 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minOperations(new int[]{1,1,4,2,3},5));
        System.out.println(solution.minOperations(new int[]{5,6,7,8,9},4));
        System.out.println(solution.minOperations(new int[]{3,2,20,1,1,3},10));
        System.out.println(solution.minOperations(new int[]{1,1},3));
    }
}

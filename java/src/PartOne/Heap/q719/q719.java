package PartOne.Heap.q719;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/23 13:39
 **/
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lowDis=0;
        int highDis=nums[nums.length-1];
        while (lowDis<highDis){
            int midDis=lowDis+(highDis-lowDis)/2;
            int c=0;
            int left=0;
            for (int right=0;right<nums.length;right++){
                while (nums[right]-nums[left]>midDis) left++;
                c+=right-left;
            }
            if(c>=k){
                highDis=midDis;
            }else {
                lowDis=midDis+1;
            }
        }
        return lowDis;
    }

}

public class q719 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.smallestDistancePair(new int[]{1,3,1},1));
        System.out.println(solution.smallestDistancePair(new int[]{1,6,1},3));
    }
}

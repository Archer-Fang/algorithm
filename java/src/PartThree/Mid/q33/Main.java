package PartThree.Mid.q33;

/**
 * @author Created by Fangzj
 * @data 2021/5/8 15:57
 **/
class Solution {
    //二分
    public int search(int[] nums, int target) {
        return search(nums, target,0,nums.length-1);
    }
    public int search(int[] nums, int target,int left,int right) {
        while (left<=right){
            int mid=left+((right-left)>>1);
            if(nums[mid]==target) return mid;
            //左边有序
            if(nums[mid]>=nums[left]){
                if(target<=nums[mid]&&target>=nums[left]){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
            //右边有序
            else {
                if(target>=nums[mid]&&target<=nums[right]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }

            }
        }
        return -1;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2},4));
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2},0));
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2},3));
    }
}

package PartThree.Mid.q31;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/5/8 15:07
 **/
//1 2 3
//1 3 2
//2 1 3
//2 3 1
//3 1 2
//3 2 1
//从后面往前看，如果升序，则交换
//交换要找降序部分比降序前一个数字更大的数进行交换
//如果都为降序则输出从小到大
class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
        for (;i>0;i--){
            if(nums[i-1]<nums[i]){
                break;
            }
        }
        if(i==0){
            Arrays.sort(nums);
//            for (Integer a:nums){
//                System.out.print(a+" ");
//            }
//            System.out.println();
            return;
        }
        int k=i-1;
        int pos=-1;
        for (int j = nums.length-1; j >k ; j--) {
            if(nums[j]>nums[k]){
                pos=j;
                break;
            }
        }
        int tmp=nums[k];
        nums[k]=nums[pos];
        nums[pos]=tmp;
        Arrays.sort(nums,k+1,nums.length);
//        for (Integer a:nums){
//            System.out.print(a+" ");
//        }
//        System.out.println();
        return;

    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.nextPermutation(new int[]{1,2,3});
        solution.nextPermutation(new int[]{1,3,2});
        solution.nextPermutation(new int[]{2,1,3});
        solution.nextPermutation(new int[]{2,3,1});
        solution.nextPermutation(new int[]{3,1,2});
        solution.nextPermutation(new int[]{3,2,1});
    }
}

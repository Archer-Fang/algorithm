package PartThree.Mid.q80;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/5/11 9:47
 **/
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;
        Arrays.sort(nums);
        int k=0;
        int tmp=nums[0];
        int c=1;
        nums[k++]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=tmp){
                tmp=nums[i];
                c=1;
            }
            else if(c<2&&nums[i]==tmp){
                c++;
            }
            else if(c==2&&nums[i]==tmp){
                continue;
            }
            nums[k++]=nums[i];
        }
        return k;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(solution.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}

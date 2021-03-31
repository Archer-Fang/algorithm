package PartOne.SlideWindow.q1248;

/**
 * @author Created by Fangzj
 * @data 2021/3/17 21:59
 **/
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }

    public int atMost(int[] nums, int k){
        int ans=0;
        int i=0;
        for (int j=0;j<nums.length;j++){
            k-=nums[j]&1;
            while (k<0){
                k+=nums[i++]&1;
            }
            ans+=j-i+1;
        }
        return ans;
    }
}

public class q1248 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.numberOfSubarrays(new int[]{1,1,2,1,1},3));
    }
}

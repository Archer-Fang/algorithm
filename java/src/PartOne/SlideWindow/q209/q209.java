package PartOne.SlideWindow.q209;

/**
 * @author Created by Fangzj
 * @data 2021/3/15 19:38
 **/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int L=0;
        int ans=nums.length+1;
        for (int R=0;R<nums.length;R++){
            target-=nums[R];
            while (target<=0){
                ans=Math.min(ans,R-L+1);
                target+=nums[L];
                L++;
            }

        }
        return ans>nums.length?0:ans;
    }
}

public class q209 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}

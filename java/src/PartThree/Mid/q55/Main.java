package PartThree.Mid.q55;

/**
 * @author Created by Fangzj
 * @data 2021/5/10 19:46
 **/
class Solution {
    public boolean canJump(int[] nums) {
        int[] visit=new int[nums.length];
        visit[0]=1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0&&visit[i]==1){
                for (int k = i; k <= i+nums[i]&&k<nums.length; k++) {
                    visit[k]=1;
                }
            }
        }
        return visit[nums.length-1]==1;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.canJump(new int[]{3,2,1,0,4}));
    }
}

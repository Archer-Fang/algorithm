package PartThree.Mid.q75;

/**
 * @author Created by Fangzj
 * @data 2021/5/10 21:18
 **/
class Solution {
    //0,0,1,1,2,2
    public void sortColors(int[] nums) {
        int point1=0,cur=0,point2=nums.length-1;
        while (cur<=point2){
            if(nums[cur]==0){
                int tmp=nums[cur];
                nums[cur]=nums[point1];
                nums[point1]=tmp;
                point1++;
                cur++;
            }else if(nums[cur]==2){
                int tmp=nums[cur];
                nums[cur]=nums[point2];
                nums[point2]=tmp;
                point2--;
            }else {
                cur++;
            }
        }

    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.sortColors(new int[]{2,0,1});
    }
}

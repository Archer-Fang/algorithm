package Interview.qali.q912QuickSort;

/**
 * @author Created by Fangzj
 * @data 2021/4/23 20:30
 **/
class Solution {
    public int[] sortArray(int[] nums) {
        sortArray(nums,0,nums.length-1);
        return nums;
    }
    public void sortArray(int[] nums,int left,int right) {
        if(left>=right) return;
        int i=left,j=right,base=nums[left];

        while (i<j){
            while (i<j&&nums[j]>=base){
                j--;
            }
            while (i<j&&nums[i]<=base){
                i++;
            }
            if(i<j){
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
            }
        }
        nums[left]=nums[i];
        nums[i]=base;
        sortArray(nums,left,i-1);
        sortArray(nums,i+1,right);
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.sortArray(new int[]{5,2,3,1}));
    }
}

package PartFourCodeTop.q33SearchInRotatedSortedArray;
//Java：搜索旋转排序数组
public class q33SearchInRotatedSortedArray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.search(new int[]{3,1},1));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        //if(nums[start]<nums[mid])左边有序
        //if(nums[start]>nums[mid])右边有序
        return bisearch(nums,target,0,nums.length-1);
    }
    public int bisearch(int[] nums, int target,int start, int end) {
        while(start<=end) {
            int mid=start+((end-start)>>1);
            if(target==nums[mid]) { return mid; }
            //左边有序
            if(nums[start]<=nums[mid]) {
                if(target>=nums[start]&&target<=nums[mid]) {
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }
            //右边有序
            else  {
                if(target>=nums[mid]&&target<=nums[end]) {
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }

        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

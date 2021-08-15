package PartFourCodeTop.q704BinarySearch;
//Java：二分查找
public class q704BinarySearch{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.search(new int[]{-1,0,3,5,9,12},2));

    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int start=0, end = nums.length-1;
        return search(nums, target,start,end);
    }
    public int search(int[] nums, int target,int start, int end) {
        while(start<=end) {
            int mid=(end-start)/2+start;
            if(target==nums[mid]) { return mid; }
            if(target>nums[mid]) { return search(nums,target,mid+1,end); }
            if(target<nums[mid]) { return search(nums,target,start,mid-1); }

        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

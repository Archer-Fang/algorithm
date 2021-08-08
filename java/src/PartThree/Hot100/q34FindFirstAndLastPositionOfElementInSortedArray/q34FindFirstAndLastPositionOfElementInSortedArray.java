package PartThree.Hot100.q34FindFirstAndLastPositionOfElementInSortedArray;
//Java：在排序数组中查找元素的第一个和最后一个位置
public class q34FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.searchRange(new int[]{5,7,7,8,8,10},6));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                while (l<=mid&&nums[l]!=target) l++;
                while (r>=mid&&nums[r]!=target) r--;
                break;
            }else if(nums[mid]>target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return l<=r?new int[]{l,r}:new int[]{-1,-1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

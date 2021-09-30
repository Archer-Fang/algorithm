package DMSXL.DP.q977SquaresOfASortedArray;
//Java：有序数组的平方
public class q977SquaresOfASortedArray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int l=0,r=nums.length-1,k=r;
        int[] result = new int[nums.length];
        while (l<=r){
            if(nums[l]*nums[l]>=nums[r]*nums[r]){
                result[k--]=nums[l]*nums[l++];
            }else {
                result[k--]=nums[r]*nums[r--];
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

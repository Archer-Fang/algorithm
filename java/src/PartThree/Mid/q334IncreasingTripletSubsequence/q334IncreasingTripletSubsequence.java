package PartThree.Mid.q334IncreasingTripletSubsequence;
//Java：递增的三元子序列

public class q334IncreasingTripletSubsequence{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.increasingTriplet(new int[]{1,1,1});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=min1){
                min1=nums[i];
            }else if(nums[i]<=min2){
                min2=nums[i];
            }else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

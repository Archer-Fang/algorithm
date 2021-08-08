package PartFourCodeTop.q15ThreeSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
// 4 1 8 4 5 5 0 1 8 4 5
// 5 0 1 8 4 5 4 1 8 4 5
//Java：三数之和
public class q15ThreeSum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        for (int p1 = 0; p1 < nums.length - 2; p1++) {
            if(p1>0&&nums[p1]==nums[p1-1]) continue;
            int p2=p1+1;
            int p3=nums.length-1;
            while (p2<p3){
                if(nums[p1]+nums[p2]+nums[p3]==0){
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[p1]);
                    list.add(nums[p2]);
                    list.add(nums[p3]);
                    lists.add(list);
                    while (p2<p3&&nums[p2]==nums[++p2]) continue;
                    while (p2<p3&&nums[p3]==nums[--p3]) continue;
                }else if(nums[p1]+nums[p2]+nums[p3]>0){
                    p3--;
                }else{
                    p2++;
                }
            }
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

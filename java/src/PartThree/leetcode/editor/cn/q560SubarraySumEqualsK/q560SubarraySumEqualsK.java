package PartThree.leetcode.editor.cn.q560SubarraySumEqualsK;
//Java：和为K的子数组

import java.util.HashMap;

public class q560SubarraySumEqualsK{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.subarraySum(new int[]{1,1,1},2);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        //preSum
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum=0;
        int c=0;
        map.put(0,1);
        for (int num : nums) {
            preSum+=num;
            if(map.containsKey(preSum-k)){
                c+=map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

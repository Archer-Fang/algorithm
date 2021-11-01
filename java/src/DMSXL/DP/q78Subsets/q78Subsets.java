package DMSXL.DP.q78Subsets;

import java.util.LinkedList;
import java.util.List;

//Java：子集
public class q78Subsets{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> r=new LinkedList<>();
    List<Integer> p=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums,0);
        r.add(new LinkedList<>());
        return r;
    }

    private void backtrace(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            p.add(nums[i]);
            r.add(new LinkedList<>(p));
            backtrace(nums,i+1);
            p.remove(p.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

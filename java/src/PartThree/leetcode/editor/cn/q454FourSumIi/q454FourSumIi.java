package PartThree.leetcode.editor.cn.q454FourSumIi;
//Java：四数相加 II

import java.util.HashMap;

public class q454FourSumIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Long, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            for (int i1 : nums2) {
                long tmp=i+i1;
                map1.put(tmp,map1.getOrDefault(tmp,0)+1);
            }
        }
        int ans=0;
        for (int i : nums3) {
            for (int i1 : nums4) {
                long tmp=i+i1;
                ans+=map1.getOrDefault(-tmp,0);
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

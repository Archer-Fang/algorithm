package PartThree.leetcode.editor.cn.q128LongestConsecutiveSequence;

import java.util.HashMap;

//Java：最长连续序列
public class q128LongestConsecutiveSequence{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //O(Nlog(N))
//    public int longestConsecutive(int[] nums) {
//        if(nums.length==0) return 0;
//        int[] dp=new int[nums.length];
//        Arrays.fill(dp,1);
//        Arrays.sort(nums);
//        int ans=1;
//        int c=1;
//        for (int i = 1; i < nums.length; i++) {
//            if(nums[i]==nums[i-1]) continue;
//            if(nums[i]==1+nums[i-1]) {c++;ans=Math.max(ans,c);}
//            else c=1;
//        }
//        return ans;
//    }
    //O(N)
    public int longestConsecutive(int[] nums) {
        int ans=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(!map.containsKey(num)){
                int leftL=map.getOrDefault(num-1,0);
                int rightL=map.getOrDefault(num+1,0);
                int length=1+leftL+rightL;
                map.put(num,length);
                map.put(num-leftL,length);
                map.put(num+rightL,length);
                ans=Math.max(ans,length);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

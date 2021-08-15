package PartFourCodeTop.q46Permutations;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

//Java：全排列
public class q46Permutations{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        int[] ints = {1, 2, 3};
        solution.permute(ints);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists=new LinkedList();
        ArrayDeque<Integer> ans=new ArrayDeque<>();
        int[] visit=new int[nums.length];
        dfs(nums, visit,lists,ans);
        return lists;
    }
    public void dfs(int[] nums,int[] visit,List<List<Integer>> lists,ArrayDeque<Integer> ans){
        if(ans.size()==nums.length){
            lists.add(new LinkedList(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visit[i]!=1){
                visit[i]=1;
                ans.add(nums[i]);
                dfs(nums, visit,lists,ans);
                visit[i]=0;
                ans.removeLast();
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

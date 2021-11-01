package DMSXL.DP.q40CombinationSumIi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：组合总和 II
public class q40CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.combinationSum2(new int[]{1,1,2},3);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> r=new LinkedList<>();
    List<Integer> p=new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] flag = new boolean[candidates.length];
        backtrace(candidates,target,0,flag);
        return r;
    }

    private void backtrace(int[] candidates, int target, int start, boolean[] flag) {
        if(target==0){
            r.add(new LinkedList<>(p));
        }
        for (int i = start; i < candidates.length&&target-candidates[i]>=0; i++) {
            if(i>0&&candidates[i]==candidates[i-1]&& !flag[i - 1]){
                continue;
            }
            flag[i]=true;
            p.add(candidates[i]);
            backtrace(candidates,target-candidates[i],i+1, flag);
            p.remove(p.size()-1);
            flag[i]=false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

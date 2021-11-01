package DMSXL.DP.q216CombinationSumIii;

import java.util.LinkedList;
import java.util.List;

//Java：组合总和 III
public class q216CombinationSumIii{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
//        solution.combinationSum3(3,7);
        solution.combinationSum3(9,45);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> r=new LinkedList<>();
    List<Integer> p=new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrace(k,n,0);
        return r;
    }

    private void backtrace(int k, int n, int start) {
        if(n==0&&k==0){
            r.add(new LinkedList<>(p));
        }
        for (int i = start; i < 9; i++) {
            p.add(i+1);
            if(n-i-1>=0&&k-1>=0){
                backtrace(k-1,n-1-i,i+1);
            }
            p.remove(p.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

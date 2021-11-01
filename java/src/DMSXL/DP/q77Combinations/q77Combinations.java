package DMSXL.DP.q77Combinations;

import java.util.LinkedList;
import java.util.List;

//Java：组合
public class q77Combinations{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.combine(4,2);

    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> r=new LinkedList<>();
    List<Integer> p=new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrace(0,n,k);
        return r;
    }
    private void backtrace(int i, int n, int k) {
        if(p.size()==k){
            r.add(new LinkedList<>(p));
        }
        for(;i+(k-p.size())<=n;i++){
            p.add(i+1);
            if(p.size()<=k){
                backtrace(i+1,n,k);
            }
            p.remove(p.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

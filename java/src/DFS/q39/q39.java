package DFS.q39;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Created by Fangzj
 * @data 2021/3/14 21:49
 **/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new LinkedList<>();
        LinkedList<Integer> oneAns = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,ans,0,oneAns);
        return ans;
    }

    public void dfs(int[] candidates, int target,List<List<Integer>> ans,int index,LinkedList<Integer> oneAns){
        if(target==0) {ans.add(new ArrayList<>(oneAns));return;}
        if(target<0) return;
        for(int i=index;i<candidates.length;i++){
            if(candidates[i]>target) return;
            oneAns.add(candidates[i]);
            dfs(candidates,target-candidates[i],ans,i,oneAns);
            oneAns.removeLast();
        }
        return;
    }
}

public class q39 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] candidates={2,3,6,7};
        System.out.println(solution.combinationSum(candidates,7));
    }
}

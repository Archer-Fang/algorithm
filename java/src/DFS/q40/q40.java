package DFS.q40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/3/14 22:49
 **/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(i>index&&candidates[i]==candidates[i-1]){
                continue;
            }
            oneAns.add(candidates[i]);
            dfs(candidates,target-candidates[i],ans,i+1,oneAns);
            oneAns.removeLast();


        }
        return;
    }
}
public class q40 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] candidates={2,2,2};
        System.out.println(solution.combinationSum2(candidates,2));

    }
}

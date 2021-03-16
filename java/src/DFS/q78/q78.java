package DFS.q78;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/3/15 16:57
 **/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new LinkedList<>();
        List<Integer> path=new LinkedList<>();
        dfs(nums,0,path,ans);
        return ans;
    }

    public void dfs(int[] nums,int index,List<Integer> path,List<List<Integer>> ans){
        ans.add(new LinkedList<>(path));
        for (int i=index;i<nums.length;i++){
            path.add(nums[i]);
            dfs(nums,i+1,path,ans);
            path.remove(path.size()-1);
        }
        return;
    }
}
public class q78 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.subsets(new int[]{1,2,3}));
    }
}

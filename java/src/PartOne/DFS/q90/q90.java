package PartOne.DFS.q90;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/3/15 17:18
 **/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new LinkedList<>();
        List<Integer> path=new LinkedList<>();
        Arrays.sort(nums);
        dfs(nums,0,path,ans);
        return ans;
    }

    public void dfs(int[] nums,int index,List<Integer> path,List<List<Integer>> ans){
        ans.add(new LinkedList<>(path));
        for (int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            dfs(nums,i+1,path,ans);
            path.remove(path.size()-1);
        }
        return;
    }
}
public class q90 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1,2,2}));
    }
}
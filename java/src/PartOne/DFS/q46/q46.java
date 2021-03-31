package PartOne.DFS.q46;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/3/14 23:13
 **/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new LinkedList<>();
        ArrayDeque<Integer> path=new ArrayDeque<>();
        int[] visited=new int[nums.length];
        Arrays.fill(visited,0);
        dfs(nums,ans,path,visited);
        return ans;

    }
    public void dfs(int[] nums, List<List<Integer>> ans, ArrayDeque<Integer> path,int[] visited){
        if(path.size()==nums.length){
            ans.add(new LinkedList<>(path));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if(visited[i]==0){
                visited[i]=1;
                path.add(nums[i]);
                dfs(nums,ans,path,visited);
                path.removeLast();
                visited[i]=0;
            }
        }
        return;
    }
}
public class q46 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.permute(new int[]{1,1,2}));
    }
}

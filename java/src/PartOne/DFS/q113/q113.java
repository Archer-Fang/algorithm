package PartOne.DFS.q113;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/3/15 17:18
 **/

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new LinkedList<>();
        List<Integer> path=new LinkedList<>();
        dfs(root,targetSum,ans,path);
        return ans;
    }
    public void dfs(TreeNode root, int targetSum,List<List<Integer>> ans,List<Integer> path){

        if(root==null) return;

        targetSum-=root.val;
        path.add(root.val);
        if(targetSum==0&&root.left==null&&root.right==null) {
            ans.add(new LinkedList<>(path));
        }
        dfs(root.left,targetSum,ans,path);
        path.remove(path.size()-1);
        path.add(root.val);
        dfs(root.right,targetSum,ans,path);
        path.remove(path.size()-1);
    }
}
public class q113 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode t1=new TreeNode(-2);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(-3);
//        t1.left=t2;
        t1.right=t3;
        System.out.println(solution.pathSum(t1,-5));
    }
}
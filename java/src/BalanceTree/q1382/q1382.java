package BalanceTree.q1382;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/3/21 15:08
 **/
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> l=new ArrayList<>();
        dfs(root,l);
        return balanceBST(l,0,l.size()-1);
    }
    public void dfs(TreeNode root, List<Integer> l){
        if(root==null) return;
        dfs(root.left,l);
        l.add(root.val);
        dfs(root.right,l);
    }
    public TreeNode balanceBST(List<Integer> l,int left,int right) {
        if(left>right) return null;
        int mid=left+(right-left)/2;
        TreeNode t1=new TreeNode(l.get(mid));
        t1.left=balanceBST(l,left,mid-1);
        t1.right=balanceBST(l,mid+1,right);
        return t1;
    }
}
public class q1382 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        t1.right=t2;
        t2.right=t3;
        t3.right=t4;
        System.out.println(solution.balanceBST(t1));
        List<Integer> tmp=new ArrayList<>();
        tmp.add(1);
        tmp.add(2);
        System.out.println(tmp);
    }
}

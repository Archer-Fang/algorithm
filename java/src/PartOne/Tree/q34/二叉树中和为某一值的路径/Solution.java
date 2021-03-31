package PartOne.Tree.q34.二叉树中和为某一值的路径;

import java.util.LinkedList;
import java.util.List;


class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root,sum);
        return res;
    }
    void recur(TreeNode root, int sum){
        if(root==null) return;
        sum-=root.val;
        path.add(root.val);
        if(root.right==null &root.left==null& sum==0){
            res.add(new LinkedList<>(path));
        }
        recur(root.left,sum);
        recur(root.right,sum);
        path.removeLast();
    }
}

class Main{
    public static void main(String[] args) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        TreeNode t5=new TreeNode(5);
        TreeNode t4=new TreeNode(4);
        TreeNode t7=new TreeNode(7);
        TreeNode t11=new TreeNode(11);
        TreeNode t2=new TreeNode(2);
        t5.left=t4;
        t4.left=t11;
        t11.left=t7;
        t11.right=t2;
        Solution solution=new Solution();
        System.out.println(solution.pathSum(t5,22));
    }
}

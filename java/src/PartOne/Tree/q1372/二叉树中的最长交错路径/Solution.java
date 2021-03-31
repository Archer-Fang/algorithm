package PartOne.Tree.q1372.二叉树中的最长交错路径;

import java.util.LinkedList;
import java.util.List;


class Solution {
    int max=0;
    public int longestZigZag(TreeNode root) {
        //direction>0向右
        recur(root,0,-1);
        recur(root,0,1);

        return max;
    }

    void recur(TreeNode root, int step,int direction){
        if(root==null) return;
        max=max>step?max:step;
        if(direction>0){
            recur(root.left,step+1,-1);
            recur(root.right,1,1);

        }else {
            recur(root.right,step+1,1);
            recur(root.left,1,-1);
        }
    }
}

class Main{
    public static void main(String[] args) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        TreeNode t1=new TreeNode(5);
        TreeNode t2=new TreeNode(4);
        TreeNode t3=new TreeNode(7);
        TreeNode t4=new TreeNode(11);
        TreeNode t5=new TreeNode(2);
        TreeNode t6=new TreeNode(2);
        TreeNode t7=new TreeNode(2);
        TreeNode t8=new TreeNode(2);
        t1.right=t2;
        t2.left=t3;
        t2.right=t4;
        t4.left=t5;
        t4.right=t6;
        t5.right=t7;
        t7.right=t8;
        Solution solution=new Solution();
        System.out.println(solution.longestZigZag(t1));
    }
}

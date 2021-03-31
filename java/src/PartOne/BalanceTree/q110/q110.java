package PartOne.BalanceTree.q110;

/**
 * @author Created by Fangzj
 * @data 2021/3/21 14:25
 **/
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(getDeep(root.left,0)-getDeep(root.right,0))>1) return false;
        return isBalanced(root.left)&isBalanced(root.right);
    }
    public int getDeep(TreeNode root,int deep){
        if(root==null) return deep;
        int l=getDeep(root.left,deep+1);
        int r=getDeep(root.right,deep+1);
        return Math.max(l,r);
    }
}

public class q110 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;

        System.out.println(solution.isBalanced(t1));
    }
}

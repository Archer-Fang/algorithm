package PartThree.Mid.q236LowestCommonAncestorOfABinaryTree;
//Java：二叉树的最近公共祖先

public class q236LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode3.left=treeNode5;
        treeNode5.left=treeNode6;
        treeNode5.right=treeNode2;
        treeNode2.left=treeNode7;
        treeNode2.right=treeNode4;
        treeNode3.right=treeNode1;
        treeNode1.left=treeNode0;
        treeNode1.right=treeNode8;
        solution.lowestCommonAncestor(treeNode3,treeNode5,treeNode4);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        if(root.val==p.val||root.val==q.val) return root;
        TreeNode l=lowestCommonAncestor(root.left,p,q);
        TreeNode r=lowestCommonAncestor(root.right,p,q);
        if(l!=null&&r!=null) return root;
        else if(l==null&&r!=null) return r;
        else if(l!=null&&r==null) return l;
        else return null;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

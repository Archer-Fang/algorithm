package DMSXL.DP.q106ConstructBinaryTreeFromInorderAndPostorderTraversal;
//Java：从中序与后序遍历序列构造二叉树
public class q106ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder,int l1,int r1,int l2,int r2) {
        if(l1>r1||l2>r2) return null;
        // l m r
        // l r m
        int m=l1;
        for ( m = l1; m <= r1; m++) {
            if(inorder[m]!=postorder[m]) break;
        }
        TreeNode root = new TreeNode(inorder[m]);
        root.left=buildTree(inorder,postorder,l1,m-1,l2,m-1);
        root.right=buildTree(inorder,postorder,m+1,r1,m,r2-1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

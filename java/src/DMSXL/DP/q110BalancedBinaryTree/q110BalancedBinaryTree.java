package DMSXL.DP.q110BalancedBinaryTree;
//Java：平衡二叉树
public class q110BalancedBinaryTree{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
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
    public boolean isBalanced(TreeNode root) {
        int r=afterOrder(root);
        return r!=-1;
    }

    private int afterOrder(TreeNode root) {
        if(root==null) return 0;
        int l=afterOrder(root.left);
        if(l==-1) return -1;
        int r=afterOrder(root.right);
        if(r==-1) return -1;
        return Math.abs(l-r)>1?-1:1+Math.max(l,r);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

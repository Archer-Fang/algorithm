package DMSXL.DP.q236LowestCommonAncestorOfABinaryTree;
//Java：二叉树的最近公共祖先
public class q236LowestCommonAncestorOfABinaryTree{
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
 *     TreeNode(int x) { val = x; }
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == q || root == p || root == null) return root;
        TreeNode l = dfs(root.left, p, q);
        TreeNode r = dfs(root.right, p, q);
        if(l!=null&&r!=null) return root;
        if(l!=null) return l;
        if(r!=null) return r;
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

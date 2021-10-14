package DMSXL.DP.q235LowestCommonAncestorOfABinarySearchTree;
//Java：二叉搜索树的最近公共祖先
public class q235LowestCommonAncestorOfABinarySearchTree{
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
        if(root==null) return root;
        if(root.val>q.val&&root.val>p.val) {
            TreeNode l = dfs(root.left, p, q);
            if(l!=null) return l;
        }
        if(root.val<p.val&&root.val<q.val) {
            TreeNode r = dfs(root.right, p, q);
            if(r!=null) return r;
        }

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

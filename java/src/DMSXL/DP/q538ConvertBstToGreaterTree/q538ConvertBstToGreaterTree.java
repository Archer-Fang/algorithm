package DMSXL.DP.q538ConvertBstToGreaterTree;
//Java：把二叉搜索树转换为累加树
public class q538ConvertBstToGreaterTree{
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
    int pre=0;
    public TreeNode convertBST(TreeNode root) {
        return dfs(root);
    }
    private TreeNode dfs(TreeNode root) {
        if(root==null) return null;
        root.right=dfs(root.right);
        root.val+=pre;
        pre=root.val;
        root.left=dfs(root.left);
        return root;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

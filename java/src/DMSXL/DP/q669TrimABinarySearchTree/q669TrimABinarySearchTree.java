package DMSXL.DP.q669TrimABinarySearchTree;
//Java：修剪二叉搜索树
public class q669TrimABinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.right=node2;
        solution.trimBST(node1,2,4);
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode ans=dfs(root,low,high);
        return ans;
    }

    private TreeNode dfs(TreeNode root, int low, int high) {
        if(root==null) return root;
        root.left=dfs(root.left,low,high);
        root.right=dfs(root.right,low,high);
        if(root.val<low) {
            if(root.right!=null&&root.right.val>=low&&root.right.val<=high) return root.right;
            else return null;
        }
        if(root.val>high) {
            if(root.left!=null&&root.left.val>=low&&root.left.val<=high) return root.left;
            else return null;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

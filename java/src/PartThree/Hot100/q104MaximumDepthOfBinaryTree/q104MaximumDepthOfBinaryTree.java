package PartThree.Hot100.q104MaximumDepthOfBinaryTree;
//Java：二叉树的最大深度
public class q104MaximumDepthOfBinaryTree{
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
    int deep=0;
    public int maxDepth(TreeNode root) {
        dfs(root,0);
        return deep;
    }

    private void dfs(TreeNode root,int d) {
        if(root==null){
            deep=Math.max(deep,d);
            return;
        }
        dfs(root.left,d+1);
        dfs(root.right,d+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

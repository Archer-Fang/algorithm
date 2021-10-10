package DMSXL.DP.q226InvertBinaryTree;
//Java：翻转二叉树
public class q226InvertBinaryTree{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
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
    public TreeNode invertTree(TreeNode root) {
        preOrder(root);
        return root;
    }

    private void preOrder(TreeNode root) {
        if(root==null) return;
        TreeNode l=root.left;
        root.left=root.right;
        root.right=l;
        preOrder(root.left);
        preOrder(root.right);
        return;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

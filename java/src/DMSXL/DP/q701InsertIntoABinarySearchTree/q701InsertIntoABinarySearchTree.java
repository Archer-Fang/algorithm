package DMSXL.DP.q701InsertIntoABinarySearchTree;
//Java：二叉搜索树中的插入操作
public class q701InsertIntoABinarySearchTree{
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return dfs(root,val);
    }

    private TreeNode dfs(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        if(root.val>val){
            root.left=dfs(root.left,val);
        }else if(root.val<val){
            root.right=dfs(root.right,val);
        }
        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

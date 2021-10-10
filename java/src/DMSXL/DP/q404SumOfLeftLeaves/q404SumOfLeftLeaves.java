package DMSXL.DP.q404SumOfLeftLeaves;
//Java：左叶子之和
public class q404SumOfLeftLeaves{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        solution.sumOfLeftLeaves(node1);
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
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if(root==null) return 0;
        int l=dfs(root.left);
        int r=dfs(root.right);
        int cur=0;
        if(root.left!=null&&root.left.left==null&&root.left.right==null) cur= root.left.val;
        return cur+l+r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

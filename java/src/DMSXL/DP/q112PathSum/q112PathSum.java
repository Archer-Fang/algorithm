package DMSXL.DP.q112PathSum;
//Java：路径总和
public class q112PathSum{
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,0,targetSum);
    }

    private boolean dfs(TreeNode root, int curSum,int targetSum) {
        if(root==null) return false;
        curSum+=root.val;
        if(root.left==null&&root.right==null) return curSum==targetSum;
        boolean l=dfs(root.left,curSum,targetSum);
        boolean r=dfs(root.right,curSum,targetSum);

        return l||r;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

package PartThree.Mid.q230KthSmallestElementInABst;
//Java：二叉搜索树中第K小的元素

public class q230KthSmallestElementInABst{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode3.right=treeNode4;
        treeNode3.left=treeNode1;
        treeNode1.right=treeNode2;
        solution.kthSmallest(treeNode3,1);

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
    int ans=-1,c=-1;
    public int kthSmallest(TreeNode root, int k) {
        c=k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if(root==null||c==0) return;
        dfs(root.left);
        c--;
        if(c==0){
            ans=root.val;
            return;
        }
        dfs(root.right);
        return;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

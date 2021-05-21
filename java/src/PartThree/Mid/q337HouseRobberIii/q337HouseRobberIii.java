package PartThree.Mid.q337HouseRobberIii;
//Java：打家劫舍 III

public class q337HouseRobberIii{
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
    public int rob(TreeNode root) {
//        int[] result=new int[2];
//        result[0]=Math.max(root.left[0],root.left[1])+Math.max(root.right[0],root.right[1]);
//        result[1]=root.val+root.left[0]+root.right[0];
        int[] result=dfs(root);
        return Math.max(result[0],result[1]);
    }

    private int[] dfs(TreeNode root) {
        if(root==null) return new int[2];
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        int[] result=new int[2];
        result[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        result[1]=root.val+left[0]+right[0];
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

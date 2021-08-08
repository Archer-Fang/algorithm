package PartThree.Hot100.q437PathSumIii;
//Java：路径总和 III
public class q437PathSumIii{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left=node2;
        node2.left=node3;
        node3.left=node4;
        node4.left=node5;
        solution.pathSum(node1,3);
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
    int c=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        dfs(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return c;
    }

    private void dfs(TreeNode root, int targetSum) {
        if(root==null) return ;
        if(targetSum==root.val) {
            c++;
        }
        dfs(root.left,targetSum-root.val);
        dfs(root.right,targetSum-root.val);


    }

}
//leetcode submit region end(Prohibit modification and deletion)

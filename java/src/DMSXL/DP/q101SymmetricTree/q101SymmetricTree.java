package DMSXL.DP.q101SymmetricTree;

//Java：对称二叉树
public class q101SymmetricTree{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        TreeNode node1= new TreeNode(1);
        TreeNode node2= new TreeNode(2);
        TreeNode node22= new TreeNode(2);
        TreeNode node3= new TreeNode(3);
        TreeNode node33= new TreeNode(3);
        TreeNode node4= new TreeNode(4);
        TreeNode node44= new TreeNode(4);

        TreeNode node5= new TreeNode(5);
        TreeNode node55= new TreeNode(5);
        TreeNode node6= new TreeNode(6);
        TreeNode node66= new TreeNode(6);

        node1.left=node2;
        node1.right=node22;
        node2.left=node3;
        node2.right=node44;
        node22.right=node33;
        node22.left=node4;
        node3.left=node5;
        node3.right=node6;
        node33.left=node66;
        node33.right=node55;

        solution.isSymmetric(node1);
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

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode root,TreeNode root2) {
        if(root==null&&root2==null) return true;
        if(root==null||root2==null) return false;
        if(root.val!=root2.val) return false;
        return isSymmetric(root.left,root2.right)&&isSymmetric(root.right,root2.left);
    }



}
//leetcode submit region end(Prohibit modification and deletion)

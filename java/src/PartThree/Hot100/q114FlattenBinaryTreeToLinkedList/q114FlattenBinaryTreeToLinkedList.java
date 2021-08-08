package PartThree.Hot100.q114FlattenBinaryTreeToLinkedList;

//Java：二叉树展开为链表
public class q114FlattenBinaryTreeToLinkedList{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left=node2;
        node2.left=node3;
        node2.right=node4;
        node1.right=node5;
        node5.right=node6;
        solution.flatten(node1);
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
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    TreeNode pre=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right=pre;
        root.left=null;
        pre=root;
        return;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

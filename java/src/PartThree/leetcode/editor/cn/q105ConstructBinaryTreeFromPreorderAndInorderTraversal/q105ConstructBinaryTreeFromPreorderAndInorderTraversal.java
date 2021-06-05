package PartThree.leetcode.editor.cn.q105ConstructBinaryTreeFromPreorderAndInorderTraversal;

//Java：从前序与中序遍历序列构造二叉树
public class q105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder,int l1,int r1,int l2,int r2) {
        if(l1>r1||l2>r2||l1<0) return null;
        TreeNode root = new TreeNode(preorder[l1]);
        int iMid=l2;
        while (inorder[iMid]!=preorder[l1]){
            iMid++;
        }
        root.left=buildTree(preorder,inorder,l1+1,l1+iMid-l2,l2,iMid-1);
        root.right=buildTree(preorder,inorder,l1+iMid-l2+1,r1,iMid+1,r2);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

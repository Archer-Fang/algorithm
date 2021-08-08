package PartFourCodeTop.q236LowestCommonAncestorOfABinaryTree;
//Java：二叉树的最近公共祖先
public class q236LowestCommonAncestorOfABinaryTree{
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
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.p 和 q 在 root 的子树中，且分列 root的 异侧（即分别在左、右子树中）；
        //2.p = root ，且 q 在 root 的左或右子树中；
        //3.q = root，且 p 在 root 的左或右子树中；
        if(root==null) return root;
        if(root.val==p.val||root.val==q.val) return root;
        TreeNode l=lowestCommonAncestor(root.left,p,q);
        TreeNode r=lowestCommonAncestor(root.right,p,q);
        if(l!=null&&r!=null) return root;
        else if(l==null&&r!=null) return r;
        else if(l!=null&&r==null) return l;
        else return null;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

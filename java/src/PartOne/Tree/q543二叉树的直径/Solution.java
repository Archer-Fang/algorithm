package PartOne.Tree.q543二叉树的直径;

class Solution {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    public int depth(TreeNode root) {
        if(root==null) return 0;

        int left=depth(root.left);
        int right=depth(root.right);
        max=max>(left+right)?max:(left+right);
        return left>right?left+1:right+1;
    }
}

class Main{
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        t2.left=t3;
        t3.left=t1;

        Solution solution=new Solution();
        System.out.println(solution.diameterOfBinaryTree(t2));
    }
}

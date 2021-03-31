package PartOne.Tree.q1002.从根到叶的二进制数之和;

class Solution {
    public int sumRootToLeaf(TreeNode root) {

        return sumRootToLeaf(root,0);

    }
    public int sumRootToLeaf(TreeNode root,int num) {
        if(root==null) return 0;
        num+=root.val;
        if(root.left==null&root.right==null) return num;

        return sumRootToLeaf(root.left,num*2)+sumRootToLeaf(root.right,num*2);
    }

}

class Main{
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(1);
        TreeNode t3=new TreeNode(1);
        t1.left=t2;
        t1.right=t3;
        Solution solution=new Solution();
        System.out.println(solution.sumRootToLeaf(t1));
    }
}

package PartOne.Tree.q1325删除给定值的叶子节点;

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode virtualNode=new TreeNode(-1);
        virtualNode.left=root;
        dfs(root,virtualNode,target,true);
        return virtualNode.left;

    }
    public void dfs(TreeNode root,TreeNode parent, int target,Boolean isLeft){
        if(root==null) return;
        dfs(root.left,root,target,true);
        dfs(root.right,root,target,false);
        if(root.left==null&root.right==null&root.val==target){
            if(isLeft) parent.left=null;
            else parent.right=null;
        }
    }
}

class Main{
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(2);
        TreeNode t5=new TreeNode(2);
        TreeNode t6=new TreeNode(4);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t3.left=t5;
        t3.right=t6;
        Solution solution=new Solution();
        System.out.println(solution.removeLeafNodes(t1,2));
    }
}

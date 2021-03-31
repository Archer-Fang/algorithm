package PartOne.Tree.q1026节点与其祖先之间的最大差值;

class Solution {
    int ans=Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        dsf(root,10001,0);
        return ans;
    }

    public void dsf(TreeNode root,int lower,int upper){
        if(root==null) return;
        int min=Math.min(lower,root.val);
        int max=Math.max(upper,root.val);
        ans=(max-min)>ans?(max-min):ans;
        dsf(root.left,min,max);
        dsf(root.right,min,max);

    }
}

class Main{
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(0);
        TreeNode t4=new TreeNode(3);
        t1.left=t2;
        t2.left=t3;
        t3.right=t4;
        Solution solution=new Solution();
        System.out.println(solution.maxAncestorDiff(t1));
    }
}

package PartOne.Tree.q865.具有所有最深节点的最小子树;

class Result {
    TreeNode node;
    int dist;
    Result(TreeNode n, int d) {
        node = n;
        dist = d;
    }
}

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode tmp=getDeep(root,0).node;
        return tmp;
    }
    public Result getDeep(TreeNode root,int deep){
        if(root==null) return  new Result(null,deep);
        Result l=getDeep(root.left,deep+1);
        Result r=getDeep(root.right,deep+1);
        if(l.dist!=r.dist){
            return l.dist>r.dist?l:r;
        }
        else return new Result(root,l.dist);
    }
}

class Main{
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(3);
        TreeNode t2=new TreeNode(5);
        TreeNode t3=new TreeNode(1);
        TreeNode t4=new TreeNode(6);
        TreeNode t5=new TreeNode(2);
        TreeNode t6=new TreeNode(0);
        TreeNode t7=new TreeNode(8);
        TreeNode t8=new TreeNode(7);
        TreeNode t9=new TreeNode(4);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        t5.left=t8;
        t5.right=t9;

        Solution solution=new Solution();
        System.out.println(solution.subtreeWithAllDeepest(t1));
    }
}
